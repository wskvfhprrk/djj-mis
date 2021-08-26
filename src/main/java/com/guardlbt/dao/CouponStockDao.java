package com.guardlbt.dao;

import com.guardlbt.entity.CouponStock;
import org.apache.ibatis.annotations.*;

import java.util.*;

/**
* 代金券明细dao方法
* Created by 代码自动生成.
* 时间:2021-08-25 18:06:23
*/
@Mapper
public interface CouponStockDao {

    /**
    * 条件查询全部数据
    * @param couponStock
    * @return List<Map>类型的集合
    */
    @Results(value = {
        @Result(column = "coupon_no", property = "couponNo", id=true),
        @Result(column = "coupon_id", property = "couponId"),
        @Result(column = "shop_id", property = "shopId"),
        @Result(column = "status", property = "status"),
        @Result(column = "member_id", property = "memberId"),
        @Result(column = "create_time", property = "createTime"),
        @Result(column = "update_time", property = "updateTime"),
    })
    @SelectProvider(type = CouponStockDaoSql.class, method = "selectCouponStocks")
    List<CouponStock> selectCouponStocks(CouponStock couponStock);


    /**
    * 添加
    * @param couponStock
    */
    @SelectProvider(type = CouponStockDaoSql.class, method = "insert")
    void insert(CouponStock couponStock);

    /**
    * 更新
    * @param couponStock
    */
    @SelectProvider(type = CouponStockDaoSql.class, method = "update")
    void update(CouponStock couponStock);

    /**
    * 根据条件删除
    * @param couponStock
    */
    @SelectProvider(type = CouponStockDaoSql.class, method = "delete")
    void delete(CouponStock couponStock);

    /**
    * 根据主键IDS批量删除(只适合单主键,不支持多主键批量删除,多主键时请删除SQL中多余主键字段)
    * @param ids 主键字符串集合
    */
    @Select("<script>" +
        "DELETE FROM coupon_stock WHERE coupon_no IN " +
        "<foreach item='item' index='index' collection='ids' open='(' separator=',' close=')'>#{item}</foreach> </script>")
    void deleteAll(@Param("ids") List<String> ids);

}
