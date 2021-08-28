package com.guardlbt.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.guardlbt.common.util.PageResult;
import com.guardlbt.common.util.Result;
import com.guardlbt.dao.BusinessDistrictDao;
import com.guardlbt.dao.MemberDao;
import com.guardlbt.dao.ShopDao;
import com.guardlbt.dao.ShopUserDao;
import com.guardlbt.dto.ApplyShopDto;
import com.guardlbt.dto.BusinessDistrictPageDto;
import com.guardlbt.dto.SaveUserInfoDto;
import com.guardlbt.entity.BusinessDistrict;
import com.guardlbt.entity.Member;
import com.guardlbt.entity.Shop;
import com.guardlbt.entity.ShopUser;
import com.guardlbt.eum.Role;
import com.guardlbt.eum.ShopStatusEnum;
import com.guardlbt.service.WxMyService;
import com.guardlbt.vo.BusinessDistrictPageVo;
import com.guardlbt.vo.ShopsVo;
import com.guardlbt.vo.UserInfoVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class WxMyServiceImpl implements WxMyService {
    @Autowired
    private ShopUserDao shopUserDao;
    @Autowired
    private MemberDao memberDao;
    @Autowired
    private ShopDao shopDao;
    @Autowired
    private BusinessDistrictDao businessDistrictDao;

    @Override
    public Result<Role> getRole(String openid) {
        ShopUser shopUser = new ShopUser();
        shopUser.setOpenId(openid);
        List<ShopUser> shopUsers = shopUserDao.selectShopUsers(shopUser);
        if (shopUsers.isEmpty()) {
            return Result.ok(Role.MEMBER);
        }
        for (Role role : Role.values()) {
            if (role.getState() == shopUsers.get(0).getRole()) {
                return Result.ok(role);
            }
        }
        return Result.ok();
    }

    @Override
    public Result<UserInfoVo> userInfo(String openid) {
        //查看会员表中的信息
        Member member = new Member();
        member.setOpenId(openid);
        List<Member> members = memberDao.selectMembers(member);
        if (members.isEmpty()) {
            UserInfoVo vo = new UserInfoVo();
            BeanUtils.copyProperties(members.get(0), vo);
            return Result.ok(vo);
        }
        return Result.ok();
    }

    @Override
    @Transactional
    public Result saveUserInfo(SaveUserInfoDto dto) {
        //修改会员信息，如果是shopuser也要修改里面的信息
        Member member = new Member();
        BeanUtils.copyProperties(dto, member);
        memberDao.update(member);
        ShopUser shopUser = new ShopUser();
        shopUser.setOpenId(dto.getOpenId());
        List<ShopUser> shopUsers = shopUserDao.selectShopUsers(shopUser);
        //如果是店员，修改shopUser
        if (!shopUsers.isEmpty()) {
            BeanUtils.copyProperties(dto, shopUser);
            shopUser.setUpdateTime(new Date());
            shopUserDao.update(shopUser);
        }
        return Result.ok();
    }

    @Override
    public Result applyShop(ApplyShopDto dto) {
        Shop shop=new Shop();
        BeanUtils.copyProperties(dto,shop);
        shop.setCreateTime(new Date());
        shop.setStatus(ShopStatusEnum.NOTAPPROVED.ordinal());
        shopDao.insert(shop);
        return Result.ok();
    }

    @Override
    public Result<BusinessDistrictPageVo> businessDistrict(BusinessDistrictPageDto dto) {
        //todo redis经纬度远近排列
        PageResult pageResult=new PageResult();
        PageHelper.startPage(dto.getPageNumber(),dto.getPageSize());
        BusinessDistrict businessDistrict=new BusinessDistrict();
        BeanUtils.copyProperties(dto,businessDistrict);
        List<BusinessDistrict> list = businessDistrictDao.selectBusinessDistricts(businessDistrict);
        PageInfo<BusinessDistrict> info=new PageInfo<>(list);
        pageResult.setTotle(info.getTotal());
        pageResult.setPageSize(dto.getPageSize());
        pageResult.setPageNumber(dto.getPageNumber());
        //转换vo出去
        List<BusinessDistrictPageVo> vos = info.getList().stream().map(l -> {
            BusinessDistrictPageVo vo = new BusinessDistrictPageVo();
            BeanUtils.copyProperties(l, vo);
            return vo;
        }).collect(Collectors.toList());
        pageResult.setPages(vos);
        return Result.ok(pageResult);
    }

    @Override
    public Result<ShopsVo> shops(String businessDistrictId) {
        Shop shop=new Shop();
        shop.setBusinessDistrictId(businessDistrictId);
        shop.setStatus(ShopStatusEnum.PUBLISHED.ordinal());
        List<ShopsVo> collect = shopDao.selectShops(shop).stream().map(shop1 -> {
            ShopsVo vo = new ShopsVo();
            BeanUtils.copyProperties(shop1,vo);
            return vo;
        }).collect(Collectors.toList());
        return Result.ok(collect);
    }
}
