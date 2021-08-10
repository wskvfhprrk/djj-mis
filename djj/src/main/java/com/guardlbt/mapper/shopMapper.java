package com.guardlbt.mapper;

import com.guardlbt.entity.shop;
import com.guardlbt.entity.shopExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface shopMapper {
    long countByExample(shopExample example);

    int deleteByExample(shopExample example);

    int deleteByPrimaryKey(String shopId);

    int insert(shop record);

    int insertSelective(shop record);

    List<shop> selectByExampleWithBLOBs(shopExample example);

    List<shop> selectByExample(shopExample example);

    shop selectByPrimaryKey(String shopId);

    int updateByExampleSelective(@Param("record") shop record, @Param("example") shopExample example);

    int updateByExampleWithBLOBs(@Param("record") shop record, @Param("example") shopExample example);

    int updateByExample(@Param("record") shop record, @Param("example") shopExample example);

    int updateByPrimaryKeySelective(shop record);

    int updateByPrimaryKeyWithBLOBs(shop record);

    int updateByPrimaryKey(shop record);
}