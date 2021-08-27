package com.guardlbt.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.guardlbt.dao.SysDeptDao;
import com.guardlbt.entity.SysDept;
import com.guardlbt.service.SysDeptService;
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
* 商店部门管理方法实现类
* Created by 代码自动生成.
* 时间:2021-08-26 16:20:26
*/
@Service
@Transactional
public class SysDeptServiceImpl implements SysDeptService {

    @Autowired
    private SysDeptDao dao;

    @Override
    public Result findPageSysDept(SysDeptPageDto dto) {
        PageResult pageResult=new PageResult();
        PageHelper.startPage(dto.getPageNumber(),dto.getPageSize());
        SysDept sysDept=new SysDept();
        BeanUtils.copyProperties(dto,sysDept);
        List<SysDept> list = dao.selectSysDepts(sysDept);
        PageInfo<SysDept> info=new PageInfo<>(list);
        pageResult.setTotle(info.getTotal());
        pageResult.setPageSize(dto.getPageSize());
        pageResult.setPageNumber(dto.getPageNumber());
        //转换vo出去
        List<SysDeptPageVo> vos = info.getList().stream().map(l -> {
            SysDeptPageVo vo = new SysDeptPageVo();
            BeanUtils.copyProperties(l, vo);
            return vo;
        }).collect(Collectors.toList());
        pageResult.setPages(vos);
        return Result.ok(pageResult);
    }

    @Override
    public Result getAll() {
        List<SysDept> sysDepts = dao.selectSysDepts(null);
        return Result.ok(sysDepts);
    }
        
    @Override
    public Result findAllBySysDept(SysDept sysDept) {
        List<SysDept> sysDepts = dao.selectSysDepts(sysDept);
        //转换vo出去
        List<SysDeptPageVo> vos = sysDepts.stream().map(l -> {
        SysDeptPageVo vo = new SysDeptPageVo();
        BeanUtils.copyProperties(l, vo);
        return vo;
        }).collect(Collectors.toList());
        return Result.ok(vos);
    }

    @Override
    public SysDept findSysDept(SysDept sysDept) {
        List<SysDept> list = dao.selectSysDepts(sysDept);
        if(!list.isEmpty()){
            return list.get(0);
        }
        return null;
    }

    @Override
    public Result insert(SysDeptSaveDto dto) {
        SysDept sysDept=new SysDept();
        BeanUtils.copyProperties(dto,sysDept);
        
        try{
            dao.insert(sysDept);
            return Result.ok();
        }catch (Exception e){
            e.printStackTrace();
            return Result.error(500,e.getCause().getMessage());
        }
    }

    @Override
    public Result update(SysDeptUpdateDto dto) {
        SysDept sysDept=new SysDept();
        BeanUtils.copyProperties(dto,sysDept);
        try{
            dao.update(sysDept);
            return Result.ok();
        }catch (Exception e){
            e.printStackTrace();
            return Result.error(500,e.getCause().getMessage());
        }
    }

    @Override
    public Result delete(SysDept sysDept) {
        try{
            dao.delete(sysDept);
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
    public Result getById(Integer deptId) {
        SysDept sysDept=new SysDept();
        sysDept.setDeptId(deptId);
        List<SysDept> sysDepts = dao.selectSysDepts(sysDept);
        if(sysDepts.isEmpty()){
            return Result.ok();
        }
        return Result.ok(sysDepts.get(0));
    }
}
