package com.guardlbt.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.guardlbt.dao.ScheduleJobDao;
import com.guardlbt.entity.ScheduleJob;
import com.guardlbt.service.ScheduleJobService;
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
* 定时任务方法实现类
* Created by 代码自动生成.
* 时间:2021-08-26 16:20:27
*/
@Service
@Transactional
public class ScheduleJobServiceImpl implements ScheduleJobService {

    @Autowired
    private ScheduleJobDao dao;

    @Override
    public Result findPageScheduleJob(ScheduleJobPageDto dto) {
        PageResult pageResult=new PageResult();
        PageHelper.startPage(dto.getPageNumber(),dto.getPageSize());
        ScheduleJob scheduleJob=new ScheduleJob();
        BeanUtils.copyProperties(dto,scheduleJob);
        List<ScheduleJob> list = dao.selectScheduleJobs(scheduleJob);
        PageInfo<ScheduleJob> info=new PageInfo<>(list);
        pageResult.setTotle(info.getTotal());
        pageResult.setPageSize(dto.getPageSize());
        pageResult.setPageNumber(dto.getPageNumber());
        //转换vo出去
        List<ScheduleJobPageVo> vos = info.getList().stream().map(l -> {
            ScheduleJobPageVo vo = new ScheduleJobPageVo();
            BeanUtils.copyProperties(l, vo);
            return vo;
        }).collect(Collectors.toList());
        pageResult.setPages(vos);
        return Result.ok(pageResult);
    }

    @Override
    public Result getAll() {
        List<ScheduleJob> scheduleJobs = dao.selectScheduleJobs(null);
        return Result.ok(scheduleJobs);
    }
        
    @Override
    public Result findAllByScheduleJob(ScheduleJob scheduleJob) {
        List<ScheduleJob> scheduleJobs = dao.selectScheduleJobs(scheduleJob);
        //转换vo出去
        List<ScheduleJobPageVo> vos = scheduleJobs.stream().map(l -> {
        ScheduleJobPageVo vo = new ScheduleJobPageVo();
        BeanUtils.copyProperties(l, vo);
        return vo;
        }).collect(Collectors.toList());
        return Result.ok(vos);
    }

    @Override
    public ScheduleJob findScheduleJob(ScheduleJob scheduleJob) {
        List<ScheduleJob> list = dao.selectScheduleJobs(scheduleJob);
        if(!list.isEmpty()){
            return list.get(0);
        }
        return null;
    }

    @Override
    public Result insert(ScheduleJobSaveDto dto) {
        ScheduleJob scheduleJob=new ScheduleJob();
        BeanUtils.copyProperties(dto,scheduleJob);
        
        try{
            dao.insert(scheduleJob);
            return Result.ok();
        }catch (Exception e){
            e.printStackTrace();
            return Result.error(500,e.getCause().getMessage());
        }
    }

    @Override
    public Result update(ScheduleJobUpdateDto dto) {
        ScheduleJob scheduleJob=new ScheduleJob();
        BeanUtils.copyProperties(dto,scheduleJob);
        try{
            dao.update(scheduleJob);
            return Result.ok();
        }catch (Exception e){
            e.printStackTrace();
            return Result.error(500,e.getCause().getMessage());
        }
    }

    @Override
    public Result delete(ScheduleJob scheduleJob) {
        try{
            dao.delete(scheduleJob);
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
    public Result getById(Long jobId) {
        ScheduleJob scheduleJob=new ScheduleJob();
        scheduleJob.setJobId(jobId);
        List<ScheduleJob> scheduleJobs = dao.selectScheduleJobs(scheduleJob);
        if(scheduleJobs.isEmpty()){
            return Result.ok();
        }
        return Result.ok(scheduleJobs.get(0));
    }
}
