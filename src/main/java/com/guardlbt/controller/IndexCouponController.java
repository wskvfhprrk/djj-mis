package com.guardlbt.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import com.guardlbt.common.util.*;
import com.guardlbt.entity.IndexCoupon;
import com.guardlbt.service.IndexCouponService;
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
@Api("首页促销代金券控制器")
@RestController
@RequestMapping("indexCoupon")
public class IndexCouponController {

    @Autowired
    public IndexCouponService service;

    @GetMapping
	@ApiOperation("分页条件查询首页促销代金券")
    public Result getPage(@Validated IndexCouponPageDto dto){
        return service.findPageIndexCoupon(dto);
    }

    @GetMapping("all")
    @ApiOperation("获取所有首页促销代金券")
    public Result getAll(){
        return service.getAll();
    }
    @PostMapping
	@ApiOperation("添加首页促销代金券")
    public Result add(@Validated @RequestBody IndexCouponSaveDto dto){
        return service.insert(dto);
    }

    @PutMapping
	@ApiOperation("修改首页促销代金券")
    public Result update(@Validated @RequestBody IndexCouponUpdateDto dto){
        return service.update(dto);
    }
    
    @DeleteMapping("/{sorting}")
	@ApiOperation("根据ID删除")
    public Result deleteAll(@PathVariable Integer sorting){
        return service.deleteAll(sorting.toString());
    }

    @GetMapping("/{sorting}")
    @ApiOperation("根据ID查询")
    public Result getById(@PathVariable Integer sorting){
        return service.getById(sorting);
    }
}
