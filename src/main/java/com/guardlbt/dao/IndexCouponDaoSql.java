package com.guardlbt.dao;

import com.guardlbt.entity.IndexCoupon;
import org.apache.ibatis.jdbc.SQL;
import org.apache.commons.lang3.StringUtils;

/**
* 首页促销代金券SQL语句
* Created by 代码自动生成.
* 时间:2021-08-28 11:42:15
*/
public class IndexCouponDaoSql {

    public static String selectIndexCoupons(final IndexCoupon indexCoupon){
        return new SQL(){{
            SELECT("a.sorting ,a.coupon_id");
            FROM("index_coupon a");

            if(indexCoupon!=null && indexCoupon.getSorting()!=null && indexCoupon.getSorting().toString().length()>0){
                WHERE("a.Sorting = #{sorting}");
            }            if(indexCoupon!=null && StringUtils.isNotBlank(indexCoupon.getCouponId())){
                WHERE("a.Coupon_id like CONCAT('%',#{couponId},'%')");
            }
        }}.toString();
    }

    public static String insert(final IndexCoupon indexCoupon){
        return new SQL(){{
            INSERT_INTO("index_coupon");

            if(indexCoupon.getSorting()!=null && indexCoupon.getSorting().toString().length()>0){
                VALUES("sorting", "#{sorting}");
            }
            if(StringUtils.isNotBlank(indexCoupon.getCouponId())){
                VALUES("coupon_id", "#{couponId}");
            }
    }}.toString();
    }

    public static String update(final IndexCoupon indexCoupon){
        return new SQL(){{
            UPDATE("index_coupon");

                if(indexCoupon.getSorting()!=null && indexCoupon.getSorting().toString().length()>0){
                SET("sorting = #{sorting}");
            }
                if(StringUtils.isNotBlank(indexCoupon.getCouponId())){
                SET("coupon_id = #{couponId}");
            }

                if(indexCoupon.getSorting()!=null && indexCoupon.getSorting().toString().length()>0){
                WHERE("sorting = #{sorting}");
            }
        }}.toString();
    }

    public static String delete(final IndexCoupon indexCoupon){
        return new SQL(){{
            DELETE_FROM("index_coupon");

                if(indexCoupon.getSorting()!=null && indexCoupon.getSorting().toString().length()>0){
                WHERE("sorting = #{sorting}");
            }
                if(StringUtils.isNotBlank(indexCoupon.getCouponId())){
                WHERE("coupon_id = #{couponId}");
            }
        }}.toString();
    }
}
