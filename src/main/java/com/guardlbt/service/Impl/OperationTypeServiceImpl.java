package com.guardlbt.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.guardlbt.dao.OperationTypeDao;
import com.guardlbt.entity.OperationType;
import com.guardlbt.service.OperationTypeService;
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
* 操作类型方法实现类
* Created by 代码自动生成.
* 时间:2021-08-25 18:06:24
*/
@Service
@Transactional
public class OperationTypeServiceImpl implements OperationTypeService {

    @Autowired
    private OperationTypeDao dao;

    @Override
    public Result findPageOperationType(OperationTypePageDto dto) {
        PageResult pageResult=new PageResult();
        PageHelper.startPage(dto.getPageNumber(),dto.getPageSize());
        OperationType operationType=new OperationType();
        BeanUtils.copyProperties(dto,operationType);
        List<OperationType> list = dao.selectOperationTypes(operationType);
        PageInfo<OperationType> info=new PageInfo<>(list);
        pageResult.setTotle(info.getTotal());
        pageResult.setPageSize(dto.getPageSize());
        pageResult.setPageNumber(dto.getPageNumber());
        //转换vo出去
        List<OperationTypePageVo> vos = info.getList().stream().map(l -> {
            OperationTypePageVo vo = new OperationTypePageVo();
            BeanUtils.copyProperties(l, vo);
            return vo;
        }).collect(Collectors.toList());
        pageResult.setPages(vos);
        return Result.ok(pageResult);
    }

    @Override
    public Result getAll() {
        List<OperationType> operationTypes = dao.selectOperationTypes(null);
        return Result.ok(operationTypes);
    }
        
    @Override
    public Result findAllByOperationType(OperationType operationType) {
        List<OperationType> operationTypes = dao.selectOperationTypes(operationType);
        //转换vo出去
        List<OperationTypePageVo> vos = operationTypes.stream().map(l -> {
        OperationTypePageVo vo = new OperationTypePageVo();
        BeanUtils.copyProperties(l, vo);
        return vo;
        }).collect(Collectors.toList());
        return Result.ok(vos);
    }

    @Override
    public OperationType findOperationType(OperationType operationType) {
        List<OperationType> list = dao.selectOperationTypes(operationType);
        if(!list.isEmpty()){
            return list.get(0);
        }
        return null;
    }

    @Override
    public Result insert(OperationTypeSaveDto dto) {
        OperationType operationType=new OperationType();
        BeanUtils.copyProperties(dto,operationType);
        operationType.setOperationId(UuidUtild.getUUID());
        try{
            dao.insert(operationType);
            return Result.ok();
        }catch (Exception e){
            e.printStackTrace();
            return Result.error(500,e.getCause().getMessage());
        }
    }

    @Override
    public Result update(OperationTypeUpdateDto dto) {
        OperationType operationType=new OperationType();
        BeanUtils.copyProperties(dto,operationType);
        try{
            dao.update(operationType);
            return Result.ok();
        }catch (Exception e){
            e.printStackTrace();
            return Result.error(500,e.getCause().getMessage());
        }
    }

    @Override
    public Result delete(OperationType operationType) {
        try{
            dao.delete(operationType);
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
    public Result getById(String operationId) {
        OperationType operationType=new OperationType();
        operationType.setOperationId(operationId);
        List<OperationType> operationTypes = dao.selectOperationTypes(operationType);
        if(operationTypes.isEmpty()){
            return Result.ok();
        }
        return Result.ok(operationTypes.get(0));
    }
}
