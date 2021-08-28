package com.guardlbt.dao;

import com.guardlbt.entity.CouponStock;
import org.apache.ibatis.jdbc.SQL;
import org.apache.commons.lang3.StringUtils;

/**
* 代金券明细SQL语句
* Created by 代码自动生成.
* 时间:2021-08-28 11:42:14
*/
public class CouponStockDaoSql {

    public static String selectCouponStocks(final CouponStock couponStock){
        return new SQL(){{
            SELECT("a.coupon_no ,a.coupon_id ,a.shop_id ,a.status ,a.member_id ,a.create_time ,a.update_time");
            FROM("coupon_stock a");
            if(couponStock!=null && StringUtils.isNotBlank(couponStock.getCouponNo())){
                WHERE("a.Coupon_no like CONCAT('%',#{couponNo},'%')");
            }            if(couponStock!=null && StringUtils.isNotBlank(couponStock.getCouponId())){
                WHERE("a.Coupon_id like CONCAT('%',#{couponId},'%')");
            }            if(couponStock!=null && StringUtils.isNotBlank(couponStock.getShopId())){
                WHERE("a.Shop_id like CONCAT('%',#{shopId},'%')");
            }
            if(couponStock!=null && couponStock.getStatus()!=null && couponStock.getStatus().toString().length()>0){
                WHERE("a.Status = #{status}");
            }            if(couponStock!=null && StringUtils.isNotBlank(couponStock.getMemberId())){
                WHERE("a.Member_id like CONCAT('%',#{memberId},'%')");
            }
            if(couponStock!=null && couponStock.getCreateTime()!=null && couponStock.getCreateTime().toString().length()>0){
                WHERE("a.Create_time = #{createTime}");
            }
            if(couponStock!=null && couponStock.getUpdateTime()!=null && couponStock.getUpdateTime().toString().length()>0){
                WHERE("a.Update_time = #{updateTime}");
            }
        }}.toString();
    }

    public static String insert(final CouponStock couponStock){
        return new SQL(){{
            INSERT_INTO("coupon_stock");
            if(StringUtils.isNotBlank(couponStock.getCouponNo())){
                VALUES("coupon_no", "#{couponNo}");
            }
            if(StringUtils.isNotBlank(couponStock.getCouponId())){
                VALUES("coupon_id", "#{couponId}");
            }
            if(StringUtils.isNotBlank(couponStock.getShopId())){
                VALUES("shop_id", "#{shopId}");
            }

            if(couponStock.getStatus()!=null && couponStock.getStatus().toString().length()>0){
                VALUES("status", "#{status}");
            }
            if(StringUtils.isNotBlank(couponStock.getMemberId())){
                VALUES("member_id", "#{memberId}");
            }

            if(couponStock.getCreateTime()!=null && couponStock.getCreateTime().toString().length()>0){
                VALUES("create_time", "#{createTime}");
            }

            if(couponStock.getUpdateTime()!=null && couponStock.getUpdateTime().toString().length()>0){
                VALUES("update_time", "#{updateTime}");
            }
    }}.toString();
    }

    public static String update(final CouponStock couponStock){
        return new SQL(){{
            UPDATE("coupon_stock");
                if(StringUtils.isNotBlank(couponStock.getCouponNo())){
                SET("coupon_no = #{couponNo}");
            }
                if(StringUtils.isNotBlank(couponStock.getCouponId())){
                SET("coupon_id = #{couponId}");
            }
                if(StringUtils.isNotBlank(couponStock.getShopId())){
                SET("shop_id = #{shopId}");
            }

                if(couponStock.getStatus()!=null && couponStock.getStatus().toString().length()>0){
                SET("status = #{status}");
            }
                if(StringUtils.isNotBlank(couponStock.getMemberId())){
                SET("member_id = #{memberId}");
            }

                if(couponStock.getCreateTime()!=null && couponStock.getCreateTime().toString().length()>0){
                SET("create_time = #{createTime}");
            }

                if(couponStock.getUpdateTime()!=null && couponStock.getUpdateTime().toString().length()>0){
                SET("update_time = #{updateTime}");
            }
                if(StringUtils.isNotBlank(couponStock.getCouponNo())){
                WHERE("coupon_no = #{couponNo}");
            }
        }}.toString();
    }

    public static String delete(final CouponStock couponStock){
        return new SQL(){{
            DELETE_FROM("coupon_stock");
                if(StringUtils.isNotBlank(couponStock.getCouponNo())){
                WHERE("coupon_no = #{couponNo}");
            }
                if(StringUtils.isNotBlank(couponStock.getCouponId())){
                WHERE("coupon_id = #{couponId}");
            }
                if(StringUtils.isNotBlank(couponStock.getShopId())){
                WHERE("shop_id = #{shopId}");
            }

                if(couponStock.getStatus()!=null && couponStock.getStatus().toString().length()>0){
                WHERE("status = #{status}");
            }
                if(StringUtils.isNotBlank(couponStock.getMemberId())){
                WHERE("member_id = #{memberId}");
            }

                if(couponStock.getCreateTime()!=null && couponStock.getCreateTime().toString().length()>0){
                WHERE("create_time = #{createTime}");
            }

                if(couponStock.getUpdateTime()!=null && couponStock.getUpdateTime().toString().length()>0){
                WHERE("update_time = #{updateTime}");
            }
        }}.toString();
    }
}
