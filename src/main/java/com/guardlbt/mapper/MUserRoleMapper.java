package com.guardlbt.mapper;

import com.guardlbt.entity.MUserRoleExample;
import com.guardlbt.entity.MUserRoleKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MUserRoleMapper {
    long countByExample(MUserRoleExample example);

    int deleteByExample(MUserRoleExample example);

    int deleteByPrimaryKey(MUserRoleKey key);

    int insert(MUserRoleKey record);

    int insertSelective(MUserRoleKey record);

    List<MUserRoleKey> selectByExample(MUserRoleExample example);

    int updateByExampleSelective(@Param("record") MUserRoleKey record, @Param("example") MUserRoleExample example);

    int updateByExample(@Param("record") MUserRoleKey record, @Param("example") MUserRoleExample example);
}