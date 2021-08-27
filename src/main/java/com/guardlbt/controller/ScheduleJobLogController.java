package com.guardlbt.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import com.guardlbt.common.util.*;
import com.guardlbt.entity.ScheduleJobLog;
import com.guardlbt.service.ScheduleJobLogService;
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
@Api("定时任务日志控制器")
@RestController
@RequestMapping("scheduleJobLog")
public class ScheduleJobLogController {

    @Autowired
    public ScheduleJobLogService service;

    @GetMapping
	@ApiOperation("分页条件查询定时任务日志")
    public Result getPage(@Validated ScheduleJobLogPageDto dto){
        return service.findPageScheduleJobLog(dto);
    }

    @GetMapping("all")
    @ApiOperation("获取所有定时任务日志")
    public Result getAll(){
        return service.getAll();
    }
    @PostMapping
	@ApiOperation("添加定时任务日志")
    public Result add(@Validated @RequestBody ScheduleJobLogSaveDto dto){
        return service.insert(dto);
    }

    @PutMapping
	@ApiOperation("修改定时任务日志")
    public Result update(@Validated @RequestBody ScheduleJobLogUpdateDto dto){
        return service.update(dto);
    }
    
    @DeleteMapping("/{logId}")
	@ApiOperation("根据ID删除")
    public Result deleteAll(@PathVariable Long logId){
        return service.deleteAll(logId.toString().toString().toString().toString());
    }

    @GetMapping("/{logId}")
    @ApiOperation("根据ID查询")
    public Result getById(@PathVariable Long logId){
        return service.getById(logId);
    }
}
