package com.guardlbt.dao;

import com.guardlbt.entity.Coupon;
import org.apache.ibatis.jdbc.SQL;
import org.apache.commons.lang3.StringUtils;

/**
* 代金券SQL语句
* Created by 代码自动生成.
* 时间:2021-08-28 13:20:39
*/
public class CouponDaoSql {

    public static String selectCoupons(final Coupon coupon){
        return new SQL(){{
            SELECT("a.coupon_id ,a.name ,a.shop_id ,a.images ,a.price ,a.use_threshold ,a.start_date ,a.stop_date ,a.description ,a.instruction ,a.type ,a.status ,a.create_time ,a.update_time");
            FROM("coupon a");
            if(coupon!=null && StringUtils.isNotBlank(coupon.getCouponId())){
                WHERE("a.Coupon_id like CONCAT('%',#{couponId},'%')");
            }            if(coupon!=null && StringUtils.isNotBlank(coupon.getName())){
                WHERE("a.Name like CONCAT('%',#{name},'%')");
            }            if(coupon!=null && StringUtils.isNotBlank(coupon.getShopId())){
                WHERE("a.Shop_id like CONCAT('%',#{shopId},'%')");
            }            if(coupon!=null && StringUtils.isNotBlank(coupon.getImages())){
                WHERE("a.Images like CONCAT('%',#{images},'%')");
            }
            if(coupon!=null && coupon.getPrice()!=null && coupon.getPrice().toString().length()>0){
                WHERE("a.Price = #{price}");
            }
            if(coupon!=null && coupon.getUseThreshold()!=null && coupon.getUseThreshold().toString().length()>0){
                WHERE("a.Use_threshold = #{useThreshold}");
            }
            if(coupon!=null && coupon.getStartDate()!=null && coupon.getStartDate().toString().length()>0){
                WHERE("a.Start_date = #{startDate}");
            }
            if(coupon!=null && coupon.getStopDate()!=null && coupon.getStopDate().toString().length()>0){
                WHERE("a.Stop_date = #{stopDate}");
            }            if(coupon!=null && StringUtils.isNotBlank(coupon.getDescription())){
                WHERE("a.Description like CONCAT('%',#{description},'%')");
            }            if(coupon!=null && StringUtils.isNotBlank(coupon.getInstruction())){
                WHERE("a.Instruction like CONCAT('%',#{instruction},'%')");
            }
            if(coupon!=null && coupon.getType()!=null && coupon.getType().toString().length()>0){
                WHERE("a.Type = #{type}");
            }
            if(coupon!=null && coupon.getStatus()!=null && coupon.getStatus().toString().length()>0){
                WHERE("a.Status = #{status}");
            }
            if(coupon!=null && coupon.getCreateTime()!=null && coupon.getCreateTime().toString().length()>0){
                WHERE("a.Create_time = #{createTime}");
            }
            if(coupon!=null && coupon.getUpdateTime()!=null && coupon.getUpdateTime().toString().length()>0){
                WHERE("a.Update_time = #{updateTime}");
            }
        }}.toString();
    }

    public static String insert(final Coupon coupon){
        return new SQL(){{
            INSERT_INTO("coupon");
            if(StringUtils.isNotBlank(coupon.getCouponId())){
                VALUES("coupon_id", "#{couponId}");
            }
            if(StringUtils.isNotBlank(coupon.getName())){
                VALUES("name", "#{name}");
            }
            if(StringUtils.isNotBlank(coupon.getShopId())){
                VALUES("shop_id", "#{shopId}");
            }
            if(StringUtils.isNotBlank(coupon.getImages())){
                VALUES("images", "#{images}");
            }

            if(coupon.getPrice()!=null && coupon.getPrice().toString().length()>0){
                VALUES("price", "#{price}");
            }

            if(coupon.getUseThreshold()!=null && coupon.getUseThreshold().toString().length()>0){
                VALUES("use_threshold", "#{useThreshold}");
            }

            if(coupon.getStartDate()!=null && coupon.getStartDate().toString().length()>0){
                VALUES("start_date", "#{startDate}");
            }

            if(coupon.getStopDate()!=null && coupon.getStopDate().toString().length()>0){
                VALUES("stop_date", "#{stopDate}");
            }
            if(StringUtils.isNotBlank(coupon.getDescription())){
                VALUES("description", "#{description}");
            }
            if(StringUtils.isNotBlank(coupon.getInstruction())){
                VALUES("instruction", "#{instruction}");
            }

            if(coupon.getType()!=null && coupon.getType().toString().length()>0){
                VALUES("type", "#{type}");
            }

            if(coupon.getStatus()!=null && coupon.getStatus().toString().length()>0){
                VALUES("status", "#{status}");
            }

            if(coupon.getCreateTime()!=null && coupon.getCreateTime().toString().length()>0){
                VALUES("create_time", "#{createTime}");
            }

            if(coupon.getUpdateTime()!=null && coupon.getUpdateTime().toString().length()>0){
                VALUES("update_time", "#{updateTime}");
            }
    }}.toString();
    }

