package com.guardlbt.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.guardlbt.dao.ReportSiteDao;
import com.guardlbt.entity.ReportSite;
import com.guardlbt.service.ReportSiteService;
import com.guardlbt.util.*;
import com.guardlbt.common.util.*;
import com.guardlbt.dto.*;
import com.guardlbt.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;


/**
* 定位信息上报方法实现类
* Created by 代码自动生成.
* 时间:2021-08-27 13:42:56
*/
@Service
@Transactional
public class ReportSiteServiceImpl implements ReportSiteService {

    @Autowired
    private ReportSiteDao dao;

    @Override
    public Result findPageReportSite(ReportSitePageDto dto) {
        PageResult pageResult=new PageResult();
        PageHelper.startPage(dto.getPageNumber(),dto.getPageSize());
        ReportSite reportSite=new ReportSite();
        BeanUtils.copyProperties(dto,reportSite);
        List<ReportSite> list = dao.selectReportSites(reportSite);
        PageInfo<ReportSite> info=new PageInfo<>(list);
        pageResult.setTotle(info.getTotal());
        pageResult.setPageSize(dto.getPageSize());
        pageResult.setPageNumber(dto.getPageNumber());
        //转换vo出去
        List<ReportSitePageVo> vos = info.getList().stream().map(l -> {
            ReportSitePageVo vo = new ReportSitePageVo();
            BeanUtils.copyProperties(l, vo);
            return vo;
        }).collect(Collectors.toList());
        pageResult.setPages(vos);
        return Result.ok(pageResult);
    }

    @Override
    public Result getAll() {
        List<ReportSite> reportSites = dao.selectReportSites(null);
        return Result.ok(reportSites);
    }
        

}
