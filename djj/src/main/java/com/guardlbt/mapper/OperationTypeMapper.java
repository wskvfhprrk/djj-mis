package com.guardlbt.mapper;

import com.guardlbt.entity.OperationType;
import com.guardlbt.entity.OperationTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OperationTypeMapper {
    long countByExample(OperationTypeExample example);

    int deleteByExample(OperationTypeExample example);

    int deleteByPrimaryKey(String operationId);

    int insert(OperationType record);

    int insertSelective(OperationType record);

    List<OperationType> selectByExample(OperationTypeExample example);

    OperationType selectByPrimaryKey(String operationId);

    int updateByExampleSelective(@Param("record") OperationType record, @Param("example") OperationTypeExample example);

    int updateByExample(@Param("record") OperationType record, @Param("example") OperationTypeExample example);

    int updateByPrimaryKeySelective(OperationType record);

    int updateByPrimaryKey(OperationType record);
}