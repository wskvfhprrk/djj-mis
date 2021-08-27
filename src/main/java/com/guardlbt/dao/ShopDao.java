package com.guardlbt.dao;

import com.guardlbt.entity.Shop;
import org.apache.ibatis.annotations.*;

import java.util.*;

/**
* 商店dao方法
* Created by 代码自动生成.
* 时间:2021-08-26 16:20:26
*/
@Mapper
public interface ShopDao {

    /**
    * 条件查询全部数据
    * @param shop
    * @return List<Map>类型的集合
    */
    @Results(value = {
        @Result(column = "shop_id", property = "shopId", id=true),
        @Result(column = "name", property = "name"),
        @Result(column = "logo_image", property = "logoImage"),
        @Result(column = "images", property = "images"),
        @Result(column = "business_district_id", property = "businessDistrictId"),
        @Result(column = "province", property = "province"),
        @Result(column = "city", property = "city"),
        @Result(column = "county", property = "county"),
        @Result(column = "area", property = "area"),
        @Result(column = "address", property = "address"),
        @Result(column = "longitude", property = "longitude"),
        @Result(column = "latitude", property = "latitude"),
        @Result(column = "phone", property = "phone"),
        @Result(column = "custodian", property = "custodian"),
        @Result(column = "profession", property = "profession"),
        @Result(column = "details", property = "details"),
        @Result(column = "create_time", property = "createTime"),
        @Result(column = "status", property = "status"),
        @Result(column = "start_time", property = "startTime"),
        @Result(column = "stop_time", property = "stopTime"),
    })
    @SelectProvider(type = ShopDaoSql.class, method = "selectShops")
    List<Shop> selectShops(Shop shop);


    /**
    * 添加
    * @param shop
    */
    @SelectProvider(type = ShopDaoSql.class, method = "insert")
    void insert(Shop shop);

    /**
    * 更新
    * @param shop
    */
    @SelectProvider(type = ShopDaoSql.class, method = "update")
    void update(Shop shop);

    /**
    * 根据条件删除
    * @param shop
    */
    @SelectProvider(type = ShopDaoSql.class, method = "delete")
    void delete(Shop shop);

    /**
    * 根据主键IDS批量删除(只适合单主键,不支持多主键批量删除,多主键时请删除SQL中多余主键字段)
    * @param ids 主键字符串集合
    */
    @Select("<script>" +
        "DELETE FROM shop WHERE shop_id IN " +
        "<foreach item='item' index='index' collection='ids' open='(' separator=',' close=')'>#{item}</foreach> </script>")
    void deleteAll(@Param("ids") List<String> ids);

}
