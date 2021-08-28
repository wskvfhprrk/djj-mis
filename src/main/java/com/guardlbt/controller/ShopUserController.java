package com.guardlbt.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import com.guardlbt.common.util.*;
import com.guardlbt.entity.ShopUser;
import com.guardlbt.service.ShopUserService;
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
@Api("商店管理员控制器")
@RestController
@RequestMapping("shopUser")
public class ShopUserController {

    @Autowired
    public ShopUserService service;

    @GetMapping
	@ApiOperation("分页条件查询商店管理员")
    public Result getPage(@Validated ShopUserPageDto dto){
        return service.findPageShopUser(dto);
    }

    @GetMapping("all")
    @ApiOperation("获取所有商店管理员")
    public Result getAll(){
        return service.getAll();
    }
    @PostMapping
	@ApiOperation("添加商店管理员")
    public Result add(@Validated @RequestBody ShopUserSaveDto dto){
        return service.insert(dto);
    }

    @PutMapping
	@ApiOperation("修改商店管理员")
    public Result update(@Validated @RequestBody ShopUserUpdateDto dto){
        return service.update(dto);
    }
    
    @DeleteMapping("/{userId}")
	@ApiOperation("根据ID删除")
    public Result deleteAll(@PathVariable String userId){
        return service.deleteAll(userId.toString().toString().toString().toString().toString().toString());
    }

    @GetMapping("/{userId}")
    @ApiOperation("根据ID查询")
    public Result getById(@PathVariable String userId){
        return service.getById(userId);
    }
}
