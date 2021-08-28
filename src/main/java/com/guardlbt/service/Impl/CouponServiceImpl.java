package com.guardlbt.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.guardlbt.dao.CouponDao;
import com.guardlbt.entity.Coupon;
import com.guardlbt.service.CouponService;
import com.guardlbt.util.*;
import com.guardlbt.common.util.*;
import com.guardlbt.dto.*;
import com.guardlbt.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;


/**
* 代金券方法实现类
* Created by 代码自动生成.
* 时间:2021-08-28 11:42:14
*/
@Service
@Transactional
public class CouponServiceImpl implements CouponService {

    @Autowired
    private CouponDao dao;

    @Override
    public Result findPageCoupon(CouponPageDto dto) {
        PageResult pageResult=new PageResult();
        PageHelper.startPage(dto.getPageNumber(),dto.getPageSize());
        Coupon coupon=new Coupon();
        BeanUtils.copyProperties(dto,coupon);
        List<Coupon> list = dao.selectCoupons(coupon);
        PageInfo<Coupon> info=new PageInfo<>(list);
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
    public Result getAll() {
        List<Coupon> coupons = dao.selectCoupons(null);
        return Result.ok(coupons);
    }
        
    @Override
    public Result findAllByCoupon(Coupon coupon) {
        List<Coupon> coupons = dao.selectCoupons(coupon);
        //转换vo出去
        List<CouponPageVo> vos = coupons.stream().map(l -> {
        CouponPageVo vo = new CouponPageVo();
        BeanUtils.copyProperties(l, vo);
        return vo;
        }).collect(Collectors.toList());
        return Result.ok(vos);
    }

    @Override
    public Coupon findCoupon(Coupon coupon) {
        List<Coupon> list = dao.selectCoupons(coupon);
        if(!list.isEmpty()){
            return list.get(0);
        }
        return null;
    }

    @Override
    public Result insert(CouponSaveDto dto) {
        Coupon coupon=new Coupon();
        BeanUtils.copyProperties(dto,coupon);
        coupon.setCouponId(UuidUtild.getUUID());
        try{
            dao.insert(coupon);
            return Result.ok();
        }catch (Exception e){
            e.printStackTrace();
            return Result.error(500,e.getCause().getMessage());
        }
    }

    @Override
    public Result update(CouponUpdateDto dto) {
        Coupon coupon=new Coupon();
        BeanUtils.copyProperties(dto,coupon);
        try{
            dao.update(coupon);
            return Result.ok();
        }catch (Exception e){
            e.printStackTrace();
            return Result.error(500,e.getCause().getMessage());
        }
    }

    @Override
    public Result delete(Coupon coupon) {
        try{
            dao.delete(coupon);
            return Result.ok();
        }catch (Exception e){
            e.printStackTrace();
            return Result.error(500,e.getCause().getMessage());
        }
    }

    @Override
    public Result deleteAll(String ids) {
        try{
            String[] strings = ids.split(",");
            List<String> list=new ArrayList<>();
            for (int i = 0; i <strings.length ; i++) {
                list.add(strings[i]);
            }
            dao.deleteAll(list);
            return Result.ok();
        }catch (Exception e){
            e.printStackTrace();
            return Result.error(500,e.getCause().getMessage());
        }
    }

    @Override
    public Result getById(String couponId) {
        Coupon coupon=new Coupon();
        coupon.setCouponId(couponId);
        List<Coupon> coupons = dao.selectCoupons(coupon);
        if(coupons.isEmpty()){
            return Result.ok();
        }
        return Result.ok(coupons.get(0));
    }
}
