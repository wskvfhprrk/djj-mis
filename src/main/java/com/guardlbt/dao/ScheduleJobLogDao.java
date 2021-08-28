package com.guardlbt.dao;

import com.guardlbt.entity.ScheduleJobLog;
import org.apache.ibatis.annotations.*;

import java.util.*;

/**
* 定时任务日志dao方法
* Created by 代码自动生成.
* 时间:2021-08-28 11:42:19
*/
@Mapper
public interface ScheduleJobLogDao {

    /**
    * 条件查询全部数据
    * @param scheduleJobLog
    * @return List<Map>类型的集合
    */
    @Results(value = {
        @Result(column = "log_id", property = "logId", id=true),
        @Result(column = "job_id", property = "jobId"),
        @Result(column = "bean_name", property = "beanName"),
        @Result(column = "method_name", property = "methodName"),
        @Result(column = "params", property = "params"),
        @Result(column = "status", property = "status"),
        @Result(column = "error", property = "error"),
        @Result(column = "times", property = "times"),
        @Result(column = "create_time", property = "createTime"),
    })
    @SelectProvider(type = ScheduleJobLogDaoSql.class, method = "selectScheduleJobLogs")
    List<ScheduleJobLog> selectScheduleJobLogs(ScheduleJobLog scheduleJobLog);


    /**
    * 添加
    * @param scheduleJobLog
    */
    @SelectProvider(type = ScheduleJobLogDaoSql.class, method = "insert")
    void insert(ScheduleJobLog scheduleJobLog);

    /**
    * 更新
    * @param scheduleJobLog
    */
    @SelectProvider(type = ScheduleJobLogDaoSql.class, method = "update")
    void update(ScheduleJobLog scheduleJobLog);

    /**
    * 根据条件删除
    * @param scheduleJobLog
    */
    @SelectProvider(type = ScheduleJobLogDaoSql.class, method = "delete")
    void delete(ScheduleJobLog scheduleJobLog);

    /**
    * 根据主键IDS批量删除(只适合单主键,不支持多主键批量删除,多主键时请删除SQL中多余主键字段)
    * @param ids 主键字符串集合
    */
    @Select("<script>" +
        "DELETE FROM schedule_job_log WHERE log_id IN " +
        "<foreach item='item' index='index' collection='ids' open='(' separator=',' close=')'>#{item}</foreach> </script>")
    void deleteAll(@Param("ids") List<String> ids);

}
