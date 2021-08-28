package com.guardlbt.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import com.guardlbt.common.util.*;
import com.guardlbt.entity.MemberOperationHistory;
import com.guardlbt.service.MemberOperationHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;
import javax.validation.constraints.*;
import com.guardlbt.dto.*;

import java.util.*;
import javax.validation.*;

/**
* Created by 代码自动生成.
* 时间:2021-08-28 11:42:17
*/
@Api("会员操作记录历史控制器")
@RestController
@RequestMapping("memberOperationHistory")
public class MemberOperationHistoryController {

    @Autowired
    public MemberOperationHistoryService service;

    @GetMapping
	@ApiOperation("分页条件查询会员操作记录历史")
    public Result getPage(@Validated MemberOperationHistoryPageDto dto){
        return service.findPageMemberOperationHistory(dto);
    }

    @GetMapping("all")
    @ApiOperation("获取所有会员操作记录历史")
    public Result getAll(){
        return service.getAll();
    }
    @PostMapping
	@ApiOperation("添加会员操作记录历史")
    public Result add(@Validated @RequestBody MemberOperationHistorySaveDto dto){
        return service.insert(dto);
    }

    @PutMapping
	@ApiOperation("修改会员操作记录历史")
    public Result update(@Validated @RequestBody MemberOperationHistoryUpdateDto dto){
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
