package com.guardlbt.mapper;

import com.guardlbt.entity.BusinessDistrict;
import com.guardlbt.entity.BusinessDistrictExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BusinessDistrictMapper {
    long countByExample(BusinessDistrictExample example);

    int deleteByExample(BusinessDistrictExample example);

    int deleteByPrimaryKey(String businessDistrictId);

    int insert(BusinessDistrict record);

    int insertSelective(BusinessDistrict record);

    List<BusinessDistrict> selectByExampleWithBLOBs(BusinessDistrictExample example);

    List<BusinessDistrict> selectByExample(BusinessDistrictExample example);

    BusinessDistrict selectByPrimaryKey(String businessDistrictId);

    int updateByExampleSelective(@Param("record") BusinessDistrict record, @Param("example") BusinessDistrictExample example);

    int updateByExampleWithBLOBs(@Param("record") BusinessDistrict record, @Param("example") BusinessDistrictExample example);

    int updateByExample(@Param("record") BusinessDistrict record, @Param("example") BusinessDistrictExample example);

    int updateByPrimaryKeySelective(BusinessDistrict record);

    int updateByPrimaryKeyWithBLOBs(BusinessDistrict record);

    int updateByPrimaryKey(BusinessDistrict record);
}