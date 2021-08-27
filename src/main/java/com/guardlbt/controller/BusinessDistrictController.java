package com.guardlbt.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import com.guardlbt.common.util.*;
import com.guardlbt.entity.BusinessDistrict;
import com.guardlbt.service.BusinessDistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;
import javax.validation.constraints.*;
import com.guardlbt.dto.*;

import java.util.*;
import javax.validation.*;

/**
* Created by 代码自动生成.
* 时间:2021-08-27 13:42:55
*/
@Api("商圈控制器")
@RestController
@RequestMapping("businessDistrict")
public class BusinessDistrictController {

    @Autowired
    public BusinessDistrictService service;

    @GetMapping
	@ApiOperation("分页条件查询商圈")
    public Result getPage(@Validated BusinessDistrictPageDto dto){
        return service.findPageBusinessDistrict(dto);
    }

    @GetMapping("all")
    @ApiOperation("获取所有商圈")
    public Result getAll(){
        return service.getAll();
    }
    @PostMapping
	@ApiOperation("添加商圈")
    public Result add(@Validated @RequestBody BusinessDistrictSaveDto dto){
        return service.insert(dto);
    }

    @PutMapping
	@ApiOperation("修改商圈")
    public Result update(@Validated @RequestBody BusinessDistrictUpdateDto dto){
        return service.update(dto);
    }
    
    @DeleteMapping("/{businessDistrictId}")
	@ApiOperation("根据ID删除")
    public Result deleteAll(@PathVariable String businessDistrictId){
        return service.deleteAll(businessDistrictId.toString().toString());
    }

    @GetMapping("/{businessDistrictId}")
    @ApiOperation("根据ID查询")
    public Result getById(@PathVariable String businessDistrictId){
        return service.getById(businessDistrictId);
    }
}
