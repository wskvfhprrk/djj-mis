package com.guardlbt.mapper;

import com.guardlbt.entity.IndexCoupon;
import com.guardlbt.entity.IndexCouponExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IndexCouponMapper {
    long countByExample(IndexCouponExample example);

    int deleteByExample(IndexCouponExample example);

    int deleteByPrimaryKey(Integer sorting);

    int insert(IndexCoupon record);

    int insertSelective(IndexCoupon record);

    List<IndexCoupon> selectByExample(IndexCouponExample example);

    IndexCoupon selectByPrimaryKey(Integer sorting);

    int updateByExampleSelective(@Param("record") IndexCoupon record, @Param("example") IndexCouponExample example);

    int updateByExample(@Param("record") IndexCoupon record, @Param("example") IndexCouponExample example);

    int updateByPrimaryKeySelective(IndexCoupon record);

    int updateByPrimaryKey(IndexCoupon record);
}