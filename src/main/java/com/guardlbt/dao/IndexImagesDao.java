package com.guardlbt.dao;

import com.guardlbt.entity.IndexImages;
import org.apache.ibatis.annotations.*;

import java.util.*;

/**
* 轮播图dao方法
* Created by 代码自动生成.
* 时间:2021-08-25 18:06:23
*/
@Mapper
public interface IndexImagesDao {

    /**
    * 条件查询全部数据
    * @param indexImages
    * @return List<Map>类型的集合
    */
    @Results(value = {
        @Result(column = "id", property = "id", id=true),
        @Result(column = "image_url", property = "imageUrl"),
        @Result(column = "type", property = "type"),
        @Result(column = "address", property = "address"),
    })
    @SelectProvider(type = IndexImagesDaoSql.class, method = "selectIndexImagess")
    List<IndexImages> selectIndexImagess(IndexImages indexImages);


    /**
    * 添加
    * @param indexImages
    */
    @SelectProvider(type = IndexImagesDaoSql.class, method = "insert")
    void insert(IndexImages indexImages);

    /**
    * 更新
    * @param indexImages
    */
    @SelectProvider(type = IndexImagesDaoSql.class, method = "update")
    void update(IndexImages indexImages);

    /**
    * 根据条件删除
    * @param indexImages
    */
    @SelectProvider(type = IndexImagesDaoSql.class, method = "delete")
    void delete(IndexImages indexImages);

    /**
    * 根据主键IDS批量删除(只适合单主键,不支持多主键批量删除,多主键时请删除SQL中多余主键字段)
    * @param ids 主键字符串集合
    */
    @Select("<script>" +
        "DELETE FROM index_images WHERE id IN " +
        "<foreach item='item' index='index' collection='ids' open='(' separator=',' close=')'>#{item}</foreach> </script>")
    void deleteAll(@Param("ids") List<String> ids);

}
