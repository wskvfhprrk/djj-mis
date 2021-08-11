package com.guardlbt.mapper;

import com.guardlbt.entity.Coupon;
import com.guardlbt.entity.CouponExample;
import com.guardlbt.entity.CouponWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CouponMapper {
    long countByExample(CouponExample example);

    int deleteByExample(CouponExample example);

    int deleteByPrimaryKey(String couponId);

    int insert(CouponWithBLOBs record);

    int insertSelective(CouponWithBLOBs record);

    List<CouponWithBLOBs> selectByExampleWithBLOBs(CouponExample example);

    List<Coupon> selectByExample(CouponExample example);

    CouponWithBLOBs selectByPrimaryKey(String couponId);

    int updateByExampleSelective(@Param("record") CouponWithBLOBs record, @Param("example") CouponExample example);

    int updateByExampleWithBLOBs(@Param("record") CouponWithBLOBs record, @Param("example") CouponExample example);

    int updateByExample(@Param("record") Coupon record, @Param("example") CouponExample example);

    int updateByPrimaryKeySelective(CouponWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(CouponWithBLOBs record);

    int updateByPrimaryKey(Coupon record);
}