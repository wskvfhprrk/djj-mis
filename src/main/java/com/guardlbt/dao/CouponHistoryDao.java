package com.guardlbt.dao;

import com.guardlbt.entity.CouponHistory;
import org.apache.ibatis.annotations.*;

import java.util.*;

/**
* 代金券历史dao方法
* Created by 代码自动生成.
* 时间:2021-08-27 13:42:55
*/
@Mapper
public interface CouponHistoryDao {

    /**
    * 条件查询全部数据
    * @param couponHistory
    * @return List<Map>类型的集合
    */
    @Results(value = {
        @Result(column = "id", property = "id", id=true),
        @Result(column = "coupon_no", property = "couponNo"),
        @Result(column = "from_name", property = "fromName"),
        @Result(column = "to_name", property = "toName"),
        @Result(column = "create_time", property = "createTime"),
        @Result(column = "remark", property = "remark"),
    })
    @SelectProvider(type = CouponHistoryDaoSql.class, method = "selectCouponHistorys")
    List<CouponHistory> selectCouponHistorys(CouponHistory couponHistory);


    /**
    * 添加
    * @param couponHistory
    */
    @SelectProvider(type = CouponHistoryDaoSql.class, method = "insert")
    void insert(CouponHistory couponHistory);

    /**
    * 更新
    * @param couponHistory
    */
    @SelectProvider(type = CouponHistoryDaoSql.class, method = "update")
    void update(CouponHistory couponHistory);

    /**
    * 根据条件删除
    * @param couponHistory
    */
    @SelectProvider(type = CouponHistoryDaoSql.class, method = "delete")
    void delete(CouponHistory couponHistory);

    /**
    * 根据主键IDS批量删除(只适合单主键,不支持多主键批量删除,多主键时请删除SQL中多余主键字段)
    * @param ids 主键字符串集合
    */
    @Select("<script>" +
        "DELETE FROM coupon_history WHERE id IN " +
        "<foreach item='item' index='index' collection='ids' open='(' separator=',' close=')'>#{item}</foreach> </script>")
    void deleteAll(@Param("ids") List<String> ids);

}
