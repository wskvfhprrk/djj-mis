package com.guardlbt.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import com.guardlbt.common.util.*;
import com.guardlbt.entity.ScheduleJob;
import com.guardlbt.service.ScheduleJobService;
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
@Api("定时任务控制器")
@RestController
@RequestMapping("scheduleJob")
public class ScheduleJobController {

    @Autowired
    public ScheduleJobService service;

    @GetMapping
	@ApiOperation("分页条件查询定时任务")
    public Result getPage(@Validated ScheduleJobPageDto dto){
        return service.findPageScheduleJob(dto);
    }

    @GetMapping("all")
    @ApiOperation("获取所有定时任务")
    public Result getAll(){
        return service.getAll();
    }
    @PostMapping
	@ApiOperation("添加定时任务")
    public Result add(@Validated @RequestBody ScheduleJobSaveDto dto){
        return service.insert(dto);
    }

    @PutMapping
	@ApiOperation("修改定时任务")
    public Result update(@Validated @RequestBody ScheduleJobUpdateDto dto){
        return service.update(dto);
    }
    
    @DeleteMapping("/{jobId}")
	@ApiOperation("根据ID删除")
    public Result deleteAll(@PathVariable Long jobId){
        return service.deleteAll(jobId.toString().toString());
    }

    @GetMapping("/{jobId}")
    @ApiOperation("根据ID查询")
    public Result getById(@PathVariable Long jobId){
        return service.getById(jobId);
    }
}
