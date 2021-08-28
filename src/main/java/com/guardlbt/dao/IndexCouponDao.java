package com.guardlbt.dao;

import com.guardlbt.entity.IndexCoupon;
import org.apache.ibatis.annotations.*;

import java.util.*;

/**
* 首页促销代金券dao方法
* Created by 代码自动生成.
* 时间:2021-08-28 11:42:15
*/
@Mapper
public interface IndexCouponDao {

    /**
    * 条件查询全部数据
    * @param indexCoupon
    * @return List<Map>类型的集合
    */
    @Results(value = {
        @Result(column = "sorting", property = "sorting", id=true),
        @Result(column = "coupon_id", property = "couponId"),
    })
    @SelectProvider(type = IndexCouponDaoSql.class, method = "selectIndexCoupons")
    List<IndexCoupon> selectIndexCoupons(IndexCoupon indexCoupon);


    /**
    * 添加
    * @param indexCoupon
    */
    @SelectProvider(type = IndexCouponDaoSql.class, method = "insert")
    void insert(IndexCoupon indexCoupon);

    /**
    * 更新
    * @param indexCoupon
    */
    @SelectProvider(type = IndexCouponDaoSql.class, method = "update")
    void update(IndexCoupon indexCoupon);

    /**
    * 根据条件删除
    * @param indexCoupon
    */
    @SelectProvider(type = IndexCouponDaoSql.class, method = "delete")
    void delete(IndexCoupon indexCoupon);

    /**
    * 根据主键IDS批量删除(只适合单主键,不支持多主键批量删除,多主键时请删除SQL中多余主键字段)
    * @param ids 主键字符串集合
    */
    @Select("<script>" +
        "DELETE FROM index_coupon WHERE sorting IN " +
        "<foreach item='item' index='index' collection='ids' open='(' separator=',' close=')'>#{item}</foreach> </script>")
    void deleteAll(@Param("ids") List<String> ids);

}
