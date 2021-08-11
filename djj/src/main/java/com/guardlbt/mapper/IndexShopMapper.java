package com.guardlbt.mapper;

import com.guardlbt.entity.IndexShop;
import com.guardlbt.entity.IndexShopExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IndexShopMapper {
    long countByExample(IndexShopExample example);

    int deleteByExample(IndexShopExample example);

    int deleteByPrimaryKey(Integer sorting);

    int insert(IndexShop record);

    int insertSelective(IndexShop record);

    List<IndexShop> selectByExample(IndexShopExample example);

    IndexShop selectByPrimaryKey(Integer sorting);

    int updateByExampleSelective(@Param("record") IndexShop record, @Param("example") IndexShopExample example);

    int updateByExample(@Param("record") IndexShop record, @Param("example") IndexShopExample example);

    int updateByPrimaryKeySelective(IndexShop record);

    int updateByPrimaryKey(IndexShop record);
}