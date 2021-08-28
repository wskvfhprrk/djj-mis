package com.guardlbt.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import com.guardlbt.common.util.*;
import com.guardlbt.entity.Picture;
import com.guardlbt.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;
import javax.validation.constraints.*;
import com.guardlbt.dto.*;

import java.util.*;
import javax.validation.*;

/**
* Created by 代码自动生成.
* 时间:2021-08-28 11:42:19
*/
@Api("图片管理控制器")
@RestController
@RequestMapping("picture")
public class PictureController {

    @Autowired
    public PictureService service;

    @GetMapping
	@ApiOperation("分页条件查询图片管理")
    public Result getPage(@Validated PicturePageDto dto){
        return service.findPagePicture(dto);
    }

    @GetMapping("all")
    @ApiOperation("获取所有图片管理")
    public Result getAll(){
        return service.getAll();
    }
    @PostMapping
	@ApiOperation("添加图片管理")
    public Result add(@Validated @RequestBody PictureSaveDto dto){
        return service.insert(dto);
    }

    @PutMapping
	@ApiOperation("修改图片管理")
    public Result update(@Validated @RequestBody PictureUpdateDto dto){
        return service.update(dto);
    }
    
    @DeleteMapping("/{id}")
	@ApiOperation("根据ID删除")
    public Result deleteAll(@PathVariable String id){
        return service.deleteAll(id.toString().toString().toString().toString());
    }

    @GetMapping("/{id}")
    @ApiOperation("根据ID查询")
    public Result getById(@PathVariable String id){
        return service.getById(id);
    }
}
