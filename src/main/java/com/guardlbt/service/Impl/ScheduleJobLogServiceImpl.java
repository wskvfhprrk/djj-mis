package com.guardlbt.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.guardlbt.dao.ScheduleJobLogDao;
import com.guardlbt.entity.ScheduleJobLog;
import com.guardlbt.service.ScheduleJobLogService;
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
* 定时任务日志方法实现类
* Created by 代码自动生成.
* 时间:2021-08-25 18:06:24
*/
@Service
@Transactional
public class ScheduleJobLogServiceImpl implements ScheduleJobLogService {

    @Autowired
    private ScheduleJobLogDao dao;

    @Override
    public Result findPageScheduleJobLog(ScheduleJobLogPageDto dto) {
        PageResult pageResult=new PageResult();
        PageHelper.startPage(dto.getPageNumber(),dto.getPageSize());
        ScheduleJobLog scheduleJobLog=new ScheduleJobLog();
        BeanUtils.copyProperties(dto,scheduleJobLog);
        List<ScheduleJobLog> list = dao.selectScheduleJobLogs(scheduleJobLog);
        PageInfo<ScheduleJobLog> info=new PageInfo<>(list);
        pageResult.setTotle(info.getTotal());
        pageResult.setPageSize(dto.getPageSize());
        pageResult.setPageNumber(dto.getPageNumber());
        //转换vo出去
        List<ScheduleJobLogPageVo> vos = info.getList().stream().map(l -> {
            ScheduleJobLogPageVo vo = new ScheduleJobLogPageVo();
            BeanUtils.copyProperties(l, vo);
            return vo;
        }).collect(Collectors.toList());
        pageResult.setPages(vos);
        return Result.ok(pageResult);
    }

    @Override
    public Result getAll() {
        List<ScheduleJobLog> scheduleJobLogs = dao.selectScheduleJobLogs(null);
        return Result.ok(scheduleJobLogs);
    }
        
    @Override
    public Result findAllByScheduleJobLog(ScheduleJobLog scheduleJobLog) {
        List<ScheduleJobLog> scheduleJobLogs = dao.selectScheduleJobLogs(scheduleJobLog);
        //转换vo出去
        List<ScheduleJobLogPageVo> vos = scheduleJobLogs.stream().map(l -> {
        ScheduleJobLogPageVo vo = new ScheduleJobLogPageVo();
        BeanUtils.copyProperties(l, vo);
        return vo;
        }).collect(Collectors.toList());
        return Result.ok(vos);
    }

    @Override
    public ScheduleJobLog findScheduleJobLog(ScheduleJobLog scheduleJobLog) {
        List<ScheduleJobLog> list = dao.selectScheduleJobLogs(scheduleJobLog);
        if(!list.isEmpty()){
            return list.get(0);
        }
        return null;
    }

    @Override
    public Result insert(ScheduleJobLogSaveDto dto) {
        ScheduleJobLog scheduleJobLog=new ScheduleJobLog();
        BeanUtils.copyProperties(dto,scheduleJobLog);
        
        try{
            dao.insert(scheduleJobLog);
            return Result.ok();
        }catch (Exception e){
            e.printStackTrace();
            return Result.error(500,e.getCause().getMessage());
        }
    }

    @Override
    public Result update(ScheduleJobLogUpdateDto dto) {
        ScheduleJobLog scheduleJobLog=new ScheduleJobLog();
        BeanUtils.copyProperties(dto,scheduleJobLog);
        try{
            dao.update(scheduleJobLog);
            return Result.ok();
        }catch (Exception e){
            e.printStackTrace();
            return Result.error(500,e.getCause().getMessage());
        }
    }

    @Override
    public Result delete(ScheduleJobLog scheduleJobLog) {
        try{
            dao.delete(scheduleJobLog);
            return Result.ok();
        }catch (Exception e){
            e.printStackTrace();
            return Result.error(500,e.getCause().getMessage());
        }
    }

    @Override
    public Result deleteAll(String ids) {
        try{
            String[] strings = ids.split(",");
            List<String> list=new ArrayList<>();
            for (int i = 0; i <strings.length ; i++) {
                list.add(strings[i]);
            }
            dao.deleteAll(list);
            return Result.ok();
        }catch (Exception e){
            e.printStackTrace();
            return Result.error(500,e.getCause().getMessage());
        }
    }

    @Override
    public Result getById(Long logId) {
        ScheduleJobLog scheduleJobLog=new ScheduleJobLog();
        scheduleJobLog.setLogId(logId);
        List<ScheduleJobLog> scheduleJobLogs = dao.selectScheduleJobLogs(scheduleJobLog);
        if(scheduleJobLogs.isEmpty()){
            return Result.ok();
        }
        return Result.ok(scheduleJobLogs.get(0));
    }
}
