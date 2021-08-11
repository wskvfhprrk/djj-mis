package com.guardlbt.mapper;

import com.guardlbt.entity.MemberOperationHistory;
import com.guardlbt.entity.MemberOperationHistoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MemberOperationHistoryMapper {
    long countByExample(MemberOperationHistoryExample example);

    int deleteByExample(MemberOperationHistoryExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MemberOperationHistory record);

    int insertSelective(MemberOperationHistory record);

    List<MemberOperationHistory> selectByExampleWithBLOBs(MemberOperationHistoryExample example);

    List<MemberOperationHistory> selectByExample(MemberOperationHistoryExample example);

    MemberOperationHistory selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MemberOperationHistory record, @Param("example") MemberOperationHistoryExample example);

    int updateByExampleWithBLOBs(@Param("record") MemberOperationHistory record, @Param("example") MemberOperationHistoryExample example);

    int updateByExample(@Param("record") MemberOperationHistory record, @Param("example") MemberOperationHistoryExample example);

    int updateByPrimaryKeySelective(MemberOperationHistory record);

    int updateByPrimaryKeyWithBLOBs(MemberOperationHistory record);

    int updateByPrimaryKey(MemberOperationHistory record);
}