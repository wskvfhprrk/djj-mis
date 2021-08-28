package com.guardlbt.dao;

import com.guardlbt.entity.SysDept;
import org.apache.ibatis.jdbc.SQL;
import org.apache.commons.lang3.StringUtils;

/**
* 商店部门管理SQL语句
* Created by 代码自动生成.
* 时间:2021-08-28 13:20:38
*/
public class SysDeptDaoSql {

    public static String selectSysDepts(final SysDept sysDept){
        return new SQL(){{
            SELECT("a.dept_id ,a.parent_id ,a.name ,a.order_num ,a.del_flag");
            FROM("sys_dept a");

            if(sysDept!=null && sysDept.getDeptId()!=null && sysDept.getDeptId().toString().length()>0){
                WHERE("a.Dept_id = #{deptId}");
            }
            if(sysDept!=null && sysDept.getParentId()!=null && sysDept.getParentId().toString().length()>0){
                WHERE("a.Parent_id = #{parentId}");
            }            if(sysDept!=null && StringUtils.isNotBlank(sysDept.getName())){
                WHERE("a.Name like CONCAT('%',#{name},'%')");
            }
            if(sysDept!=null && sysDept.getOrderNum()!=null && sysDept.getOrderNum().toString().length()>0){
                WHERE("a.Order_num = #{orderNum}");
            }
            if(sysDept!=null && sysDept.getDelFlag()!=null && sysDept.getDelFlag().toString().length()>0){
                WHERE("a.Del_flag = #{delFlag}");
            }
        }}.toString();
    }

    public static String insert(final SysDept sysDept){
        return new SQL(){{
            INSERT_INTO("sys_dept");

            if(sysDept.getDeptId()!=null && sysDept.getDeptId().toString().length()>0){
                VALUES("dept_id", "#{deptId}");
            }

            if(sysDept.getParentId()!=null && sysDept.getParentId().toString().length()>0){
                VALUES("parent_id", "#{parentId}");
            }
            if(StringUtils.isNotBlank(sysDept.getName())){
                VALUES("name", "#{name}");
            }

            if(sysDept.getOrderNum()!=null && sysDept.getOrderNum().toString().length()>0){
                VALUES("order_num", "#{orderNum}");
            }

            if(sysDept.getDelFlag()!=null && sysDept.getDelFlag().toString().length()>0){
                VALUES("del_flag", "#{delFlag}");
            }
    }}.toString();
    }

    public static String update(final SysDept sysDept){
        return new SQL(){{
            UPDATE("sys_dept");

                if(sysDept.getDeptId()!=null && sysDept.getDeptId().toString().length()>0){
                SET("dept_id = #{deptId}");
            }

                if(sysDept.getParentId()!=null && sysDept.getParentId().toString().length()>0){
                SET("parent_id = #{parentId}");
            }
                if(StringUtils.isNotBlank(sysDept.getName())){
                SET("name = #{name}");
            }

                if(sysDept.getOrderNum()!=null && sysDept.getOrderNum().toString().length()>0){
                SET("order_num = #{orderNum}");
            }

                if(sysDept.getDelFlag()!=null && sysDept.getDelFlag().toString().length()>0){
                SET("del_flag = #{delFlag}");
            }

                if(sysDept.getDeptId()!=null && sysDept.getDeptId().toString().length()>0){
                WHERE("dept_id = #{deptId}");
            }
        }}.toString();
    }

    public static String delete(final SysDept sysDept){
        return new SQL(){{
            DELETE_FROM("sys_dept");

                if(sysDept.getDeptId()!=null && sysDept.getDeptId().toString().length()>0){
                WHERE("dept_id = #{deptId}");
            }

                if(sysDept.getParentId()!=null && sysDept.getParentId().toString().length()>0){
                WHERE("parent_id = #{parentId}");
            }
                if(StringUtils.isNotBlank(sysDept.getName())){
                WHERE("name = #{name}");
            }

                if(sysDept.getOrderNum()!=null && sysDept.getOrderNum().toString().length()>0){
                WHERE("order_num = #{orderNum}");
            }

                if(sysDept.getDelFlag()!=null && sysDept.getDelFlag().toString().length()>0){
                WHERE("del_flag = #{delFlag}");
            }
        }}.toString();
    }
}
