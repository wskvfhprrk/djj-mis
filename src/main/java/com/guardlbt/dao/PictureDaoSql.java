package com.guardlbt.dao;

import com.guardlbt.entity.Picture;
import org.apache.ibatis.jdbc.SQL;
import org.apache.commons.lang3.StringUtils;

/**
* 图片管理SQL语句
* Created by 代码自动生成.
* 时间:2021-08-28 13:20:40
*/
public class PictureDaoSql {

    public static String selectPictures(final Picture picture){
        return new SQL(){{
            SELECT("a.id ,a.url ,a.create_time ,a.update_time ,a.is_thumb_image ,a.status");
            FROM("picture a");
            if(picture!=null && StringUtils.isNotBlank(picture.getId())){
                WHERE("a.Id like CONCAT('%',#{id},'%')");
            }            if(picture!=null && StringUtils.isNotBlank(picture.getUrl())){
                WHERE("a.Url like CONCAT('%',#{url},'%')");
            }
            if(picture!=null && picture.getCreateTime()!=null && picture.getCreateTime().toString().length()>0){
                WHERE("a.Create_time = #{createTime}");
            }
            if(picture!=null && picture.getUpdateTime()!=null && picture.getUpdateTime().toString().length()>0){
                WHERE("a.Update_time = #{updateTime}");
            }
            if(picture!=null && picture.getIsThumbImage()!=null && picture.getIsThumbImage().toString().length()>0){
                WHERE("a.Is_thumb_image = #{isThumbImage}");
            }
            if(picture!=null && picture.getStatus()!=null && picture.getStatus().toString().length()>0){
                WHERE("a.Status = #{status}");
            }
        }}.toString();
    }

    public static String insert(final Picture picture){
        return new SQL(){{
            INSERT_INTO("picture");
            if(StringUtils.isNotBlank(picture.getId())){
                VALUES("id", "#{id}");
            }
            if(StringUtils.isNotBlank(picture.getUrl())){
                VALUES("url", "#{url}");
            }

            if(picture.getCreateTime()!=null && picture.getCreateTime().toString().length()>0){
                VALUES("create_time", "#{createTime}");
            }

            if(picture.getUpdateTime()!=null && picture.getUpdateTime().toString().length()>0){
                VALUES("update_time", "#{updateTime}");
            }

            if(picture.getIsThumbImage()!=null && picture.getIsThumbImage().toString().length()>0){
                VALUES("is_thumb_image", "#{isThumbImage}");
            }

            if(picture.getStatus()!=null && picture.getStatus().toString().length()>0){
                VALUES("status", "#{status}");
            }
    }}.toString();
    }

    public static String update(final Picture picture){
        return new SQL(){{
            UPDATE("picture");
                if(StringUtils.isNotBlank(picture.getId())){
                SET("id = #{id}");
            }
                if(StringUtils.isNotBlank(picture.getUrl())){
                SET("url = #{url}");
            }

                if(picture.getCreateTime()!=null && picture.getCreateTime().toString().length()>0){
                SET("create_time = #{createTime}");
            }

                if(picture.getUpdateTime()!=null && picture.getUpdateTime().toString().length()>0){
                SET("update_time = #{updateTime}");
            }

                if(picture.getIsThumbImage()!=null && picture.getIsThumbImage().toString().length()>0){
                SET("is_thumb_image = #{isThumbImage}");
            }

                if(picture.getStatus()!=null && picture.getStatus().toString().length()>0){
                SET("status = #{status}");
            }
                if(StringUtils.isNotBlank(picture.getId())){
                WHERE("id = #{id}");
            }
        }}.toString();
    }

    public static String delete(final Picture picture){
        return new SQL(){{
            DELETE_FROM("picture");
                if(StringUtils.isNotBlank(picture.getId())){
                WHERE("id = #{id}");
            }
                if(StringUtils.isNotBlank(picture.getUrl())){
                WHERE("url = #{url}");
            }

                if(picture.getCreateTime()!=null && picture.getCreateTime().toString().length()>0){
                WHERE("create_time = #{createTime}");
            }

                if(picture.getUpdateTime()!=null && picture.getUpdateTime().toString().length()>0){
                WHERE("update_time = #{updateTime}");
            }

                if(picture.getIsThumbImage()!=null && picture.getIsThumbImage().toString().length()>0){
                WHERE("is_thumb_image = #{isThumbImage}");
            }

                if(picture.getStatus()!=null && picture.getStatus().toString().length()>0){
                WHERE("status = #{status}");
            }
        }}.toString();
    }
}
