package com.guardlbt.dao;

import com.guardlbt.entity.ReportSite;
import org.apache.ibatis.jdbc.SQL;
import org.apache.commons.lang3.StringUtils;

/**
* 定位信息上报SQL语句
* Created by 代码自动生成.
* 时间:2021-08-27 13:42:56
*/
public class ReportSiteDaoSql {

    public static String selectReportSites(final ReportSite reportSite){
        return new SQL(){{
            SELECT("a.user_id ,a.report_time ,a.longitude ,a.latitude");
            FROM("report_site a");
            if(reportSite!=null && StringUtils.isNotBlank(reportSite.getUserId())){
                WHERE("a.User_id like CONCAT('%',#{userId},'%')");
            }
            if(reportSite!=null && reportSite.getReportTime()!=null && reportSite.getReportTime().toString().length()>0){
                WHERE("a.Report_time = #{reportTime}");
            }
            if(reportSite!=null && reportSite.getLongitude()!=null && reportSite.getLongitude().toString().length()>0){
                WHERE("a.Longitude = #{longitude}");
            }
            if(reportSite!=null && reportSite.getLatitude()!=null && reportSite.getLatitude().toString().length()>0){
                WHERE("a.Latitude = #{latitude}");
            }
        }}.toString();
    }

    public static String insert(final ReportSite reportSite){
        return new SQL(){{
            INSERT_INTO("report_site");
            if(StringUtils.isNotBlank(reportSite.getUserId())){
                VALUES("user_id", "#{userId}");
            }

            if(reportSite.getReportTime()!=null && reportSite.getReportTime().toString().length()>0){
                VALUES("report_time", "#{reportTime}");
            }

            if(reportSite.getLongitude()!=null && reportSite.getLongitude().toString().length()>0){
                VALUES("longitude", "#{longitude}");
            }

            if(reportSite.getLatitude()!=null && reportSite.getLatitude().toString().length()>0){
                VALUES("latitude", "#{latitude}");
            }
    }}.toString();
    }

    public static String update(final ReportSite reportSite){
        return new SQL(){{
            UPDATE("report_site");
                if(StringUtils.isNotBlank(reportSite.getUserId())){
                SET("user_id = #{userId}");
            }

                if(reportSite.getReportTime()!=null && reportSite.getReportTime().toString().length()>0){
                SET("report_time = #{reportTime}");
            }

                if(reportSite.getLongitude()!=null && reportSite.getLongitude().toString().length()>0){
                SET("longitude = #{longitude}");
            }

                if(reportSite.getLatitude()!=null && reportSite.getLatitude().toString().length()>0){
                SET("latitude = #{latitude}");
            }
        }}.toString();
    }

    public static String delete(final ReportSite reportSite){
        return new SQL(){{
            DELETE_FROM("report_site");
                if(StringUtils.isNotBlank(reportSite.getUserId())){
                WHERE("user_id = #{userId}");
            }

                if(reportSite.getReportTime()!=null && reportSite.getReportTime().toString().length()>0){
                WHERE("report_time = #{reportTime}");
            }

                if(reportSite.getLongitude()!=null && reportSite.getLongitude().toString().length()>0){
                WHERE("longitude = #{longitude}");
            }

                if(reportSite.getLatitude()!=null && reportSite.getLatitude().toString().length()>0){
                WHERE("latitude = #{latitude}");
            }
        }}.toString();
    }
}
