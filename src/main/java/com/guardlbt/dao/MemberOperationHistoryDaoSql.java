package com.guardlbt.dao;

import com.guardlbt.entity.MemberOperationHistory;
import org.apache.ibatis.jdbc.SQL;
import org.apache.commons.lang3.StringUtils;

/**
* 会员操作记录历史SQL语句
* Created by 代码自动生成.
* 时间:2021-08-25 18:06:24
*/
public class MemberOperationHistoryDaoSql {

    public static String selectMemberOperationHistorys(final MemberOperationHistory memberOperationHistory){
        return new SQL(){{
            SELECT("a.id ,a.member_id ,a.operation_id ,a.relation_info ,a.detail ,a.create_time");
            FROM("member_operation_history a");

            if(memberOperationHistory!=null && memberOperationHistory.getId()!=null && memberOperationHistory.getId().toString().length()>0){
                WHERE("a.Id = #{id}");
            }            if(memberOperationHistory!=null && StringUtils.isNotBlank(memberOperationHistory.getMemberId())){
                WHERE("a.Member_id like CONCAT('%',#{memberId},'%')");
            }            if(memberOperationHistory!=null && StringUtils.isNotBlank(memberOperationHistory.getOperationId())){
                WHERE("a.Operation_id like CONCAT('%',#{operationId},'%')");
            }            if(memberOperationHistory!=null && StringUtils.isNotBlank(memberOperationHistory.getRelationInfo())){
                WHERE("a.Relation_info like CONCAT('%',#{relationInfo},'%')");
            }            if(memberOperationHistory!=null && StringUtils.isNotBlank(memberOperationHistory.getDetail())){
                WHERE("a.Detail like CONCAT('%',#{detail},'%')");
            }
            if(memberOperationHistory!=null && memberOperationHistory.getCreateTime()!=null && memberOperationHistory.getCreateTime().toString().length()>0){
                WHERE("a.Create_time = #{createTime}");
            }
        }}.toString();
    }

    public static String insert(final MemberOperationHistory memberOperationHistory){
        return new SQL(){{
            INSERT_INTO("member_operation_history");

            if(memberOperationHistory.getId()!=null && memberOperationHistory.getId().toString().length()>0){
                VALUES("id", "#{id}");
            }
            if(StringUtils.isNotBlank(memberOperationHistory.getMemberId())){
                VALUES("member_id", "#{memberId}");
            }
            if(StringUtils.isNotBlank(memberOperationHistory.getOperationId())){
                VALUES("operation_id", "#{operationId}");
            }
            if(StringUtils.isNotBlank(memberOperationHistory.getRelationInfo())){
                VALUES("relation_info", "#{relationInfo}");
            }
            if(StringUtils.isNotBlank(memberOperationHistory.getDetail())){
                VALUES("detail", "#{detail}");
            }

            if(memberOperationHistory.getCreateTime()!=null && memberOperationHistory.getCreateTime().toString().length()>0){
                VALUES("create_time", "#{createTime}");
            }
    }}.toString();
    }

    public static String update(final MemberOperationHistory memberOperationHistory){
        return new SQL(){{
            UPDATE("member_operation_history");

                if(memberOperationHistory.getId()!=null && memberOperationHistory.getId().toString().length()>0){
                SET("id = #{id}");
            }
                if(StringUtils.isNotBlank(memberOperationHistory.getMemberId())){
                SET("member_id = #{memberId}");
            }
                if(StringUtils.isNotBlank(memberOperationHistory.getOperationId())){
                SET("operation_id = #{operationId}");
            }
                if(StringUtils.isNotBlank(memberOperationHistory.getRelationInfo())){
                SET("relation_info = #{relationInfo}");
            }
                if(StringUtils.isNotBlank(memberOperationHistory.getDetail())){
                SET("detail = #{detail}");
            }

                if(memberOperationHistory.getCreateTime()!=null && memberOperationHistory.getCreateTime().toString().length()>0){
                SET("create_time = #{createTime}");
            }

                if(memberOperationHistory.getId()!=null && memberOperationHistory.getId().toString().length()>0){
                WHERE("id = #{id}");
            }
        }}.toString();
    }

    public static String delete(final MemberOperationHistory memberOperationHistory){
        return new SQL(){{
            DELETE_FROM("member_operation_history");

                if(memberOperationHistory.getId()!=null && memberOperationHistory.getId().toString().length()>0){
                WHERE("id = #{id}");
            }
                if(StringUtils.isNotBlank(memberOperationHistory.getMemberId())){
                WHERE("member_id = #{memberId}");
            }
                if(StringUtils.isNotBlank(memberOperationHistory.getOperationId())){
                WHERE("operation_id = #{operationId}");
            }
                if(StringUtils.isNotBlank(memberOperationHistory.getRelationInfo())){
                WHERE("relation_info = #{relationInfo}");
            }
                if(StringUtils.isNotBlank(memberOperationHistory.getDetail())){
                WHERE("detail = #{detail}");
            }

                if(memberOperationHistory.getCreateTime()!=null && memberOperationHistory.getCreateTime().toString().length()>0){
                WHERE("create_time = #{createTime}");
            }
        }}.toString();
    }
}
