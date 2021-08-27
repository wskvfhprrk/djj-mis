package com.guardlbt.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.guardlbt.dao.IndexCouponDao;
import com.guardlbt.entity.IndexCoupon;
import com.guardlbt.service.IndexCouponService;
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
* 首页促销代金券方法实现类
* Created by 代码自动生成.
* 时间:2021-08-27 13:42:55
*/
@Service
@Transactional
public class IndexCouponServiceImpl implements IndexCouponService {

    @Autowired
    private IndexCouponDao dao;

    @Override
    public Result findPageIndexCoupon(IndexCouponPageDto dto) {
        PageResult pageResult=new PageResult();
        PageHelper.startPage(dto.getPageNumber(),dto.getPageSize());
        IndexCoupon indexCoupon=new IndexCoupon();
        BeanUtils.copyProperties(dto,indexCoupon);
        List<IndexCoupon> list = dao.selectIndexCoupons(indexCoupon);
        PageInfo<IndexCoupon> info=new PageInfo<>(list);
        pageResult.setTotle(info.getTotal());
        pageResult.setPageSize(dto.getPageSize());
        pageResult.setPageNumber(dto.getPageNumber());
        //转换vo出去
        List<IndexCouponPageVo> vos = info.getList().stream().map(l -> {
            IndexCouponPageVo vo = new IndexCouponPageVo();
            BeanUtils.copyProperties(l, vo);
            return vo;
        }).collect(Collectors.toList());
        pageResult.setPages(vos);
        return Result.ok(pageResult);
    }

    @Override
    public Result getAll() {
        List<IndexCoupon> indexCoupons = dao.selectIndexCoupons(null);
        return Result.ok(indexCoupons);
    }
        
    @Override
    public Result findAllByIndexCoupon(IndexCoupon indexCoupon) {
        List<IndexCoupon> indexCoupons = dao.selectIndexCoupons(indexCoupon);
        //转换vo出去
        List<IndexCouponPageVo> vos = indexCoupons.stream().map(l -> {
        IndexCouponPageVo vo = new IndexCouponPageVo();
        BeanUtils.copyProperties(l, vo);
        return vo;
        }).collect(Collectors.toList());
        return Result.ok(vos);
    }

    @Override
    public IndexCoupon findIndexCoupon(IndexCoupon indexCoupon) {
        List<IndexCoupon> list = dao.selectIndexCoupons(indexCoupon);
        if(!list.isEmpty()){
            return list.get(0);
        }
        return null;
    }

    @Override
    public Result insert(IndexCouponSaveDto dto) {
        IndexCoupon indexCoupon=new IndexCoupon();
        BeanUtils.copyProperties(dto,indexCoupon);
        //todo 此处报错的原因是数据库设计不合理，主键是数据类型，但不是自增的，请修改数据结构为自增类型，如果确实需要数据不自增，请修错误代码！
        //indexCoupon.setSorting(UuidUtild.getUUID());
        try{
            dao.insert(indexCoupon);
            return Result.ok();
        }catch (Exception e){
            e.printStackTrace();
            return Result.error(500,e.getCause().getMessage());
        }
    }

    @Override
    public Result update(IndexCouponUpdateDto dto) {
        IndexCoupon indexCoupon=new IndexCoupon();
        BeanUtils.copyProperties(dto,indexCoupon);
        try{
            dao.update(indexCoupon);
            return Result.ok();
        }catch (Exception e){
            e.printStackTrace();
            return Result.error(500,e.getCause().getMessage());
        }
    }

    @Override
    public Result delete(IndexCoupon indexCoupon) {
        try{
            dao.delete(indexCoupon);
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
    public Result getById(Integer sorting) {
        IndexCoupon indexCoupon=new IndexCoupon();
        indexCoupon.setSorting(sorting);
        List<IndexCoupon> indexCoupons = dao.selectIndexCoupons(indexCoupon);
        if(indexCoupons.isEmpty()){
            return Result.ok();
        }
        return Result.ok(indexCoupons.get(0));
    }
}
