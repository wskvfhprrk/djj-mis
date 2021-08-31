package com.guardlbt.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.guardlbt.common.util.PageResult;
import com.guardlbt.common.util.Result;
import com.guardlbt.dao.*;
import com.guardlbt.dto.CouponPageDto;
import com.guardlbt.dto.ShareCouponDto;
import com.guardlbt.entity.*;
import com.guardlbt.eum.OperationTypeEnum;
import com.guardlbt.service.WxCouponService;
import com.guardlbt.vo.CouponHistoryPageVo;
import com.guardlbt.vo.CouponPageVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class WxCouponServiceImpl implements WxCouponService {
    @Autowired
    private CouponDao dao;
    @Autowired
    private CouponHistoryDao couponHistoryDao;
    @Autowired
    private MemberDao memberDao;
    @Autowired
    private ShopUserDao shopUserDao;
    @Autowired
    private MemberOperationHistoryDao memberOperationHistoryDao;

    @Override
    public Result<PageResult<List<CouponPageVo>>> couponList(CouponPageDto dto) {
        PageResult pageResult = new PageResult();
        PageHelper.startPage(dto.getPageNumber(), dto.getPageSize());
        Coupon coupon = new Coupon();
        BeanUtils.copyProperties(dto, coupon);
        List<Coupon> list = dao.selectCoupons(coupon);
        //过期的不要显示了，不能使用
        coupon.setStartDate(new Date());
        coupon.setStatus(1);
        PageInfo<Coupon> info = new PageInfo<>(list);
        pageResult.setTotle(info.getTotal());
        pageResult.setPageSize(dto.getPageSize());
        pageResult.setPageNumber(dto.getPageNumber());
        //转换vo出去
        List<CouponPageVo> vos = info.getList().stream().map(l -> {
            CouponPageVo vo = new CouponPageVo();
            BeanUtils.copyProperties(l, vo);
            return vo;
        }).collect(Collectors.toList());
        pageResult.setPages(vos);
        return Result.ok(pageResult);
    }

    @Override
    public Result<List<CouponHistoryPageVo>> getCouponHistory(String couponId) {
        CouponHistory couponHistory = new CouponHistory();
        couponHistory.setCouponNo(couponId);
        List<CouponHistoryPageVo> collect = couponHistoryDao.selectCouponHistorys(couponHistory).stream()
                //按时间排序
                .sorted(Comparator.comparing(CouponHistory::getCreateTime))
                .map(c -> {
                    CouponHistoryPageVo vo = new CouponHistoryPageVo();
                    BeanUtils.copyProperties(c, vo);
                    return vo;
                }).collect(Collectors.toList());
        return Result.ok(collect);
    }

    @Override
    @Transactional
    public Result shareCoupon(ShareCouponDto dto) {
        //修改代金券历史信息
        CouponHistory couponHistory = new CouponHistory();
        couponHistory.setCouponNo(dto.getCouponId());
        couponHistory.setCreateTime(new Date());
        Member member = new Member();
        member.setOpenId(dto.getFomeOpenid());
        List<Member> members = memberDao.selectMembers(member);
        String name;
        if (members.isEmpty()) {
            ShopUser shopUser = new ShopUser();
            shopUser.setOpenId(dto.getFomeOpenid());
            List<ShopUser> shopUsers = shopUserDao.selectShopUsers(shopUser);
            if (shopUsers.isEmpty()) {
                return Result.error(500, "查不到发送人");
            } else {
                name = shopUsers.get(0).getName();
            }
        }
        name = members.get(0).getName();
        couponHistory.setFromName(dto.getFomeOpenid() +"+"+ name);
        member.setOpenId(dto.getToOpneid());
        List<Member> toMembers = memberDao.selectMembers(member);
        if(toMembers.isEmpty()){
            return Result.error(500,"没有接收方信息，请先注册");
        }
        couponHistory.setRemark("分享和移交代金券");
        couponHistoryDao.insert(couponHistory);
        //会员记录中
        MemberOperationHistory m=new MemberOperationHistory();
        m.setOperationId(OperationTypeEnum.SHARE.getInfo());
        m.setDetail(OperationTypeEnum.SHARE.getInfo());
        m.setCreateTime(new Date());
        m.setOperationId(dto.getFomeOpenid());
        m.setRelationInfo(OperationTypeEnum.SHARE.getInfo());
        memberOperationHistoryDao.insert(m);
        return Result.ok();
    }
}
