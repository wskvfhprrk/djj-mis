package com.guardlbt.dao;

import com.guardlbt.entity.BusinessDistrict;
import org.apache.ibatis.annotations.*;

import java.util.*;

/**
* 商圈dao方法
* Created by 代码自动生成.
* 时间:2021-08-28 11:42:13
*/
@Mapper
public interface BusinessDistrictDao {

    /**
    * 条件查询全部数据
    * @param businessDistrict
    * @return List<Map>类型的集合
    */
    @Results(value = {
        @Result(column = "business_district_id", property = "businessDistrictId", id=true),
        @Result(column = "name", property = "name"),
        @Result(column = "images", property = "images"),
        @Result(column = "province", property = "province"),
        @Result(column = "city", property = "city"),
        @Result(column = "county", property = "county"),
        @Result(column = "area", property = "area"),
        @Result(column = "address", property = "address"),
        @Result(column = "longitude", property = "longitude"),
        @Result(column = "latitude", property = "latitude"),
        @Result(column = "details", property = "details"),
    })
    @SelectProvider(type = BusinessDistrictDaoSql.class, method = "selectBusinessDistricts")
    List<BusinessDistrict> selectBusinessDistricts(BusinessDistrict businessDistrict);


    /**
    * 添加
    * @param businessDistrict
    */
    @SelectProvider(type = BusinessDistrictDaoSql.class, method = "insert")
    void insert(BusinessDistrict businessDistrict);

    /**
    * 更新
    * @param businessDistrict
    */
    @SelectProvider(type = BusinessDistrictDaoSql.class, method = "update")
    void update(BusinessDistrict businessDistrict);

    /**
    * 根据条件删除
    * @param businessDistrict
    */
    @SelectProvider(type = BusinessDistrictDaoSql.class, method = "delete")
    void delete(BusinessDistrict businessDistrict);

    /**
    * 根据主键IDS批量删除(只适合单主键,不支持多主键批量删除,多主键时请删除SQL中多余主键字段)
    * @param ids 主键字符串集合
    */
    @Select("<script>" +
        "DELETE FROM business_district WHERE business_district_id IN " +
        "<foreach item='item' index='index' collection='ids' open='(' separator=',' close=')'>#{item}</foreach> </script>")
    void deleteAll(@Param("ids") List<String> ids);

}
