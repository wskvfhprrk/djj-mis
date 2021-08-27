package com.guardlbt.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.guardlbt.dao.CouponStockDao;
import com.guardlbt.entity.CouponStock;
import com.guardlbt.service.CouponStockService;
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
* 代金券明细方法实现类
* Created by 代码自动生成.
* 时间:2021-08-26 16:20:26
*/
@Service
@Transactional
public class CouponStockServiceImpl implements CouponStockService {

    @Autowired
    private CouponStockDao dao;

    @Override
    public Result findPageCouponStock(CouponStockPageDto dto) {
        PageResult pageResult=new PageResult();
        PageHelper.startPage(dto.getPageNumber(),dto.getPageSize());
        CouponStock couponStock=new CouponStock();
        BeanUtils.copyProperties(dto,couponStock);
        List<CouponStock> list = dao.selectCouponStocks(couponStock);
        PageInfo<CouponStock> info=new PageInfo<>(list);
        pageResult.setTotle(info.getTotal());
        pageResult.setPageSize(dto.getPageSize());
        pageResult.setPageNumber(dto.getPageNumber());
        //转换vo出去
        List<CouponStockPageVo> vos = info.getList().stream().map(l -> {
            CouponStockPageVo vo = new CouponStockPageVo();
            BeanUtils.copyProperties(l, vo);
            return vo;
        }).collect(Collectors.toList());
        pageResult.setPages(vos);
        return Result.ok(pageResult);
    }

    @Override
    public Result getAll() {
        List<CouponStock> couponStocks = dao.selectCouponStocks(null);
        return Result.ok(couponStocks);
    }
        
    @Override
    public Result findAllByCouponStock(CouponStock couponStock) {
        List<CouponStock> couponStocks = dao.selectCouponStocks(couponStock);
        //转换vo出去
        List<CouponStockPageVo> vos = couponStocks.stream().map(l -> {
        CouponStockPageVo vo = new CouponStockPageVo();
        BeanUtils.copyProperties(l, vo);
        return vo;
        }).collect(Collectors.toList());
        return Result.ok(vos);
    }

    @Override
    public CouponStock findCouponStock(CouponStock couponStock) {
        List<CouponStock> list = dao.selectCouponStocks(couponStock);
        if(!list.isEmpty()){
            return list.get(0);
        }
        return null;
    }

    @Override
    public Result insert(CouponStockSaveDto dto) {
        CouponStock couponStock=new CouponStock();
        BeanUtils.copyProperties(dto,couponStock);
        couponStock.setCouponNo(UuidUtild.getUUID());
        try{
            dao.insert(couponStock);
            return Result.ok();
        }catch (Exception e){
            e.printStackTrace();
            return Result.error(500,e.getCause().getMessage());
        }
    }

    @Override
    public Result update(CouponStockUpdateDto dto) {
        CouponStock couponStock=new CouponStock();
        BeanUtils.copyProperties(dto,couponStock);
        try{
            dao.update(couponStock);
            return Result.ok();
        }catch (Exception e){
            e.printStackTrace();
            return Result.error(500,e.getCause().getMessage());
        }
    }

    @Override
    public Result delete(CouponStock couponStock) {
        try{
            dao.delete(couponStock);
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
    public Result getById(String couponNo) {
        CouponStock couponStock=new CouponStock();
        couponStock.setCouponNo(couponNo);
        List<CouponStock> couponStocks = dao.selectCouponStocks(couponStock);
        if(couponStocks.isEmpty()){
            return Result.ok();
        }
        return Result.ok(couponStocks.get(0));
    }
}
