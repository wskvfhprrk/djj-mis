package com.guardlbt.dao;

import com.guardlbt.entity.ScheduleJob;
import org.apache.ibatis.annotations.*;

import java.util.*;

/**
* 定时任务dao方法
* Created by 代码自动生成.
* 时间:2021-08-26 16:20:27
*/
@Mapper
public interface ScheduleJobDao {

    /**
    * 条件查询全部数据
    * @param scheduleJob
    * @return List<Map>类型的集合
    */
    @Results(value = {
        @Result(column = "job_id", property = "jobId", id=true),
        @Result(column = "bean_name", property = "beanName"),
        @Result(column = "method_name", property = "methodName"),
        @Result(column = "params", property = "params"),
        @Result(column = "cron_expression", property = "cronExpression"),
        @Result(column = "status", property = "status"),
        @Result(column = "remark", property = "remark"),
        @Result(column = "create_time", property = "createTime"),
    })
    @SelectProvider(type = ScheduleJobDaoSql.class, method = "selectScheduleJobs")
    List<ScheduleJob> selectScheduleJobs(ScheduleJob scheduleJob);


    /**
    * 添加
    * @param scheduleJob
    */
    @SelectProvider(type = ScheduleJobDaoSql.class, method = "insert")
    void insert(ScheduleJob scheduleJob);

    /**
    * 更新
    * @param scheduleJob
    */
    @SelectProvider(type = ScheduleJobDaoSql.class, method = "update")
    void update(ScheduleJob scheduleJob);

    /**
    * 根据条件删除
    * @param scheduleJob
    */
    @SelectProvider(type = ScheduleJobDaoSql.class, method = "delete")
    void delete(ScheduleJob scheduleJob);

    /**
    * 根据主键IDS批量删除(只适合单主键,不支持多主键批量删除,多主键时请删除SQL中多余主键字段)
    * @param ids 主键字符串集合
    */
    @Select("<script>" +
        "DELETE FROM schedule_job WHERE job_id IN " +
        "<foreach item='item' index='index' collection='ids' open='(' separator=',' close=')'>#{item}</foreach> </script>")
    void deleteAll(@Param("ids") List<String> ids);

}
