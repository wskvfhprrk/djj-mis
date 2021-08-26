package com.guardlbt.dao;

import com.guardlbt.entity.ShopUser;
import org.apache.ibatis.annotations.*;

import java.util.*;

/**
* 商店管理员dao方法
* Created by 代码自动生成.
* 时间:2021-08-25 18:06:23
*/
@Mapper
public interface ShopUserDao {

    /**
    * 条件查询全部数据
    * @param shopUser
    * @return List<Map>类型的集合
    */
    @Results(value = {
        @Result(column = "user_id", property = "userId", id=true),
        @Result(column = "name", property = "name"),
        @Result(column = "sex", property = "sex"),
        @Result(column = "birthday", property = "birthday"),
        @Result(column = "phone", property = "phone"),
        @Result(column = "role", property = "role"),
        @Result(column = "shop_id", property = "shopId"),
        @Result(column = "create_time", property = "createTime"),
        @Result(column = "update_time", property = "updateTime"),
        @Result(column = "status", property = "status"),
        @Result(column = "open_id", property = "openId"),
    })
    @SelectProvider(type = ShopUserDaoSql.class, method = "selectShopUsers")
    List<ShopUser> selectShopUsers(ShopUser shopUser);


    /**
    * 添加
    * @param shopUser
    */
    @SelectProvider(type = ShopUserDaoSql.class, method = "insert")
    void insert(ShopUser shopUser);

    /**
    * 更新
    * @param shopUser
    */
    @SelectProvider(type = ShopUserDaoSql.class, method = "update")
    void update(ShopUser shopUser);

    /**
    * 根据条件删除
    * @param shopUser
    */
    @SelectProvider(type = ShopUserDaoSql.class, method = "delete")
    void delete(ShopUser shopUser);

    /**
    * 根据主键IDS批量删除(只适合单主键,不支持多主键批量删除,多主键时请删除SQL中多余主键字段)
    * @param ids 主键字符串集合
    */
    @Select("<script>" +
        "DELETE FROM shop_user WHERE user_id IN " +
        "<foreach item='item' index='index' collection='ids' open='(' separator=',' close=')'>#{item}</foreach> </script>")
    void deleteAll(@Param("ids") List<String> ids);

}
