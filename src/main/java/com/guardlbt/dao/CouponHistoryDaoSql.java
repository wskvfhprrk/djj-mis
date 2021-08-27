package com.guardlbt.dao;

import com.guardlbt.entity.CouponHistory;
import org.apache.ibatis.jdbc.SQL;
import org.apache.commons.lang3.StringUtils;

/**
* 代金券历史SQL语句
* Created by 代码自动生成.
* 时间:2021-08-26 16:20:26
*/
public class CouponHistoryDaoSql {

    public static String selectCouponHistorys(final CouponHistory couponHistory){
        return new SQL(){{
            SELECT("a.id ,a.coupon_no ,a.from_name ,a.to_name ,a.create_time ,a.remark");
            FROM("coupon_history a");

            if(couponHistory!=null && couponHistory.getId()!=null && couponHistory.getId().toString().length()>0){
                WHERE("a.Id = #{id}");
            }            if(couponHistory!=null && StringUtils.isNotBlank(couponHistory.getCouponNo())){
                WHERE("a.Coupon_no like CONCAT('%',#{couponNo},'%')");
            }            if(couponHistory!=null && StringUtils.isNotBlank(couponHistory.getFromName())){
                WHERE("a.From_name like CONCAT('%',#{fromName},'%')");
            }            if(couponHistory!=null && StringUtils.isNotBlank(couponHistory.getToName())){
                WHERE("a.To_name like CONCAT('%',#{toName},'%')");
            }
            if(couponHistory!=null && couponHistory.getCreateTime()!=null && couponHistory.getCreateTime().toString().length()>0){
                WHERE("a.Create_time = #{createTime}");
            }            if(couponHistory!=null && StringUtils.isNotBlank(couponHistory.getRemark())){
                WHERE("a.Remark like CONCAT('%',#{remark},'%')");
            }
        }}.toString();
    }

    public static String insert(final CouponHistory couponHistory){
        return new SQL(){{
            INSERT_INTO("coupon_history");

            if(couponHistory.getId()!=null && couponHistory.getId().toString().length()>0){
                VALUES("id", "#{id}");
            }
            if(StringUtils.isNotBlank(couponHistory.getCouponNo())){
                VALUES("coupon_no", "#{couponNo}");
            }
            if(StringUtils.isNotBlank(couponHistory.getFromName())){
                VALUES("from_name", "#{fromName}");
            }
            if(StringUtils.isNotBlank(couponHistory.getToName())){
                VALUES("to_name", "#{toName}");
            }

            if(couponHistory.getCreateTime()!=null && couponHistory.getCreateTime().toString().length()>0){
                VALUES("create_time", "#{createTime}");
            }
            if(StringUtils.isNotBlank(couponHistory.getRemark())){
                VALUES("remark", "#{remark}");
            }
    }}.toString();
    }

    public static String update(final CouponHistory couponHistory){
        return new SQL(){{
            UPDATE("coupon_history");

                if(couponHistory.getId()!=null && couponHistory.getId().toString().length()>0){
                SET("id = #{id}");
            }
                if(StringUtils.isNotBlank(couponHistory.getCouponNo())){
                SET("coupon_no = #{couponNo}");
            }
                if(StringUtils.isNotBlank(couponHistory.getFromName())){
                SET("from_name = #{fromName}");
            }
                if(StringUtils.isNotBlank(couponHistory.getToName())){
                SET("to_name = #{toName}");
            }

                if(couponHistory.getCreateTime()!=null && couponHistory.getCreateTime().toString().length()>0){
                SET("create_time = #{createTime}");
            }
                if(StringUtils.isNotBlank(couponHistory.getRemark())){
                SET("remark = #{remark}");
            }

                if(couponHistory.getId()!=null && couponHistory.getId().toString().length()>0){
                WHERE("id = #{id}");
            }
        }}.toString();
    }

    public static String delete(final CouponHistory couponHistory){
        return new SQL(){{
            DELETE_FROM("coupon_history");

                if(couponHistory.getId()!=null && couponHistory.getId().toString().length()>0){
                WHERE("id = #{id}");
            }
                if(StringUtils.isNotBlank(couponHistory.getCouponNo())){
                WHERE("coupon_no = #{couponNo}");
            }
                if(StringUtils.isNotBlank(couponHistory.getFromName())){
                WHERE("from_name = #{fromName}");
            }
                if(StringUtils.isNotBlank(couponHistory.getToName())){
                WHERE("to_name = #{toName}");
            }

                if(couponHistory.getCreateTime()!=null && couponHistory.getCreateTime().toString().length()>0){
                WHERE("create_time = #{createTime}");
            }
                if(StringUtils.isNotBlank(couponHistory.getRemark())){
                WHERE("remark = #{remark}");
            }
        }}.toString();
    }
}
