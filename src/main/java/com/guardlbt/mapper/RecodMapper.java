package com.guardlbt.mapper;

import com.guardlbt.entity.Recod;
import com.guardlbt.entity.RecodExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RecodMapper {
    long countByExample(RecodExample example);

    int deleteByExample(RecodExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Recod record);

    int insertSelective(Recod record);

    List<Recod> selectByExample(RecodExample example);

    Recod selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Recod record, @Param("example") RecodExample example);

    int updateByExample(@Param("record") Recod record, @Param("example") RecodExample example);

    int updateByPrimaryKeySelective(Recod record);

    int updateByPrimaryKey(Recod record);
}