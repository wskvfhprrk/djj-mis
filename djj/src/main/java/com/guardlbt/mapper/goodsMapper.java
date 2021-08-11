package com.guardlbt.mapper;

import com.guardlbt.entity.goods;
import com.guardlbt.entity.goodsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface goodsMapper {
    long countByExample(goodsExample example);

    int deleteByExample(goodsExample example);

    int deleteByPrimaryKey(String goodsId);

    int insert(goods record);

    int insertSelective(goods record);

    List<goods> selectByExample(goodsExample example);

    goods selectByPrimaryKey(String goodsId);

    int updateByExampleSelective(@Param("record") goods record, @Param("example") goodsExample example);

    int updateByExample(@Param("record") goods record, @Param("example") goodsExample example);

    int updateByPrimaryKeySelective(goods record);

    int updateByPrimaryKey(goods record);
}