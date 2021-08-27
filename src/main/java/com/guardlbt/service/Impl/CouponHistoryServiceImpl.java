package com.guardlbt.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.guardlbt.dao.CouponHistoryDao;
import com.guardlbt.entity.CouponHistory;
import com.guardlbt.service.CouponHistoryService;
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
* 代金券历史方法实现类
* Created by 代码自动生成.
* 时间:2021-08-27 13:42:55
*/
@Service
@Transactional
public class CouponHistoryServiceImpl implements CouponHistoryService {

    @Autowired
    private CouponHistoryDao dao;

    @Override
    public Result findPageCouponHistory(CouponHistoryPageDto dto) {
        PageResult pageResult=new PageResult();
        PageHelper.startPage(dto.getPageNumber(),dto.getPageSize());
        CouponHistory couponHistory=new CouponHistory();
        BeanUtils.copyProperties(dto,couponHistory);
        List<CouponHistory> list = dao.selectCouponHistorys(couponHistory);
        PageInfo<CouponHistory> info=new PageInfo<>(list);
        pageResult.setTotle(info.getTotal());
        pageResult.setPageSize(dto.getPageSize());
        pageResult.setPageNumber(dto.getPageNumber());
        //转换vo出去
        List<CouponHistoryPageVo> vos = info.getList().stream().map(l -> {
            CouponHistoryPageVo vo = new CouponHistoryPageVo();
            BeanUtils.copyProperties(l, vo);
            return vo;
        }).collect(Collectors.toList());
        pageResult.setPages(vos);
        return Result.ok(pageResult);
    }

    @Override
    public Result getAll() {
        List<CouponHistory> couponHistorys = dao.selectCouponHistorys(null);
        return Result.ok(couponHistorys);
    }
        
    @Override
    public Result findAllByCouponHistory(CouponHistory couponHistory) {
        List<CouponHistory> couponHistorys = dao.selectCouponHistorys(couponHistory);
        //转换vo出去
        List<CouponHistoryPageVo> vos = couponHistorys.stream().map(l -> {
        CouponHistoryPageVo vo = new CouponHistoryPageVo();
        BeanUtils.copyProperties(l, vo);
        return vo;
        }).collect(Collectors.toList());
        return Result.ok(vos);
    }

    @Override
    public CouponHistory findCouponHistory(CouponHistory couponHistory) {
        List<CouponHistory> list = dao.selectCouponHistorys(couponHistory);
        if(!list.isEmpty()){
            return list.get(0);
        }
        return null;
    }

    @Override
    public Result insert(CouponHistorySaveDto dto) {
        CouponHistory couponHistory=new CouponHistory();
        BeanUtils.copyProperties(dto,couponHistory);
        
        try{
            dao.insert(couponHistory);
            return Result.ok();
        }catch (Exception e){
            e.printStackTrace();
            return Result.error(500,e.getCause().getMessage());
        }
    }

    @Override
    public Result update(CouponHistoryUpdateDto dto) {
        CouponHistory couponHistory=new CouponHistory();
        BeanUtils.copyProperties(dto,couponHistory);
        try{
            dao.update(couponHistory);
            return Result.ok();
        }catch (Exception e){
            e.printStackTrace();
            return Result.error(500,e.getCause().getMessage());
        }
    }

    @Override
    public Result delete(CouponHistory couponHistory) {
        try{
            dao.delete(couponHistory);
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
    public Result getById(Long id) {
        CouponHistory couponHistory=new CouponHistory();
        couponHistory.setId(id);
        List<CouponHistory> couponHistorys = dao.selectCouponHistorys(couponHistory);
        if(couponHistorys.isEmpty()){
            return Result.ok();
        }
        return Result.ok(couponHistorys.get(0));
    }
}
