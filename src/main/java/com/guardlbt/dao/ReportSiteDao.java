package com.guardlbt.dao;

import com.guardlbt.entity.ReportSite;
import org.apache.ibatis.annotations.*;

import java.util.*;

/**
* 定位信息上报dao方法
* Created by 代码自动生成.
* 时间:2021-08-27 13:42:56
*/
@Mapper
public interface ReportSiteDao {

    /**
    * 条件查询全部数据
    * @param reportSite
    * @return List<Map>类型的集合
    */
    @Results(value = {
        @Result(column = "user_id", property = "userId"),
        @Result(column = "report_time", property = "reportTime"),
        @Result(column = "longitude", property = "longitude"),
        @Result(column = "latitude", property = "latitude"),
    })
    @SelectProvider(type = ReportSiteDaoSql.class, method = "selectReportSites")
    List<ReportSite> selectReportSites(ReportSite reportSite);


    /**
    * 添加
    * @param reportSite
    */
    @SelectProvider(type = ReportSiteDaoSql.class, method = "insert")
    void insert(ReportSite reportSite);

    /**
    * 更新
    * @param reportSite
    */
    @SelectProvider(type = ReportSiteDaoSql.class, method = "update")
    void update(ReportSite reportSite);

    /**
    * 根据条件删除
    * @param reportSite
    */
    @SelectProvider(type = ReportSiteDaoSql.class, method = "delete")
    void delete(ReportSite reportSite);

    /**
    * 根据主键IDS批量删除(只适合单主键,不支持多主键批量删除,多主键时请删除SQL中多余主键字段)
    * @param ids 主键字符串集合
    */
    @Select("<script>" +
        "DELETE FROM report_site WHERE IN " +
        "<foreach item='item' index='index' collection='ids' open='(' separator=',' close=')'>#{item}</foreach> </script>")
    void deleteAll(@Param("ids") List<String> ids);

}
