package com.guardlbt.dao;

import com.guardlbt.entity.SysDept;
import org.apache.ibatis.annotations.*;

import java.util.*;

/**
* 商店部门管理dao方法
* Created by 代码自动生成.
* 时间:2021-08-28 13:20:38
*/
@Mapper
public interface SysDeptDao {

    /**
    * 条件查询全部数据
    * @param sysDept
    * @return List<Map>类型的集合
    */
    @Results(value = {
        @Result(column = "dept_id", property = "deptId", id=true),
        @Result(column = "parent_id", property = "parentId"),
        @Result(column = "name", property = "name"),
        @Result(column = "order_num", property = "orderNum"),
        @Result(column = "del_flag", property = "delFlag"),
    })
    @SelectProvider(type = SysDeptDaoSql.class, method = "selectSysDepts")
    List<SysDept> selectSysDepts(SysDept sysDept);


    /**
    * 添加
    * @param sysDept
    */
    @SelectProvider(type = SysDeptDaoSql.class, method = "insert")
    void insert(SysDept sysDept);

    /**
    * 更新
    * @param sysDept
    */
    @SelectProvider(type = SysDeptDaoSql.class, method = "update")
    void update(SysDept sysDept);

    /**
    * 根据条件删除
    * @param sysDept
    */
    @SelectProvider(type = SysDeptDaoSql.class, method = "delete")
    void delete(SysDept sysDept);

    /**
    * 根据主键IDS批量删除(只适合单主键,不支持多主键批量删除,多主键时请删除SQL中多余主键字段)
    * @param ids 主键字符串集合
    */
    @Select("<script>" +
        "DELETE FROM sys_dept WHERE dept_id IN " +
        "<foreach item='item' index='index' collection='ids' open='(' separator=',' close=')'>#{item}</foreach> </script>")
    void deleteAll(@Param("ids") List<String> ids);

}
