package com.guardlbt.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import com.guardlbt.common.util.*;
import com.guardlbt.entity.SysDept;
import com.guardlbt.service.SysDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;
import javax.validation.constraints.*;
import com.guardlbt.dto.*;

import java.util.*;
import javax.validation.*;

/**
* Created by 代码自动生成.
* 时间:2021-08-25 18:06:23
*/
@Api("商店部门管理控制器")
@RestController
@RequestMapping("sysDept")
public class SysDeptController {

    @Autowired
    public SysDeptService service;

    @GetMapping
	@ApiOperation("分页条件查询商店部门管理")
    public Result getPage(@Validated SysDeptPageDto dto){
        return service.findPageSysDept(dto);
    }

    @GetMapping("all")
    @ApiOperation("获取所有商店部门管理")
    public Result getAll(){
        return service.getAll();
    }
    @PostMapping
	@ApiOperation("添加商店部门管理")
    public Result add(@Validated @RequestBody SysDeptSaveDto dto){
        return service.insert(dto);
    }

    @PutMapping
	@ApiOperation("修改商店部门管理")
    public Result update(@Validated @RequestBody SysDeptUpdateDto dto){
        return service.update(dto);
    }
    
    @DeleteMapping("/{deptId}")
	@ApiOperation("根据ID删除")
    public Result deleteAll(@PathVariable Integer deptId){
        return service.deleteAll(deptId.toString().toString().toString());
    }

    @GetMapping("/{deptId}")
    @ApiOperation("根据ID查询")
    public Result getById(@PathVariable Integer deptId){
        return service.getById(deptId);
    }
}
