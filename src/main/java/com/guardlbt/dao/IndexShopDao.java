package com.guardlbt.dao;

import com.guardlbt.entity.IndexShop;
import org.apache.ibatis.annotations.*;

import java.util.*;

/**
* 首页促销店铺dao方法
* Created by 代码自动生成.
* 时间:2021-08-25 18:06:24
*/
@Mapper
public interface IndexShopDao {

    /**
    * 条件查询全部数据
    * @param indexShop
    * @return List<Map>类型的集合
    */
    @Results(value = {
        @Result(column = "sorting", property = "sorting", id=true),
        @Result(column = "shop_id", property = "shopId"),
    })
    @SelectProvider(type = IndexShopDaoSql.class, method = "selectIndexShops")
    List<IndexShop> selectIndexShops(IndexShop indexShop);


    /**
    * 添加
    * @param indexShop
    */
    @SelectProvider(type = IndexShopDaoSql.class, method = "insert")
    void insert(IndexShop indexShop);

    /**
    * 更新
    * @param indexShop
    */
    @SelectProvider(type = IndexShopDaoSql.class, method = "update")
    void update(IndexShop indexShop);

    /**
    * 根据条件删除
    * @param indexShop
    */
    @SelectProvider(type = IndexShopDaoSql.class, method = "delete")
    void delete(IndexShop indexShop);

    /**
    * 根据主键IDS批量删除(只适合单主键,不支持多主键批量删除,多主键时请删除SQL中多余主键字段)
    * @param ids 主键字符串集合
    */
    @Select("<script>" +
        "DELETE FROM index_shop WHERE sorting IN " +
        "<foreach item='item' index='index' collection='ids' open='(' separator=',' close=')'>#{item}</foreach> </script>")
    void deleteAll(@Param("ids") List<String> ids);

}
