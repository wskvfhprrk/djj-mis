package com.guardlbt.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import com.guardlbt.common.util.*;
import com.guardlbt.entity.Coupon;
import com.guardlbt.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;
import javax.validation.constraints.*;
import com.guardlbt.dto.*;

import java.util.*;
import javax.validation.*;

/**
* Created by 代码自动生成.
* 时间:2021-08-28 11:42:14
*/
@Api("代金券控制器")
@RestController
@RequestMapping("coupon")
public class CouponController {

    @Autowired
    public CouponService service;

    @GetMapping
	@ApiOperation("分页条件查询代金券")
    public Result getPage(@Validated CouponPageDto dto){
        return service.findPageCoupon(dto);
    }

    @GetMapping("all")
    @ApiOperation("获取所有代金券")
    public Result getAll(){
        return service.getAll();
    }
    @PostMapping
	@ApiOperation("添加代金券")
    public Result add(@Validated @RequestBody CouponSaveDto dto){
        return service.insert(dto);
    }

    @PutMapping
	@ApiOperation("修改代金券")
    public Result update(@Validated @RequestBody CouponUpdateDto dto){
        return service.update(dto);
    }
    
    @DeleteMapping("/{couponId}")
	@ApiOperation("根据ID删除")
    public Result deleteAll(@PathVariable String couponId){
        return service.deleteAll(couponId.toString().toString().toString().toString().toString().toString().toString().toString());
    }

    @GetMapping("/{couponId}")
    @ApiOperation("根据ID查询")
    public Result getById(@PathVariable String couponId){
        return service.getById(couponId);
    }
}
