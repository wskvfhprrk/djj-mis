package com.guardlbt.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import com.guardlbt.common.util.*;
import com.guardlbt.entity.CouponStock;
import com.guardlbt.service.CouponStockService;
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
@Api("代金券明细控制器")
@RestController
@RequestMapping("couponStock")
public class CouponStockController {

    @Autowired
    public CouponStockService service;

    @GetMapping
	@ApiOperation("分页条件查询代金券明细")
    public Result getPage(@Validated CouponStockPageDto dto){
        return service.findPageCouponStock(dto);
    }

    @GetMapping("all")
    @ApiOperation("获取所有代金券明细")
    public Result getAll(){
        return service.getAll();
    }
    @PostMapping
	@ApiOperation("添加代金券明细")
    public Result add(@Validated @RequestBody CouponStockSaveDto dto){
        return service.insert(dto);
    }

    @PutMapping
	@ApiOperation("修改代金券明细")
    public Result update(@Validated @RequestBody CouponStockUpdateDto dto){
        return service.update(dto);
    }
    
    @DeleteMapping("/{couponNo}")
	@ApiOperation("根据ID删除")
    public Result deleteAll(@PathVariable String couponNo){
        return service.deleteAll(couponNo.toString().toString());
    }

    @GetMapping("/{couponNo}")
    @ApiOperation("根据ID查询")
    public Result getById(@PathVariable String couponNo){
        return service.getById(couponNo);
    }
}
