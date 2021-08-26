package com.guardlbt.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import com.guardlbt.common.util.*;
import com.guardlbt.entity.Shop;
import com.guardlbt.service.ShopService;
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
@Api("商店控制器")
@RestController
@RequestMapping("shop")
public class ShopController {

    @Autowired
    public ShopService service;

    @GetMapping
	@ApiOperation("分页条件查询商店")
    public Result getPage(@Validated ShopPageDto dto){
        return service.findPageShop(dto);
    }

    @GetMapping("all")
    @ApiOperation("获取所有商店")
    public Result getAll(){
        return service.getAll();
    }
    @PostMapping
	@ApiOperation("添加商店")
    public Result add(@Validated @RequestBody ShopSaveDto dto){
        return service.insert(dto);
    }

    @PutMapping
	@ApiOperation("修改商店")
    public Result update(@Validated @RequestBody ShopUpdateDto dto){
        return service.update(dto);
    }
    
    @DeleteMapping("/{shopId}")
	@ApiOperation("根据ID删除")
    public Result deleteAll(@PathVariable String shopId){
        return service.deleteAll(shopId.toString().toString().toString().toString().toString());
    }

    @GetMapping("/{shopId}")
    @ApiOperation("根据ID查询")
    public Result getById(@PathVariable String shopId){
        return service.getById(shopId);
    }
}
