package com.guardlbt.dao;

import com.guardlbt.entity.MemberOperationHistory;
import org.apache.ibatis.annotations.*;

import java.util.*;

/**
* 会员操作记录历史dao方法
* Created by 代码自动生成.
* 时间:2021-08-27 13:42:56
*/
@Mapper
public interface MemberOperationHistoryDao {

    /**
    * 条件查询全部数据
    * @param memberOperationHistory
    * @return List<Map>类型的集合
    */
    @Results(value = {
        @Result(column = "id", property = "id", id=true),
        @Result(column = "member_id", property = "memberId"),
        @Result(column = "operation_id", property = "operationId"),
        @Result(column = "relation_info", property = "relationInfo"),
        @Result(column = "detail", property = "detail"),
        @Result(column = "create_time", property = "createTime"),
    })
    @SelectProvider(type = MemberOperationHistoryDaoSql.class, method = "selectMemberOperationHistorys")
    List<MemberOperationHistory> selectMemberOperationHistorys(MemberOperationHistory memberOperationHistory);


    /**
    * 添加
    * @param memberOperationHistory
    */
    @SelectProvider(type = MemberOperationHistoryDaoSql.class, method = "insert")
    void insert(MemberOperationHistory memberOperationHistory);

    /**
    * 更新
    * @param memberOperationHistory
    */
    @SelectProvider(type = MemberOperationHistoryDaoSql.class, method = "update")
    void update(MemberOperationHistory memberOperationHistory);

    /**
    * 根据条件删除
    * @param memberOperationHistory
    */
    @SelectProvider(type = MemberOperationHistoryDaoSql.class, method = "delete")
    void delete(MemberOperationHistory memberOperationHistory);

    /**
    * 根据主键IDS批量删除(只适合单主键,不支持多主键批量删除,多主键时请删除SQL中多余主键字段)
    * @param ids 主键字符串集合
    */
    @Select("<script>" +
        "DELETE FROM member_operation_history WHERE id IN " +
        "<foreach item='item' index='index' collection='ids' open='(' separator=',' close=')'>#{item}</foreach> </script>")
    void deleteAll(@Param("ids") List<String> ids);

}
