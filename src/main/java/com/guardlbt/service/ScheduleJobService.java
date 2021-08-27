package com.guardlbt.service;

import com.guardlbt.entity.ScheduleJob;
import com.guardlbt.dto.*;
import com.guardlbt.common.util.*;

import java.util.*;

/**
* 定时任务方法类接口
* Created by 代码自动生成.
* 时间:2021-08-26 16:20:27
*/
public interface ScheduleJobService {
    /**
    * 分页查询
    * @param dto 条件参数
    * @return easyui结果集
    */
    Result findPageScheduleJob( ScheduleJobPageDto dto);

    /**
    * 获取所有商圈
    * @return
    */
    Result getAll();

    /**
    * 条件查询全部数据
    * @param scheduleJob 条件参数
    * @return 国全部数据
    */
    Result findAllByScheduleJob(ScheduleJob scheduleJob);

    /**
    * 根据条件,只查询唯一一个值,如果存在多个只返回第一个
    * @param scheduleJob 条件参数
    * @return ScheduleJob对象
    */
    ScheduleJob findScheduleJob(ScheduleJob scheduleJob);

    /**
    * 添加定时任务
    * @param dto 条件参数
    * @return 结果集
    */
    Result insert(ScheduleJobSaveDto dto);
    /**
    * 修改定时任务
    * @param dto 条件参数
    * @return 结果集
    */
    Result update(ScheduleJobUpdateDto dto);
    /**
    * 删除定时任务
    * @param scheduleJob 条件参数
    * @return 结果集
    */
    Result delete(ScheduleJob scheduleJob);
    /**
    * 批量删除定时任务
    * @param ids 以逗号隔开的主键字符串,对于单个id也适用
    * @return 结果集
    */
    Result deleteAll(String ids);
    /**
    * 根据id查询定时任务
    * @param jobId
    * @return
    */
    Result getById(Long jobId);
}
