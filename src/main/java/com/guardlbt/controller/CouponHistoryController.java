package com.guardlbt.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import com.guardlbt.common.util.*;
import com.guardlbt.entity.CouponHistory;
import com.guardlbt.service.CouponHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;
import javax.validation.constraints.*;
import com.guardlbt.dto.*;

import java.util.*;
import javax.validation.*;

/**
* Created by 代码自动生成.
* 时间:2021-08-26 16:20:26
*/
@Api("代金券历史控制器")
@RestController
@RequestMapping("couponHistory")
public class CouponHistoryController {

    @Autowired
    public CouponHistoryService service;

    @GetMapping
	@ApiOperation("分页条件查询代金券历史")
    public Result getPage(@Validated CouponHistoryPageDto dto){
        return service.findPageCouponHistory(dto);
    }

    @GetMapping("all")
    @ApiOperation("获取所有代金券历史")
    public Result getAll(){
        return service.getAll();
    }
    @PostMapping
	@ApiOperation("添加代金券历史")
    public Result add(@Validated @RequestBody CouponHistorySaveDto dto){
        return service.insert(dto);
    }

    @PutMapping
	@ApiOperation("修改代金券历史")
    public Result update(@Validated @RequestBody CouponHistoryUpdateDto dto){
        return service.update(dto);
    }
    
    @DeleteMapping("/{id}")
	@ApiOperation("根据ID删除")
    public Result deleteAll(@PathVariable Long id){
        return service.deleteAll(id.toString().toString());
    }

    @GetMapping("/{id}")
    @ApiOperation("根据ID查询")
    public Result getById(@PathVariable Long id){
        return service.getById(id);
    }
}
