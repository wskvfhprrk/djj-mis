package com.guardlbt.dao;

import com.guardlbt.entity.Picture;
import org.apache.ibatis.annotations.*;

import java.util.*;

/**
* 图片管理dao方法
* Created by 代码自动生成.
* 时间:2021-08-25 18:06:24
*/
@Mapper
public interface PictureDao {

    /**
    * 条件查询全部数据
    * @param picture
    * @return List<Map>类型的集合
    */
    @Results(value = {
        @Result(column = "id", property = "id", id=true),
        @Result(column = "url", property = "url"),
        @Result(column = "create_time", property = "createTime"),
        @Result(column = "update_time", property = "updateTime"),
        @Result(column = "is_thumb_image", property = "isThumbImage"),
        @Result(column = "status", property = "status"),
    })
    @SelectProvider(type = PictureDaoSql.class, method = "selectPictures")
    List<Picture> selectPictures(Picture picture);


    /**
    * 添加
    * @param picture
    */
    @SelectProvider(type = PictureDaoSql.class, method = "insert")
    void insert(Picture picture);

    /**
    * 更新
    * @param picture
    */
    @SelectProvider(type = PictureDaoSql.class, method = "update")
    void update(Picture picture);

    /**
    * 根据条件删除
    * @param picture
    */
    @SelectProvider(type = PictureDaoSql.class, method = "delete")
    void delete(Picture picture);

    /**
    * 根据主键IDS批量删除(只适合单主键,不支持多主键批量删除,多主键时请删除SQL中多余主键字段)
    * @param ids 主键字符串集合
    */
    @Select("<script>" +
        "DELETE FROM picture WHERE id IN " +
        "<foreach item='item' index='index' collection='ids' open='(' separator=',' close=')'>#{item}</foreach> </script>")
    void deleteAll(@Param("ids") List<String> ids);

}
