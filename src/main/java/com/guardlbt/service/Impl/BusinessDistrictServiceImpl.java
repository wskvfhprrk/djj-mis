package com.guardlbt.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.guardlbt.dao.BusinessDistrictDao;
import com.guardlbt.entity.BusinessDistrict;
import com.guardlbt.service.BusinessDistrictService;
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
* 商圈方法实现类
* Created by 代码自动生成.
* 时间:2021-08-25 18:06:23
*/
@Service
@Transactional
public class BusinessDistrictServiceImpl implements BusinessDistrictService {

    @Autowired
    private BusinessDistrictDao dao;

    @Override
    public Result findPageBusinessDistrict(BusinessDistrictPageDto dto) {
        PageResult pageResult=new PageResult();
        PageHelper.startPage(dto.getPageNumber(),dto.getPageSize());
        BusinessDistrict businessDistrict=new BusinessDistrict();
        BeanUtils.copyProperties(dto,businessDistrict);
        List<BusinessDistrict> list = dao.selectBusinessDistricts(businessDistrict);
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
    public Result getAll() {
        List<BusinessDistrict> businessDistricts = dao.selectBusinessDistricts(null);
        return Result.ok(businessDistricts);
    }
        
    @Override
    public Result findAllByBusinessDistrict(BusinessDistrict businessDistrict) {
        List<BusinessDistrict> businessDistricts = dao.selectBusinessDistricts(businessDistrict);
        //转换vo出去
        List<BusinessDistrictPageVo> vos = businessDistricts.stream().map(l -> {
        BusinessDistrictPageVo vo = new BusinessDistrictPageVo();
        BeanUtils.copyProperties(l, vo);
        return vo;
        }).collect(Collectors.toList());
        return Result.ok(vos);
    }

    @Override
    public BusinessDistrict findBusinessDistrict(BusinessDistrict businessDistrict) {
        List<BusinessDistrict> list = dao.selectBusinessDistricts(businessDistrict);
        if(!list.isEmpty()){
            return list.get(0);
        }
        return null;
    }

    @Override
    public Result insert(BusinessDistrictSaveDto dto) {
        BusinessDistrict businessDistrict=new BusinessDistrict();
        BeanUtils.copyProperties(dto,businessDistrict);
        businessDistrict.setBusinessDistrictId(UuidUtild.getUUID());
        try{
            dao.insert(businessDistrict);
            return Result.ok();
        }catch (Exception e){
            e.printStackTrace();
            return Result.error(500,e.getCause().getMessage());
        }
    }

    @Override
    public Result update(BusinessDistrictUpdateDto dto) {
        BusinessDistrict businessDistrict=new BusinessDistrict();
        BeanUtils.copyProperties(dto,businessDistrict);
        try{
            dao.update(businessDistrict);
            return Result.ok();
        }catch (Exception e){
            e.printStackTrace();
            return Result.error(500,e.getCause().getMessage());
        }
    }

    @Override
    public Result delete(BusinessDistrict businessDistrict) {
        try{
            dao.delete(businessDistrict);
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
    public Result getById(String businessDistrictId) {
        BusinessDistrict businessDistrict=new BusinessDistrict();
        businessDistrict.setBusinessDistrictId(businessDistrictId);
        List<BusinessDistrict> businessDistricts = dao.selectBusinessDistricts(businessDistrict);
        if(businessDistricts.isEmpty()){
            return Result.ok();
        }
        return Result.ok(businessDistricts.get(0));
    }
}
