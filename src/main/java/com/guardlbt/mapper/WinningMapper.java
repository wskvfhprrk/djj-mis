package com.guardlbt.mapper;

import com.guardlbt.entity.Winning;
import com.guardlbt.entity.WinningExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WinningMapper {
    long countByExample(WinningExample example);

    int deleteByExample(WinningExample example);

    int deleteByPrimaryKey(String id);

    int insert(Winning record);

    int insertSelective(Winning record);

    List<Winning> selectByExample(WinningExample example);

    Winning selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Winning record, @Param("example") WinningExample example);

    int updateByExample(@Param("record") Winning record, @Param("example") WinningExample example);

    int updateByPrimaryKeySelective(Winning record);

    int updateByPrimaryKey(Winning record);
}