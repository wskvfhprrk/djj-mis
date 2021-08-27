package com.guardlbt.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import com.guardlbt.common.util.*;
import com.guardlbt.entity.ReportSite;
import com.guardlbt.service.ReportSiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;
import javax.validation.constraints.*;
import com.guardlbt.dto.*;

import java.util.*;
import javax.validation.*;

/**
* Created by 代码自动生成.
* 时间:2021-08-27 13:42:56
*/
@Api("定位信息上报控制器")
@RestController
@RequestMapping("reportSite")
public class ReportSiteController {

    @Autowired
    public ReportSiteService service;

    @GetMapping
	@ApiOperation("分页条件查询定位信息上报")
    public Result getPage(@Validated ReportSitePageDto dto){
        return service.findPageReportSite(dto);
    }

    @GetMapping("all")
    @ApiOperation("获取所有定位信息上报")
    public Result getAll(){
        return service.getAll();
    }

}