    public static String update(final Coupon coupon){
        return new SQL(){{
            UPDATE("coupon");
                if(StringUtils.isNotBlank(coupon.getCouponId())){
                SET("coupon_id = #{couponId}");
            }
                if(StringUtils.isNotBlank(coupon.getName())){
                SET("name = #{name}");
            }
                if(StringUtils.isNotBlank(coupon.getShopId())){
                SET("shop_id = #{shopId}");
            }
                if(StringUtils.isNotBlank(coupon.getImages())){
                SET("images = #{images}");
            }

                if(coupon.getPrice()!=null && coupon.getPrice().toString().length()>0){
                SET("price = #{price}");
            }

                if(coupon.getUseThreshold()!=null && coupon.getUseThreshold().toString().length()>0){
                SET("use_threshold = #{useThreshold}");
            }

                if(coupon.getStartDate()!=null && coupon.getStartDate().toString().length()>0){
                SET("start_date = #{startDate}");
            }

                if(coupon.getStopDate()!=null && coupon.getStopDate().toString().length()>0){
                SET("stop_date = #{stopDate}");
            }
                if(StringUtils.isNotBlank(coupon.getDescription())){
                SET("description = #{description}");
            }
                if(StringUtils.isNotBlank(coupon.getInstruction())){
                SET("instruction = #{instruction}");
            }

                if(coupon.getType()!=null && coupon.getType().toString().length()>0){
                SET("type = #{type}");
            }

                if(coupon.getStatus()!=null && coupon.getStatus().toString().length()>0){
                SET("status = #{status}");
            }

                if(coupon.getCreateTime()!=null && coupon.getCreateTime().toString().length()>0){
                SET("create_time = #{createTime}");
            }

                if(coupon.getUpdateTime()!=null && coupon.getUpdateTime().toString().length()>0){
                SET("update_time = #{updateTime}");
            }
                if(StringUtils.isNotBlank(coupon.getCouponId())){
                WHERE("coupon_id = #{couponId}");
            }
        }}.toString();
    }

    public static String delete(final Coupon coupon){
        return new SQL(){{
            DELETE_FROM("coupon");
                if(StringUtils.isNotBlank(coupon.getCouponId())){
                WHERE("coupon_id = #{couponId}");
            }
                if(StringUtils.isNotBlank(coupon.getName())){
                WHERE("name = #{name}");
            }
                if(StringUtils.isNotBlank(coupon.getShopId())){
                WHERE("shop_id = #{shopId}");
            }
                if(StringUtils.isNotBlank(coupon.getImages())){
                WHERE("images = #{images}");
            }

                if(coupon.getPrice()!=null && coupon.getPrice().toString().length()>0){
                WHERE("price = #{price}");
            }

                if(coupon.getUseThreshold()!=null && coupon.getUseThreshold().toString().length()>0){
                WHERE("use_threshold = #{useThreshold}");
            }

                if(coupon.getStartDate()!=null && coupon.getStartDate().toString().length()>0){
                WHERE("start_date = #{startDate}");
            }

                if(coupon.getStopDate()!=null && coupon.getStopDate().toString().length()>0){
                WHERE("stop_date = #{stopDate}");
            }
                if(StringUtils.isNotBlank(coupon.getDescription())){
                WHERE("description = #{description}");
            }
                if(StringUtils.isNotBlank(coupon.getInstruction())){
                WHERE("instruction = #{instruction}");
            }

                if(coupon.getType()!=null && coupon.getType().toString().length()>0){
                WHERE("type = #{type}");
            }

                if(coupon.getStatus()!=null && coupon.getStatus().toString().length()>0){
                WHERE("status = #{status}");
            }

                if(coupon.getCreateTime()!=null && coupon.getCreateTime().toString().length()>0){
                WHERE("create_time = #{createTime}");
            }

                if(coupon.getUpdateTime()!=null && coupon.getUpdateTime().toString().length()>0){
                WHERE("update_time = #{updateTime}");
            }
        }}.toString();
    }
}
