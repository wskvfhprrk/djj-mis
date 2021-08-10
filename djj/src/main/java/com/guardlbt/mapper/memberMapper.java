package com.guardlbt.mapper;

import com.guardlbt.entity.member;
import com.guardlbt.entity.memberExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface memberMapper {
    long countByExample(memberExample example);

    int deleteByExample(memberExample example);

    int deleteByPrimaryKey(String memberId);

    int insert(member record);

    int insertSelective(member record);

    List<member> selectByExample(memberExample example);

    member selectByPrimaryKey(String memberId);

    int updateByExampleSelective(@Param("record") member record, @Param("example") memberExample example);

    int updateByExample(@Param("record") member record, @Param("example") memberExample example);

    int updateByPrimaryKeySelective(member record);

    int updateByPrimaryKey(member record);
}