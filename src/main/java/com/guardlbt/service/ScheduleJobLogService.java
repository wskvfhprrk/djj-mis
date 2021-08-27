package com.guardlbt.service;

import com.guardlbt.entity.ScheduleJobLog;
import com.guardlbt.dto.*;
import com.guardlbt.common.util.*;

import java.util.*;

/**
* 定时任务日志方法类接口
* Created by 代码自动生成.
* 时间:2021-08-27 13:42:56
*/
public interface ScheduleJobLogService {
    /**
    * 分页查询
    * @param dto 条件参数
    * @return easyui结果集
    */
    Result findPageScheduleJobLog( ScheduleJobLogPageDto dto);

    /**
    * 获取所有商圈
    * @return
    */
    Result getAll();

    /**
    * 条件查询全部数据
    * @param scheduleJobLog 条件参数
    * @return 国全部数据
    */
    Result findAllByScheduleJobLog(ScheduleJobLog scheduleJobLog);

    /**
    * 根据条件,只查询唯一一个值,如果存在多个只返回第一个
    * @param scheduleJobLog 条件参数
    * @return ScheduleJobLog对象
    */
    ScheduleJobLog findScheduleJobLog(ScheduleJobLog scheduleJobLog);

    /**
    * 添加定时任务日志
    * @param dto 条件参数
    * @return 结果集
    */
    Result insert(ScheduleJobLogSaveDto dto);
    /**
    * 修改定时任务日志
    * @param dto 条件参数
    * @return 结果集
    */
    Result update(ScheduleJobLogUpdateDto dto);
    /**
    * 删除定时任务日志
    * @param scheduleJobLog 条件参数
    * @return 结果集
    */
    Result delete(ScheduleJobLog scheduleJobLog);
    /**
    * 批量删除定时任务日志
    * @param ids 以逗号隔开的主键字符串,对于单个id也适用
    * @return 结果集
    */
    Result deleteAll(String ids);
    /**
    * 根据id查询定时任务日志
    * @param logId
    * @return
    */
    Result getById(Long logId);
}
