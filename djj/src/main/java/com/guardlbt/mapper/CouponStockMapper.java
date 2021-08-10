package com.guardlbt.mapper;

import com.guardlbt.entity.CouponStock;
import com.guardlbt.entity.CouponStockExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CouponStockMapper {
    long countByExample(CouponStockExample example);

    int deleteByExample(CouponStockExample example);

    int deleteByPrimaryKey(String couponNo);

    int insert(CouponStock record);

    int insertSelective(CouponStock record);

    List<CouponStock> selectByExample(CouponStockExample example);

    CouponStock selectByPrimaryKey(String couponNo);

    int updateByExampleSelective(@Param("record") CouponStock record, @Param("example") CouponStockExample example);

    int updateByExample(@Param("record") CouponStock record, @Param("example") CouponStockExample example);

    int updateByPrimaryKeySelective(CouponStock record);

    int updateByPrimaryKey(CouponStock record);
}