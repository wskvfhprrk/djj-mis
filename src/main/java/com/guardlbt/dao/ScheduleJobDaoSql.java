package com.guardlbt.dao;

import com.guardlbt.entity.ScheduleJob;
import org.apache.ibatis.jdbc.SQL;
import org.apache.commons.lang3.StringUtils;

/**
* 定时任务SQL语句
* Created by 代码自动生成.
* 时间:2021-08-27 13:42:56
*/
public class ScheduleJobDaoSql {

    public static String selectScheduleJobs(final ScheduleJob scheduleJob){
        return new SQL(){{
            SELECT("a.job_id ,a.bean_name ,a.method_name ,a.params ,a.cron_expression ,a.status ,a.remark ,a.create_time");
            FROM("schedule_job a");

            if(scheduleJob!=null && scheduleJob.getJobId()!=null && scheduleJob.getJobId().toString().length()>0){
                WHERE("a.Job_id = #{jobId}");
            }            if(scheduleJob!=null && StringUtils.isNotBlank(scheduleJob.getBeanName())){
                WHERE("a.Bean_name like CONCAT('%',#{beanName},'%')");
            }            if(scheduleJob!=null && StringUtils.isNotBlank(scheduleJob.getMethodName())){
                WHERE("a.Method_name like CONCAT('%',#{methodName},'%')");
            }            if(scheduleJob!=null && StringUtils.isNotBlank(scheduleJob.getParams())){
                WHERE("a.Params like CONCAT('%',#{params},'%')");
            }            if(scheduleJob!=null && StringUtils.isNotBlank(scheduleJob.getCronExpression())){
                WHERE("a.Cron_expression like CONCAT('%',#{cronExpression},'%')");
            }            if(scheduleJob!=null && StringUtils.isNotBlank(scheduleJob.getStatus())){
                WHERE("a.Status like CONCAT('%',#{status},'%')");
            }            if(scheduleJob!=null && StringUtils.isNotBlank(scheduleJob.getRemark())){
                WHERE("a.Remark like CONCAT('%',#{remark},'%')");
            }
            if(scheduleJob!=null && scheduleJob.getCreateTime()!=null && scheduleJob.getCreateTime().toString().length()>0){
                WHERE("a.Create_time = #{createTime}");
            }
        }}.toString();
    }

    public static String insert(final ScheduleJob scheduleJob){
        return new SQL(){{
            INSERT_INTO("schedule_job");

            if(scheduleJob.getJobId()!=null && scheduleJob.getJobId().toString().length()>0){
                VALUES("job_id", "#{jobId}");
            }
            if(StringUtils.isNotBlank(scheduleJob.getBeanName())){
                VALUES("bean_name", "#{beanName}");
            }
            if(StringUtils.isNotBlank(scheduleJob.getMethodName())){
                VALUES("method_name", "#{methodName}");
            }
            if(StringUtils.isNotBlank(scheduleJob.getParams())){
                VALUES("params", "#{params}");
            }
            if(StringUtils.isNotBlank(scheduleJob.getCronExpression())){
                VALUES("cron_expression", "#{cronExpression}");
            }
            if(StringUtils.isNotBlank(scheduleJob.getStatus())){
                VALUES("status", "#{status}");
            }
            if(StringUtils.isNotBlank(scheduleJob.getRemark())){
                VALUES("remark", "#{remark}");
            }

            if(scheduleJob.getCreateTime()!=null && scheduleJob.getCreateTime().toString().length()>0){
                VALUES("create_time", "#{createTime}");
            }
    }}.toString();
    }

    public static String update(final ScheduleJob scheduleJob){
        return new SQL(){{
            UPDATE("schedule_job");

                if(scheduleJob.getJobId()!=null && scheduleJob.getJobId().toString().length()>0){
                SET("job_id = #{jobId}");
            }
                if(StringUtils.isNotBlank(scheduleJob.getBeanName())){
                SET("bean_name = #{beanName}");
            }
                if(StringUtils.isNotBlank(scheduleJob.getMethodName())){
                SET("method_name = #{methodName}");
            }
                if(StringUtils.isNotBlank(scheduleJob.getParams())){
                SET("params = #{params}");
            }
                if(StringUtils.isNotBlank(scheduleJob.getCronExpression())){
                SET("cron_expression = #{cronExpression}");
            }
                if(StringUtils.isNotBlank(scheduleJob.getStatus())){
                SET("status = #{status}");
            }
                if(StringUtils.isNotBlank(scheduleJob.getRemark())){
                SET("remark = #{remark}");
            }

                if(scheduleJob.getCreateTime()!=null && scheduleJob.getCreateTime().toString().length()>0){
                SET("create_time = #{createTime}");
            }

                if(scheduleJob.getJobId()!=null && scheduleJob.getJobId().toString().length()>0){
                WHERE("job_id = #{jobId}");
            }
        }}.toString();
    }

    public static String delete(final ScheduleJob scheduleJob){
        return new SQL(){{
            DELETE_FROM("schedule_job");

                if(scheduleJob.getJobId()!=null && scheduleJob.getJobId().toString().length()>0){
                WHERE("job_id = #{jobId}");
            }
                if(StringUtils.isNotBlank(scheduleJob.getBeanName())){
                WHERE("bean_name = #{beanName}");
            }
                if(StringUtils.isNotBlank(scheduleJob.getMethodName())){
                WHERE("method_name = #{methodName}");
            }
                if(StringUtils.isNotBlank(scheduleJob.getParams())){
                WHERE("params = #{params}");
            }
                if(StringUtils.isNotBlank(scheduleJob.getCronExpression())){
                WHERE("cron_expression = #{cronExpression}");
            }
                if(StringUtils.isNotBlank(scheduleJob.getStatus())){
                WHERE("status = #{status}");
            }
                if(StringUtils.isNotBlank(scheduleJob.getRemark())){
                WHERE("remark = #{remark}");
            }

                if(scheduleJob.getCreateTime()!=null && scheduleJob.getCreateTime().toString().length()>0){
                WHERE("create_time = #{createTime}");
            }
        }}.toString();
    }
}
