package com.guardlbt.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import com.guardlbt.common.util.*;
import com.guardlbt.entity.OperationType;
import com.guardlbt.service.OperationTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;
import javax.validation.constraints.*;
import com.guardlbt.dto.*;

import java.util.*;
import javax.validation.*;

/**
* Created by 代码自动生成.
* 时间:2021-08-26 16:20:27
*/
@Api("操作类型控制器")
@RestController
@RequestMapping("operationType")
public class OperationTypeController {

    @Autowired
    public OperationTypeService service;

    @GetMapping
	@ApiOperation("分页条件查询操作类型")
    public Result getPage(@Validated OperationTypePageDto dto){
        return service.findPageOperationType(dto);
    }

    @GetMapping("all")
    @ApiOperation("获取所有操作类型")
    public Result getAll(){
        return service.getAll();
    }
    @PostMapping
	@ApiOperation("添加操作类型")
    public Result add(@Validated @RequestBody OperationTypeSaveDto dto){
        return service.insert(dto);
    }

    @PutMapping
	@ApiOperation("修改操作类型")
    public Result update(@Validated @RequestBody OperationTypeUpdateDto dto){
        return service.update(dto);
    }
    
    @DeleteMapping("/{operationId}")
	@ApiOperation("根据ID删除")
    public Result deleteAll(@PathVariable String operationId){
        return service.deleteAll(operationId);
    }

    @GetMapping("/{operationId}")
    @ApiOperation("根据ID查询")
    public Result getById(@PathVariable String operationId){
        return service.getById(operationId);
    }
}
