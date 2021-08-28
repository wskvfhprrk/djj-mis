package com.guardlbt.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.guardlbt.common.util.PageResult;
import com.guardlbt.common.util.Result;
import com.guardlbt.dao.CouponDao;
import com.guardlbt.dao.CouponHistoryDao;
import com.guardlbt.dto.CouponPageDto;
import com.guardlbt.entity.Coupon;
import com.guardlbt.entity.CouponHistory;
import com.guardlbt.service.WxCouponService;
import com.guardlbt.vo.CouponHistoryPageVo;
import com.guardlbt.vo.CouponPageVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        CouponHistory couponHistory=new CouponHistory();
        couponHistory.setCouponNo(couponId);
        List<CouponHistoryPageVo> collect = couponHistoryDao.selectCouponHistorys(couponHistory).stream()
                //按时间排序
                .sorted(Comparator.comparing(CouponHistory::getCreateTime))
                .map(c -> {
            CouponHistoryPageVo vo = new CouponHistoryPageVo();
            BeanUtils.copyProperties(c,vo);
            return vo;
        }).collect(Collectors.toList());
        return Result.ok(collect);
    }
}
