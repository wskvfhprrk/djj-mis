package com.guardlbt.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import com.guardlbt.common.util.*;
import com.guardlbt.entity.Goods;
import com.guardlbt.service.GoodsService;
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
@Api("商品控制器")
@RestController
@RequestMapping("goods")
public class GoodsController {

    @Autowired
    public GoodsService service;

    @GetMapping
	@ApiOperation("分页条件查询商品")
    public Result getPage(@Validated GoodsPageDto dto){
        return service.findPageGoods(dto);
    }

    @GetMapping("all")
    @ApiOperation("获取所有商品")
    public Result getAll(){
        return service.getAll();
    }
    @PostMapping
	@ApiOperation("添加商品")
    public Result add(@Validated @RequestBody GoodsSaveDto dto){
        return service.insert(dto);
    }

    @PutMapping
	@ApiOperation("修改商品")
    public Result update(@Validated @RequestBody GoodsUpdateDto dto){
        return service.update(dto);
    }
    
    @DeleteMapping("/{goodsId}")
	@ApiOperation("根据ID删除")
    public Result deleteAll(@PathVariable String goodsId){
        return service.deleteAll(goodsId.toString().toString());
    }

    @GetMapping("/{goodsId}")
    @ApiOperation("根据ID查询")
    public Result getById(@PathVariable String goodsId){
        return service.getById(goodsId);
    }
}
