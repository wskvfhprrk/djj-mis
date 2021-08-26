package com.guardlbt.dao;

import com.guardlbt.entity.Member;
import org.apache.ibatis.jdbc.SQL;
import org.apache.commons.lang3.StringUtils;

/**
* 会员SQL语句
* Created by 代码自动生成.
* 时间:2021-08-25 18:06:24
*/
public class MemberDaoSql {

    public static String selectMembers(final Member member){
        return new SQL(){{
            SELECT("a.member_id ,a.open_id ,a.phone ,a.sex ,a.birthday ,a.register_time ,a.image_url ,a.nickname ,a.name ,a.label ,a.description ,a.shop_id");
            FROM("member a");
            if(member!=null && StringUtils.isNotBlank(member.getMemberId())){
                WHERE("a.Member_id like CONCAT('%',#{memberId},'%')");
            }            if(member!=null && StringUtils.isNotBlank(member.getOpenId())){
                WHERE("a.Open_id like CONCAT('%',#{openId},'%')");
            }            if(member!=null && StringUtils.isNotBlank(member.getPhone())){
                WHERE("a.Phone like CONCAT('%',#{phone},'%')");
            }            if(member!=null && StringUtils.isNotBlank(member.getSex())){
                WHERE("a.Sex like CONCAT('%',#{sex},'%')");
            }
            if(member!=null && member.getBirthday()!=null && member.getBirthday().toString().length()>0){
                WHERE("a.Birthday = #{birthday}");
            }
            if(member!=null && member.getRegisterTime()!=null && member.getRegisterTime().toString().length()>0){
                WHERE("a.Register_time = #{registerTime}");
            }            if(member!=null && StringUtils.isNotBlank(member.getImageUrl())){
                WHERE("a.Image_url like CONCAT('%',#{imageUrl},'%')");
            }            if(member!=null && StringUtils.isNotBlank(member.getNickname())){
                WHERE("a.Nickname like CONCAT('%',#{nickname},'%')");
            }            if(member!=null && StringUtils.isNotBlank(member.getName())){
                WHERE("a.Name like CONCAT('%',#{name},'%')");
            }            if(member!=null && StringUtils.isNotBlank(member.getLabel())){
                WHERE("a.Label like CONCAT('%',#{label},'%')");
            }            if(member!=null && StringUtils.isNotBlank(member.getDescription())){
                WHERE("a.Description like CONCAT('%',#{description},'%')");
            }            if(member!=null && StringUtils.isNotBlank(member.getShopId())){
                WHERE("a.Shop_id like CONCAT('%',#{shopId},'%')");
            }
        }}.toString();
    }

    public static String insert(final Member member){
        return new SQL(){{
            INSERT_INTO("member");
            if(StringUtils.isNotBlank(member.getMemberId())){
                VALUES("member_id", "#{memberId}");
            }
            if(StringUtils.isNotBlank(member.getOpenId())){
                VALUES("open_id", "#{openId}");
            }
            if(StringUtils.isNotBlank(member.getPhone())){
                VALUES("phone", "#{phone}");
            }
            if(StringUtils.isNotBlank(member.getSex())){
                VALUES("sex", "#{sex}");
            }

            if(member.getBirthday()!=null && member.getBirthday().toString().length()>0){
                VALUES("birthday", "#{birthday}");
            }

            if(member.getRegisterTime()!=null && member.getRegisterTime().toString().length()>0){
                VALUES("register_time", "#{registerTime}");
            }
            if(StringUtils.isNotBlank(member.getImageUrl())){
                VALUES("image_url", "#{imageUrl}");
            }
            if(StringUtils.isNotBlank(member.getNickname())){
                VALUES("nickname", "#{nickname}");
            }
            if(StringUtils.isNotBlank(member.getName())){
                VALUES("name", "#{name}");
            }
            if(StringUtils.isNotBlank(member.getLabel())){
                VALUES("label", "#{label}");
            }
            if(StringUtils.isNotBlank(member.getDescription())){
                VALUES("description", "#{description}");
            }
            if(StringUtils.isNotBlank(member.getShopId())){
                VALUES("shop_id", "#{shopId}");
            }
    }}.toString();
    }

    public static String update(final Member member){
        return new SQL(){{
            UPDATE("member");
                if(StringUtils.isNotBlank(member.getMemberId())){
                SET("member_id = #{memberId}");
            }
                if(StringUtils.isNotBlank(member.getOpenId())){
                SET("open_id = #{openId}");
            }
                if(StringUtils.isNotBlank(member.getPhone())){
                SET("phone = #{phone}");
            }
                if(StringUtils.isNotBlank(member.getSex())){
                SET("sex = #{sex}");
            }

                if(member.getBirthday()!=null && member.getBirthday().toString().length()>0){
                SET("birthday = #{birthday}");
            }

                if(member.getRegisterTime()!=null && member.getRegisterTime().toString().length()>0){
                SET("register_time = #{registerTime}");
            }
                if(StringUtils.isNotBlank(member.getImageUrl())){
                SET("image_url = #{imageUrl}");
            }
                if(StringUtils.isNotBlank(member.getNickname())){
                SET("nickname = #{nickname}");
            }
                if(StringUtils.isNotBlank(member.getName())){
                SET("name = #{name}");
            }
                if(StringUtils.isNotBlank(member.getLabel())){
                SET("label = #{label}");
            }
                if(StringUtils.isNotBlank(member.getDescription())){
                SET("description = #{description}");
            }
                if(StringUtils.isNotBlank(member.getShopId())){
                SET("shop_id = #{shopId}");
            }
                if(StringUtils.isNotBlank(member.getMemberId())){
                WHERE("member_id = #{memberId}");
            }
        }}.toString();
    }

    public static String delete(final Member member){
        return new SQL(){{
            DELETE_FROM("member");
                if(StringUtils.isNotBlank(member.getMemberId())){
                WHERE("member_id = #{memberId}");
            }
                if(StringUtils.isNotBlank(member.getOpenId())){
                WHERE("open_id = #{openId}");
            }
                if(StringUtils.isNotBlank(member.getPhone())){
                WHERE("phone = #{phone}");
            }
                if(StringUtils.isNotBlank(member.getSex())){
                WHERE("sex = #{sex}");
            }

                if(member.getBirthday()!=null && member.getBirthday().toString().length()>0){
                WHERE("birthday = #{birthday}");
            }

                if(member.getRegisterTime()!=null && member.getRegisterTime().toString().length()>0){
                WHERE("register_time = #{registerTime}");
            }
                if(StringUtils.isNotBlank(member.getImageUrl())){
                WHERE("image_url = #{imageUrl}");
            }
                if(StringUtils.isNotBlank(member.getNickname())){
                WHERE("nickname = #{nickname}");
            }
                if(StringUtils.isNotBlank(member.getName())){
                WHERE("name = #{name}");
            }
                if(StringUtils.isNotBlank(member.getLabel())){
                WHERE("label = #{label}");
            }
                if(StringUtils.isNotBlank(member.getDescription())){
                WHERE("description = #{description}");
            }
                if(StringUtils.isNotBlank(member.getShopId())){
                WHERE("shop_id = #{shopId}");
            }
        }}.toString();
    }
}
