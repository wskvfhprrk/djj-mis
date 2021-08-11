package com.guardlbt.mapper;

import com.guardlbt.entity.ReportSite;
import com.guardlbt.entity.ReportSiteExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ReportSiteMapper {
    long countByExample(ReportSiteExample example);

    int deleteByExample(ReportSiteExample example);

    int insert(ReportSite record);

    int insertSelective(ReportSite record);

    List<ReportSite> selectByExample(ReportSiteExample example);

    int updateByExampleSelective(@Param("record") ReportSite record, @Param("example") ReportSiteExample example);

    int updateByExample(@Param("record") ReportSite record, @Param("example") ReportSiteExample example);
}