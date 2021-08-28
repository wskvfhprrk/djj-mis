package com.guardlbt.dao;

import com.guardlbt.entity.Member;
import org.apache.ibatis.annotations.*;

import java.util.*;

/**
* 会员dao方法
* Created by 代码自动生成.
* 时间:2021-08-28 13:20:39
*/
@Mapper
public interface MemberDao {

    /**
    * 条件查询全部数据
    * @param member
    * @return List<Map>类型的集合
    */
    @Results(value = {
        @Result(column = "member_id", property = "memberId", id=true),
        @Result(column = "open_id", property = "openId"),
        @Result(column = "phone", property = "phone"),
        @Result(column = "sex", property = "sex"),
        @Result(column = "birthday", property = "birthday"),
        @Result(column = "register_time", property = "registerTime"),
        @Result(column = "image_url", property = "imageUrl"),
        @Result(column = "nickname", property = "nickname"),
        @Result(column = "name", property = "name"),
        @Result(column = "label", property = "label"),
        @Result(column = "description", property = "description"),
        @Result(column = "shop_id", property = "shopId"),
    })
    @SelectProvider(type = MemberDaoSql.class, method = "selectMembers")
    List<Member> selectMembers(Member member);


    /**
    * 添加
    * @param member
    */
    @SelectProvider(type = MemberDaoSql.class, method = "insert")
    void insert(Member member);

    /**
    * 更新
    * @param member
    */
    @SelectProvider(type = MemberDaoSql.class, method = "update")
    void update(Member member);

    /**
    * 根据条件删除
    * @param member
    */
    @SelectProvider(type = MemberDaoSql.class, method = "delete")
    void delete(Member member);

    /**
    * 根据主键IDS批量删除(只适合单主键,不支持多主键批量删除,多主键时请删除SQL中多余主键字段)
    * @param ids 主键字符串集合
    */
    @Select("<script>" +
        "DELETE FROM member WHERE member_id IN " +
        "<foreach item='item' index='index' collection='ids' open='(' separator=',' close=')'>#{item}</foreach> </script>")
    void deleteAll(@Param("ids") List<String> ids);

}
