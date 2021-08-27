package com.guardlbt.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import com.guardlbt.common.util.*;
import com.guardlbt.entity.Member;
import com.guardlbt.service.MemberService;
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
@Api("会员控制器")
@RestController
@RequestMapping("member")
public class MemberController {

    @Autowired
    public MemberService service;

    @GetMapping
	@ApiOperation("分页条件查询会员")
    public Result getPage(@Validated MemberPageDto dto){
        return service.findPageMember(dto);
    }

    @GetMapping("all")
    @ApiOperation("获取所有会员")
    public Result getAll(){
        return service.getAll();
    }
    @PostMapping
	@ApiOperation("添加会员")
    public Result add(@Validated @RequestBody MemberSaveDto dto){
        return service.insert(dto);
    }

    @PutMapping
	@ApiOperation("修改会员")
    public Result update(@Validated @RequestBody MemberUpdateDto dto){
        return service.update(dto);
    }
    
    @DeleteMapping("/{memberId}")
	@ApiOperation("根据ID删除")
    public Result deleteAll(@PathVariable String memberId){
        return service.deleteAll(memberId.toString().toString());
    }

    @GetMapping("/{memberId}")
    @ApiOperation("根据ID查询")
    public Result getById(@PathVariable String memberId){
        return service.getById(memberId);
    }
}
