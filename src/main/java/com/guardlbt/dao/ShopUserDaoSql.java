package com.guardlbt.dao;

import com.guardlbt.entity.ShopUser;
import org.apache.ibatis.jdbc.SQL;
import org.apache.commons.lang3.StringUtils;

/**
* 商店管理员SQL语句
* Created by 代码自动生成.
* 时间:2021-08-28 13:20:38
*/
public class ShopUserDaoSql {

    public static String selectShopUsers(final ShopUser shopUser){
        return new SQL(){{
            SELECT("a.user_id ,a.name ,a.sex ,a.birthday ,a.phone ,a.role ,a.shop_id ,a.create_time ,a.update_time ,a.status ,a.open_id");
            FROM("shop_user a");
            if(shopUser!=null && StringUtils.isNotBlank(shopUser.getUserId())){
                WHERE("a.User_id like CONCAT('%',#{userId},'%')");
            }            if(shopUser!=null && StringUtils.isNotBlank(shopUser.getName())){
                WHERE("a.Name like CONCAT('%',#{name},'%')");
            }
            if(shopUser!=null && shopUser.getSex()!=null && shopUser.getSex().toString().length()>0){
                WHERE("a.Sex = #{sex}");
            }
            if(shopUser!=null && shopUser.getBirthday()!=null && shopUser.getBirthday().toString().length()>0){
                WHERE("a.Birthday = #{birthday}");
            }            if(shopUser!=null && StringUtils.isNotBlank(shopUser.getPhone())){
                WHERE("a.Phone like CONCAT('%',#{phone},'%')");
            }
            if(shopUser!=null && shopUser.getRole()!=null && shopUser.getRole().toString().length()>0){
                WHERE("a.Role = #{role}");
            }            if(shopUser!=null && StringUtils.isNotBlank(shopUser.getShopId())){
                WHERE("a.Shop_id like CONCAT('%',#{shopId},'%')");
            }
            if(shopUser!=null && shopUser.getCreateTime()!=null && shopUser.getCreateTime().toString().length()>0){
                WHERE("a.Create_time = #{createTime}");
            }
            if(shopUser!=null && shopUser.getUpdateTime()!=null && shopUser.getUpdateTime().toString().length()>0){
                WHERE("a.Update_time = #{updateTime}");
            }
            if(shopUser!=null && shopUser.getStatus()!=null && shopUser.getStatus().toString().length()>0){
                WHERE("a.Status = #{status}");
            }            if(shopUser!=null && StringUtils.isNotBlank(shopUser.getOpenId())){
                WHERE("a.Open_id like CONCAT('%',#{openId},'%')");
            }
        }}.toString();
    }

    public static String insert(final ShopUser shopUser){
        return new SQL(){{
            INSERT_INTO("shop_user");
            if(StringUtils.isNotBlank(shopUser.getUserId())){
                VALUES("user_id", "#{userId}");
            }
            if(StringUtils.isNotBlank(shopUser.getName())){
                VALUES("name", "#{name}");
            }

            if(shopUser.getSex()!=null && shopUser.getSex().toString().length()>0){
                VALUES("sex", "#{sex}");
            }

            if(shopUser.getBirthday()!=null && shopUser.getBirthday().toString().length()>0){
                VALUES("birthday", "#{birthday}");
            }
            if(StringUtils.isNotBlank(shopUser.getPhone())){
                VALUES("phone", "#{phone}");
            }

            if(shopUser.getRole()!=null && shopUser.getRole().toString().length()>0){
                VALUES("role", "#{role}");
            }
            if(StringUtils.isNotBlank(shopUser.getShopId())){
                VALUES("shop_id", "#{shopId}");
            }

            if(shopUser.getCreateTime()!=null && shopUser.getCreateTime().toString().length()>0){
                VALUES("create_time", "#{createTime}");
            }

            if(shopUser.getUpdateTime()!=null && shopUser.getUpdateTime().toString().length()>0){
                VALUES("update_time", "#{updateTime}");
            }

            if(shopUser.getStatus()!=null && shopUser.getStatus().toString().length()>0){
                VALUES("status", "#{status}");
            }
            if(StringUtils.isNotBlank(shopUser.getOpenId())){
                VALUES("open_id", "#{openId}");
            }
    }}.toString();
    }

    public static String update(final ShopUser shopUser){
        return new SQL(){{
            UPDATE("shop_user");
                if(StringUtils.isNotBlank(shopUser.getUserId())){
                SET("user_id = #{userId}");
            }
                if(StringUtils.isNotBlank(shopUser.getName())){
                SET("name = #{name}");
            }

                if(shopUser.getSex()!=null && shopUser.getSex().toString().length()>0){
                SET("sex = #{sex}");
            }

                if(shopUser.getBirthday()!=null && shopUser.getBirthday().toString().length()>0){
                SET("birthday = #{birthday}");
            }
                if(StringUtils.isNotBlank(shopUser.getPhone())){
                SET("phone = #{phone}");
            }

                if(shopUser.getRole()!=null && shopUser.getRole().toString().length()>0){
                SET("role = #{role}");
            }
                if(StringUtils.isNotBlank(shopUser.getShopId())){
                SET("shop_id = #{shopId}");
            }

                if(shopUser.getCreateTime()!=null && shopUser.getCreateTime().toString().length()>0){
                SET("create_time = #{createTime}");
            }

                if(shopUser.getUpdateTime()!=null && shopUser.getUpdateTime().toString().length()>0){
                SET("update_time = #{updateTime}");
            }

                if(shopUser.getStatus()!=null && shopUser.getStatus().toString().length()>0){
                SET("status = #{status}");
            }
                if(StringUtils.isNotBlank(shopUser.getOpenId())){
                SET("open_id = #{openId}");
            }
                if(StringUtils.isNotBlank(shopUser.getUserId())){
                WHERE("user_id = #{userId}");
            }
        }}.toString();
    }

    public static String delete(final ShopUser shopUser){
        return new SQL(){{
            DELETE_FROM("shop_user");
                if(StringUtils.isNotBlank(shopUser.getUserId())){
                WHERE("user_id = #{userId}");
            }
                if(StringUtils.isNotBlank(shopUser.getName())){
                WHERE("name = #{name}");
            }

                if(shopUser.getSex()!=null && shopUser.getSex().toString().length()>0){
                WHERE("sex = #{sex}");
            }

                if(shopUser.getBirthday()!=null && shopUser.getBirthday().toString().length()>0){
                WHERE("birthday = #{birthday}");
            }
                if(StringUtils.isNotBlank(shopUser.getPhone())){
                WHERE("phone = #{phone}");
            }

                if(shopUser.getRole()!=null && shopUser.getRole().toString().length()>0){
                WHERE("role = #{role}");
            }
                if(StringUtils.isNotBlank(shopUser.getShopId())){
                WHERE("shop_id = #{shopId}");
            }

                if(shopUser.getCreateTime()!=null && shopUser.getCreateTime().toString().length()>0){
                WHERE("create_time = #{createTime}");
            }

                if(shopUser.getUpdateTime()!=null && shopUser.getUpdateTime().toString().length()>0){
                WHERE("update_time = #{updateTime}");
            }

                if(shopUser.getStatus()!=null && shopUser.getStatus().toString().length()>0){
                WHERE("status = #{status}");
            }
                if(StringUtils.isNotBlank(shopUser.getOpenId())){
                WHERE("open_id = #{openId}");
            }
        }}.toString();
    }
}
