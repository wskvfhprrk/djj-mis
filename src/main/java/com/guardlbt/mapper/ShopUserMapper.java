package com.guardlbt.mapper;

import com.guardlbt.entity.ShopUser;
import com.guardlbt.entity.ShopUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ShopUserMapper {
    long countByExample(ShopUserExample example);

    int deleteByExample(ShopUserExample example);

    int deleteByPrimaryKey(String userId);

    int insert(ShopUser record);

    int insertSelective(ShopUser record);

    List<ShopUser> selectByExample(ShopUserExample example);

    ShopUser selectByPrimaryKey(String userId);

    int updateByExampleSelective(@Param("record") ShopUser record, @Param("example") ShopUserExample example);

    int updateByExample(@Param("record") ShopUser record, @Param("example") ShopUserExample example);

    int updateByPrimaryKeySelective(ShopUser record);

    int updateByPrimaryKey(ShopUser record);
}