package com.guardlbt.mapper;

import com.guardlbt.entity.MRoleMenuExample;
import com.guardlbt.entity.MRoleMenuKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MRoleMenuMapper {
    long countByExample(MRoleMenuExample example);

    int deleteByExample(MRoleMenuExample example);

    int deleteByPrimaryKey(MRoleMenuKey key);

    int insert(MRoleMenuKey record);

    int insertSelective(MRoleMenuKey record);

    List<MRoleMenuKey> selectByExample(MRoleMenuExample example);

    int updateByExampleSelective(@Param("record") MRoleMenuKey record, @Param("example") MRoleMenuExample example);

    int updateByExample(@Param("record") MRoleMenuKey record, @Param("example") MRoleMenuExample example);
}