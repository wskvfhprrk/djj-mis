package com.guardlbt.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.guardlbt.common.util.PageResult;
import com.guardlbt.common.util.Result;
import com.guardlbt.dao.*;
import com.guardlbt.dto.ApplyShopDto;
import com.guardlbt.dto.BusinessDistrictPageDto;
import com.guardlbt.dto.SaveUserInfoDto;
import com.guardlbt.entity.*;
import com.guardlbt.eum.OperationTypeEnum;
import com.guardlbt.eum.Role;
import com.guardlbt.eum.ShopStatusEnum;
import com.guardlbt.service.WxMyService;
import com.guardlbt.util.UuidUtild;
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
    @Autowired
    private MemberOperationHistoryDao memberOperationHistoryDao;

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
    public Result updateUserInfo(SaveUserInfoDto dto) {
        //要判断一下是身份，如果不是管理员就写入会员数据库，如果已经写入数据库的不要再记录了
//        ShopUser shopUser = new ShopUser();
//        shopUser.setOpenId(memberSaveDto.getOpenId());
//        List<ShopUser> shopUsers = shopUserDao.selectShopUsers(shopUser);
//        Member member = new Member();
//        member.setOpenId(memberSaveDto.getOpenId());
//        List<Member> members = memberDao.selectMembers(member);
//        if (shopUsers.isEmpty() && members.isEmpty()) {
//            Member member1 = new Member();
//            BeanUtils.copyProperties(memberSaveDto, member1);
//            member1.setRegisterTime(new Date());
//            member1.setMemberId(UuidUtild.getUUID());
//            memberDao.insert(member1);
//        }
//        // 记录会员操作记录表
//        if (!members.isEmpty()) {
//            MemberOperationHistory m = new MemberOperationHistory();
//            m.setMemberId(memberSaveDto.getOpenId());
//            m.setCreateTime(new Date());
//            m.setDetail(OperationType.LOGIN.getInfo());
//            m.setRelationInfo(OperationType.LOGIN.getInfo());
//            m.setOperationId(String.valueOf(OperationType.LOGIN.getState()));
//            memberOperationHistoryDao.insert(m);
//        }
//        //如果是店员记录不用记录
//        return Result.ok();
        //修改会员信息，如果是shopuser也要修改里面的信息
        Member member = new Member();
        member.setOpenId(dto.getOpenId());
        List<Member> members = memberDao.selectMembers(member);
        BeanUtils.copyProperties(dto, member);
        if(members.isEmpty()){
            member.setRegisterTime(new Date());
            member.setMemberId(UuidUtild.getUUID());
            memberDao.insert(member);
            //会员操作记录
            memberRecod(member,OperationTypeEnum.LOGIN);
        }
        member.setMemberId(members.get(0).getMemberId());
        memberDao.update(member);
        //会员操作记录
        memberRecod(member,OperationTypeEnum.UPDATE);
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

    private void memberRecod(Member member, OperationTypeEnum operationTypeEnum) {
        MemberOperationHistory m = new MemberOperationHistory();
            m.setMemberId(member.getOpenId());
            m.setCreateTime(new Date());
            m.setDetail(operationTypeEnum.getInfo());
            m.setRelationInfo(operationTypeEnum.getInfo());
            m.setOperationId(String.valueOf(operationTypeEnum.getState()));
            memberOperationHistoryDao.insert(m);
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
