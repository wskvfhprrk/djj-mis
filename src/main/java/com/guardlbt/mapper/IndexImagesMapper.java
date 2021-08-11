package com.guardlbt.mapper;

import com.guardlbt.entity.IndexImages;
import com.guardlbt.entity.IndexImagesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IndexImagesMapper {
    long countByExample(IndexImagesExample example);

    int deleteByExample(IndexImagesExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(IndexImages record);

    int insertSelective(IndexImages record);

    List<IndexImages> selectByExample(IndexImagesExample example);

    IndexImages selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") IndexImages record, @Param("example") IndexImagesExample example);

    int updateByExample(@Param("record") IndexImages record, @Param("example") IndexImagesExample example);

    int updateByPrimaryKeySelective(IndexImages record);

    int updateByPrimaryKey(IndexImages record);
}