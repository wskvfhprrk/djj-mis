package com.guardlbt.dao;

import com.guardlbt.entity.Goods;
import org.apache.ibatis.annotations.*;

import java.util.*;

/**
* 商品dao方法
* Created by 代码自动生成.
* 时间:2021-08-27 13:42:55
*/
@Mapper
public interface GoodsDao {

    /**
    * 条件查询全部数据
    * @param goods
    * @return List<Map>类型的集合
    */
    @Results(value = {
        @Result(column = "goods_id", property = "goodsId", id=true),
        @Result(column = "name", property = "name"),
        @Result(column = "shop_id", property = "shopId"),
        @Result(column = "images", property = "images"),
        @Result(column = "create_time", property = "createTime"),
        @Result(column = "update_time", property = "updateTime"),
    })
    @SelectProvider(type = GoodsDaoSql.class, method = "selectGoodss")
    List<Goods> selectGoodss(Goods goods);


    /**
    * 添加
    * @param goods
    */
    @SelectProvider(type = GoodsDaoSql.class, method = "insert")
    void insert(Goods goods);

    /**
    * 更新
    * @param goods
    */
    @SelectProvider(type = GoodsDaoSql.class, method = "update")
    void update(Goods goods);

    /**
    * 根据条件删除
    * @param goods
    */
    @SelectProvider(type = GoodsDaoSql.class, method = "delete")
    void delete(Goods goods);

    /**
    * 根据主键IDS批量删除(只适合单主键,不支持多主键批量删除,多主键时请删除SQL中多余主键字段)
    * @param ids 主键字符串集合
    */
    @Select("<script>" +
        "DELETE FROM goods WHERE goods_id IN " +
        "<foreach item='item' index='index' collection='ids' open='(' separator=',' close=')'>#{item}</foreach> </script>")
    void deleteAll(@Param("ids") List<String> ids);

}
