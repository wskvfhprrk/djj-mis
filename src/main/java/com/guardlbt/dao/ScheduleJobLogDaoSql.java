package com.guardlbt.dao;

import com.guardlbt.entity.ScheduleJobLog;
import org.apache.ibatis.jdbc.SQL;
import org.apache.commons.lang3.StringUtils;

/**
* 定时任务日志SQL语句
* Created by 代码自动生成.
* 时间:2021-08-28 11:42:19
*/
public class ScheduleJobLogDaoSql {

    public static String selectScheduleJobLogs(final ScheduleJobLog scheduleJobLog){
        return new SQL(){{
            SELECT("a.log_id ,a.job_id ,a.bean_name ,a.method_name ,a.params ,a.status ,a.error ,a.times ,a.create_time");
            FROM("schedule_job_log a");

            if(scheduleJobLog!=null && scheduleJobLog.getLogId()!=null && scheduleJobLog.getLogId().toString().length()>0){
                WHERE("a.Log_id = #{logId}");
            }
            if(scheduleJobLog!=null && scheduleJobLog.getJobId()!=null && scheduleJobLog.getJobId().toString().length()>0){
                WHERE("a.Job_id = #{jobId}");
            }            if(scheduleJobLog!=null && StringUtils.isNotBlank(scheduleJobLog.getBeanName())){
                WHERE("a.Bean_name like CONCAT('%',#{beanName},'%')");
            }            if(scheduleJobLog!=null && StringUtils.isNotBlank(scheduleJobLog.getMethodName())){
                WHERE("a.Method_name like CONCAT('%',#{methodName},'%')");
            }            if(scheduleJobLog!=null && StringUtils.isNotBlank(scheduleJobLog.getParams())){
                WHERE("a.Params like CONCAT('%',#{params},'%')");
            }
            if(scheduleJobLog!=null && scheduleJobLog.getStatus()!=null && scheduleJobLog.getStatus().toString().length()>0){
                WHERE("a.Status = #{status}");
            }            if(scheduleJobLog!=null && StringUtils.isNotBlank(scheduleJobLog.getError())){
                WHERE("a.Error like CONCAT('%',#{error},'%')");
            }
            if(scheduleJobLog!=null && scheduleJobLog.getTimes()!=null && scheduleJobLog.getTimes().toString().length()>0){
                WHERE("a.Times = #{times}");
            }
            if(scheduleJobLog!=null && scheduleJobLog.getCreateTime()!=null && scheduleJobLog.getCreateTime().toString().length()>0){
                WHERE("a.Create_time = #{createTime}");
            }
        }}.toString();
    }

    public static String insert(final ScheduleJobLog scheduleJobLog){
        return new SQL(){{
            INSERT_INTO("schedule_job_log");

            if(scheduleJobLog.getLogId()!=null && scheduleJobLog.getLogId().toString().length()>0){
                VALUES("log_id", "#{logId}");
            }

            if(scheduleJobLog.getJobId()!=null && scheduleJobLog.getJobId().toString().length()>0){
                VALUES("job_id", "#{jobId}");
            }
            if(StringUtils.isNotBlank(scheduleJobLog.getBeanName())){
                VALUES("bean_name", "#{beanName}");
            }
            if(StringUtils.isNotBlank(scheduleJobLog.getMethodName())){
                VALUES("method_name", "#{methodName}");
            }
            if(StringUtils.isNotBlank(scheduleJobLog.getParams())){
                VALUES("params", "#{params}");
            }

            if(scheduleJobLog.getStatus()!=null && scheduleJobLog.getStatus().toString().length()>0){
                VALUES("status", "#{status}");
            }
            if(StringUtils.isNotBlank(scheduleJobLog.getError())){
                VALUES("error", "#{error}");
            }

            if(scheduleJobLog.getTimes()!=null && scheduleJobLog.getTimes().toString().length()>0){
                VALUES("times", "#{times}");
            }

            if(scheduleJobLog.getCreateTime()!=null && scheduleJobLog.getCreateTime().toString().length()>0){
                VALUES("create_time", "#{createTime}");
            }
    }}.toString();
    }

    public static String update(final ScheduleJobLog scheduleJobLog){
        return new SQL(){{
            UPDATE("schedule_job_log");

                if(scheduleJobLog.getLogId()!=null && scheduleJobLog.getLogId().toString().length()>0){
                SET("log_id = #{logId}");
            }

                if(scheduleJobLog.getJobId()!=null && scheduleJobLog.getJobId().toString().length()>0){
                SET("job_id = #{jobId}");
            }
                if(StringUtils.isNotBlank(scheduleJobLog.getBeanName())){
                SET("bean_name = #{beanName}");
            }
                if(StringUtils.isNotBlank(scheduleJobLog.getMethodName())){
                SET("method_name = #{methodName}");
            }
                if(StringUtils.isNotBlank(scheduleJobLog.getParams())){
                SET("params = #{params}");
            }

                if(scheduleJobLog.getStatus()!=null && scheduleJobLog.getStatus().toString().length()>0){
                SET("status = #{status}");
            }
                if(StringUtils.isNotBlank(scheduleJobLog.getError())){
                SET("error = #{error}");
            }

                if(scheduleJobLog.getTimes()!=null && scheduleJobLog.getTimes().toString().length()>0){
                SET("times = #{times}");
            }

                if(scheduleJobLog.getCreateTime()!=null && scheduleJobLog.getCreateTime().toString().length()>0){
                SET("create_time = #{createTime}");
            }

                if(scheduleJobLog.getLogId()!=null && scheduleJobLog.getLogId().toString().length()>0){
                WHERE("log_id = #{logId}");
            }
        }}.toString();
    }

    public static String delete(final ScheduleJobLog scheduleJobLog){
        return new SQL(){{
            DELETE_FROM("schedule_job_log");

                if(scheduleJobLog.getLogId()!=null && scheduleJobLog.getLogId().toString().length()>0){
                WHERE("log_id = #{logId}");
            }

                if(scheduleJobLog.getJobId()!=null && scheduleJobLog.getJobId().toString().length()>0){
                WHERE("job_id = #{jobId}");
            }
                if(StringUtils.isNotBlank(scheduleJobLog.getBeanName())){
                WHERE("bean_name = #{beanName}");
            }
                if(StringUtils.isNotBlank(scheduleJobLog.getMethodName())){
                WHERE("method_name = #{methodName}");
            }
                if(StringUtils.isNotBlank(scheduleJobLog.getParams())){
                WHERE("params = #{params}");
            }

                if(scheduleJobLog.getStatus()!=null && scheduleJobLog.getStatus().toString().length()>0){
                WHERE("status = #{status}");
            }
                if(StringUtils.isNotBlank(scheduleJobLog.getError())){
                WHERE("error = #{error}");
            }

                if(scheduleJobLog.getTimes()!=null && scheduleJobLog.getTimes().toString().length()>0){
                WHERE("times = #{times}");
            }

                if(scheduleJobLog.getCreateTime()!=null && scheduleJobLog.getCreateTime().toString().length()>0){
                WHERE("create_time = #{createTime}");
            }
        }}.toString();
    }
}
