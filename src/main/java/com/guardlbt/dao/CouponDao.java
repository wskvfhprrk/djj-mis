package com.guardlbt.dao;

import com.guardlbt.entity.Coupon;
import org.apache.ibatis.annotations.*;

import java.util.*;

/**
* 代金券dao方法
* Created by 代码自动生成.
* 时间:2021-08-28 13:20:39
*/
@Mapper
public interface CouponDao {

    /**
    * 条件查询全部数据
    * @param coupon
    * @return List<Map>类型的集合
    */
    @Results(value = {
        @Result(column = "coupon_id", property = "couponId", id=true),
        @Result(column = "name", property = "name"),
        @Result(column = "shop_id", property = "shopId"),
        @Result(column = "images", property = "images"),
        @Result(column = "price", property = "price"),
        @Result(column = "use_threshold", property = "useThreshold"),
        @Result(column = "start_date", property = "startDate"),
        @Result(column = "stop_date", property = "stopDate"),
        @Result(column = "description", property = "description"),
        @Result(column = "instruction", property = "instruction"),
        @Result(column = "type", property = "type"),
        @Result(column = "status", property = "status"),
        @Result(column = "create_time", property = "createTime"),
        @Result(column = "update_time", property = "updateTime"),
    })
    @SelectProvider(type = CouponDaoSql.class, method = "selectCoupons")
    List<Coupon> selectCoupons(Coupon coupon);


    /**
    * 添加
    * @param coupon
    */
    @SelectProvider(type = CouponDaoSql.class, method = "insert")
    void insert(Coupon coupon);

    /**
    * 更新
    * @param coupon
    */
    @SelectProvider(type = CouponDaoSql.class, method = "update")
    void update(Coupon coupon);

    /**
    * 根据条件删除
    * @param coupon
    */
    @SelectProvider(type = CouponDaoSql.class, method = "delete")
    void delete(Coupon coupon);

    /**
    * 根据主键IDS批量删除(只适合单主键,不支持多主键批量删除,多主键时请删除SQL中多余主键字段)
    * @param ids 主键字符串集合
    */
    @Select("<script>" +
        "DELETE FROM coupon WHERE coupon_id IN " +
        "<foreach item='item' index='index' collection='ids' open='(' separator=',' close=')'>#{item}</foreach> </script>")
    void deleteAll(@Param("ids") List<String> ids);

}
