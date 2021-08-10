package com.guardlbt.mapper;

import com.guardlbt.entity.Role;
import com.guardlbt.entity.RoleExample;
import java.util.List;

import com.guardlbt.vo.SelectAllRoleByUserIdVo;
import org.apache.ibatis.annotations.Param;

public interface RoleMapper {
    long countByExample(RoleExample example);

    int deleteByExample(RoleExample example);

    int deleteByPrimaryKey(Integer roleId);

    int insert(Role record);

    int insertSelective(Role record);

    List<Role> selectByExample(RoleExample example);

    Role selectByPrimaryKey(Integer roleId);

    int updateByExampleSelective(@Param("record") Role record, @Param("example") RoleExample example);

    int updateByExample(@Param("record") Role record, @Param("example") RoleExample example);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    List<SelectAllRoleByUserIdVo> selectAllRoleByUserId(@Param("userId")Integer userId);
}