package com.guardlbt.dao;

import com.guardlbt.entity.IndexImages;
import org.apache.ibatis.jdbc.SQL;
import org.apache.commons.lang3.StringUtils;

/**
* 轮播图SQL语句
* Created by 代码自动生成.
* 时间:2021-08-27 13:42:56
*/
public class IndexImagesDaoSql {

    public static String selectIndexImagess(final IndexImages indexImages){
        return new SQL(){{
            SELECT("a.id ,a.image_url ,a.type ,a.address");
            FROM("index_images a");

            if(indexImages!=null && indexImages.getId()!=null && indexImages.getId().toString().length()>0){
                WHERE("a.Id = #{id}");
            }            if(indexImages!=null && StringUtils.isNotBlank(indexImages.getImageUrl())){
                WHERE("a.Image_url like CONCAT('%',#{imageUrl},'%')");
            }            if(indexImages!=null && StringUtils.isNotBlank(indexImages.getType())){
                WHERE("a.Type like CONCAT('%',#{type},'%')");
            }            if(indexImages!=null && StringUtils.isNotBlank(indexImages.getAddress())){
                WHERE("a.Address like CONCAT('%',#{address},'%')");
            }
        }}.toString();
    }

    public static String insert(final IndexImages indexImages){
        return new SQL(){{
            INSERT_INTO("index_images");

            if(indexImages.getId()!=null && indexImages.getId().toString().length()>0){
                VALUES("id", "#{id}");
            }
            if(StringUtils.isNotBlank(indexImages.getImageUrl())){
                VALUES("image_url", "#{imageUrl}");
            }
            if(StringUtils.isNotBlank(indexImages.getType())){
                VALUES("type", "#{type}");
            }
            if(StringUtils.isNotBlank(indexImages.getAddress())){
                VALUES("address", "#{address}");
            }
    }}.toString();
    }

    public static String update(final IndexImages indexImages){
        return new SQL(){{
            UPDATE("index_images");

                if(indexImages.getId()!=null && indexImages.getId().toString().length()>0){
                SET("id = #{id}");
            }
                if(StringUtils.isNotBlank(indexImages.getImageUrl())){
                SET("image_url = #{imageUrl}");
            }
                if(StringUtils.isNotBlank(indexImages.getType())){
                SET("type = #{type}");
            }
                if(StringUtils.isNotBlank(indexImages.getAddress())){
                SET("address = #{address}");
            }

                if(indexImages.getId()!=null && indexImages.getId().toString().length()>0){
                WHERE("id = #{id}");
            }
        }}.toString();
    }

    public static String delete(final IndexImages indexImages){
        return new SQL(){{
            DELETE_FROM("index_images");

                if(indexImages.getId()!=null && indexImages.getId().toString().length()>0){
                WHERE("id = #{id}");
            }
                if(StringUtils.isNotBlank(indexImages.getImageUrl())){
                WHERE("image_url = #{imageUrl}");
            }
                if(StringUtils.isNotBlank(indexImages.getType())){
                WHERE("type = #{type}");
            }
                if(StringUtils.isNotBlank(indexImages.getAddress())){
                WHERE("address = #{address}");
            }
        }}.toString();
    }
}
