package com.guardlbt.mapper;

import com.guardlbt.entity.coupon;
import com.guardlbt.entity.couponExample;
import com.guardlbt.entity.couponWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface couponMapper {
    long countByExample(couponExample example);

    int deleteByExample(couponExample example);

    int deleteByPrimaryKey(String couponId);

    int insert(couponWithBLOBs record);

    int insertSelective(couponWithBLOBs record);

    List<couponWithBLOBs> selectByExampleWithBLOBs(couponExample example);

    List<coupon> selectByExample(couponExample example);

    couponWithBLOBs selectByPrimaryKey(String couponId);

    int updateByExampleSelective(@Param("record") couponWithBLOBs record, @Param("example") couponExample example);

    int updateByExampleWithBLOBs(@Param("record") couponWithBLOBs record, @Param("example") couponExample example);

    int updateByExample(@Param("record") coupon record, @Param("example") couponExample example);

    int updateByPrimaryKeySelective(couponWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(couponWithBLOBs record);

    int updateByPrimaryKey(coupon record);
}