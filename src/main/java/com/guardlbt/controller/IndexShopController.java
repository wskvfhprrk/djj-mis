package com.guardlbt.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import com.guardlbt.common.util.*;
import com.guardlbt.entity.IndexShop;
import com.guardlbt.service.IndexShopService;
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
@Api("首页促销店铺控制器")
@RestController
@RequestMapping("indexShop")
public class IndexShopController {

    @Autowired
    public IndexShopService service;

    @GetMapping
	@ApiOperation("分页条件查询首页促销店铺")
    public Result getPage(@Validated IndexShopPageDto dto){
        return service.findPageIndexShop(dto);
    }

    @GetMapping("all")
    @ApiOperation("获取所有首页促销店铺")
    public Result getAll(){
        return service.getAll();
    }
    @PostMapping
	@ApiOperation("添加首页促销店铺")
    public Result add(@Validated @RequestBody IndexShopSaveDto dto){
        return service.insert(dto);
    }

    @PutMapping
	@ApiOperation("修改首页促销店铺")
    public Result update(@Validated @RequestBody IndexShopUpdateDto dto){
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
