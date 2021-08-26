package com.guardlbt.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import com.guardlbt.common.util.*;
import com.guardlbt.entity.IndexImages;
import com.guardlbt.service.IndexImagesService;
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
@Api("轮播图控制器")
@RestController
@RequestMapping("indexImages")
public class IndexImagesController {

    @Autowired
    public IndexImagesService service;

    @GetMapping
	@ApiOperation("分页条件查询轮播图")
    public Result getPage(@Validated IndexImagesPageDto dto){
        return service.findPageIndexImages(dto);
    }

    @GetMapping("all")
    @ApiOperation("获取所有轮播图")
    public Result getAll(){
        return service.getAll();
    }
    @PostMapping
	@ApiOperation("添加轮播图")
    public Result add(@Validated @RequestBody IndexImagesSaveDto dto){
        return service.insert(dto);
    }

    @PutMapping
	@ApiOperation("修改轮播图")
    public Result update(@Validated @RequestBody IndexImagesUpdateDto dto){
        return service.update(dto);
    }
    
    @DeleteMapping("/{id}")
	@ApiOperation("根据ID删除")
    public Result deleteAll(@PathVariable Integer id){
        return service.deleteAll(id.toString());
    }

    @GetMapping("/{id}")
    @ApiOperation("根据ID查询")
    public Result getById(@PathVariable Integer id){
        return service.getById(id);
    }
}
