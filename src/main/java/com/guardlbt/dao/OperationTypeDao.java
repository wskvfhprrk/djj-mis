package com.guardlbt.dao;

import com.guardlbt.entity.OperationType;
import org.apache.ibatis.annotations.*;

import java.util.*;

/**
* 操作类型dao方法
* Created by 代码自动生成.
* 时间:2021-08-25 18:06:24
*/
@Mapper
public interface OperationTypeDao {

    /**
    * 条件查询全部数据
    * @param operationType
    * @return List<Map>类型的集合
    */
    @Results(value = {
        @Result(column = "operation_id", property = "operationId", id=true),
        @Result(column = "name", property = "name"),
    })
    @SelectProvider(type = OperationTypeDaoSql.class, method = "selectOperationTypes")
    List<OperationType> selectOperationTypes(OperationType operationType);


    /**
    * 添加
    * @param operationType
    */
    @SelectProvider(type = OperationTypeDaoSql.class, method = "insert")
    void insert(OperationType operationType);

    /**
    * 更新
    * @param operationType
    */
    @SelectProvider(type = OperationTypeDaoSql.class, method = "update")
    void update(OperationType operationType);

    /**
    * 根据条件删除
    * @param operationType
    */
    @SelectProvider(type = OperationTypeDaoSql.class, method = "delete")
    void delete(OperationType operationType);

    /**
    * 根据主键IDS批量删除(只适合单主键,不支持多主键批量删除,多主键时请删除SQL中多余主键字段)
    * @param ids 主键字符串集合
    */
    @Select("<script>" +
        "DELETE FROM operation_type WHERE operation_id IN " +
        "<foreach item='item' index='index' collection='ids' open='(' separator=',' close=')'>#{item}</foreach> </script>")
    void deleteAll(@Param("ids") List<String> ids);

}
