package com.guardlbt.dao;

import com.guardlbt.entity.OperationType;
import org.apache.ibatis.jdbc.SQL;
import org.apache.commons.lang3.StringUtils;

/**
* 操作类型SQL语句
* Created by 代码自动生成.
* 时间:2021-08-28 11:42:18
*/
public class OperationTypeDaoSql {

    public static String selectOperationTypes(final OperationType operationType){
        return new SQL(){{
            SELECT("a.operation_id ,a.name");
            FROM("operation_type a");
            if(operationType !=null && StringUtils.isNotBlank(operationType.getOperationId())){
                WHERE("a.Operation_id like CONCAT('%',#{operationId},'%')");
            }            if(operationType !=null && StringUtils.isNotBlank(operationType.getName())){
                WHERE("a.Name like CONCAT('%',#{name},'%')");
            }
        }}.toString();
    }

    public static String insert(final OperationType operationType){
        return new SQL(){{
            INSERT_INTO("operation_type");
            if(StringUtils.isNotBlank(operationType.getOperationId())){
                VALUES("operation_id", "#{operationId}");
            }
            if(StringUtils.isNotBlank(operationType.getName())){
                VALUES("name", "#{name}");
            }
    }}.toString();
    }

    public static String update(final OperationType operationType){
        return new SQL(){{
            UPDATE("operation_type");
                if(StringUtils.isNotBlank(operationType.getOperationId())){
                SET("operation_id = #{operationId}");
            }
                if(StringUtils.isNotBlank(operationType.getName())){
                SET("name = #{name}");
            }
                if(StringUtils.isNotBlank(operationType.getOperationId())){
                WHERE("operation_id = #{operationId}");
            }
        }}.toString();
    }

    public static String delete(final OperationType operationType){
        return new SQL(){{
            DELETE_FROM("operation_type");
                if(StringUtils.isNotBlank(operationType.getOperationId())){
                WHERE("operation_id = #{operationId}");
            }
                if(StringUtils.isNotBlank(operationType.getName())){
                WHERE("name = #{name}");
            }
        }}.toString();
    }
}
