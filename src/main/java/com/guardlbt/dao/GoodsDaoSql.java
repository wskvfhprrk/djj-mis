package com.guardlbt.dao;

import com.guardlbt.entity.Goods;
import org.apache.ibatis.jdbc.SQL;
import org.apache.commons.lang3.StringUtils;

/**
* 商品SQL语句
* Created by 代码自动生成.
* 时间:2021-08-28 13:20:39
*/
public class GoodsDaoSql {

    public static String selectGoodss(final Goods goods){
        return new SQL(){{
            SELECT("a.goods_id ,a.name ,a.shop_id ,a.images ,a.create_time ,a.update_time");
            FROM("goods a");
            if(goods!=null && StringUtils.isNotBlank(goods.getGoodsId())){
                WHERE("a.Goods_id like CONCAT('%',#{goodsId},'%')");
            }            if(goods!=null && StringUtils.isNotBlank(goods.getName())){
                WHERE("a.Name like CONCAT('%',#{name},'%')");
            }            if(goods!=null && StringUtils.isNotBlank(goods.getShopId())){
                WHERE("a.Shop_id like CONCAT('%',#{shopId},'%')");
            }            if(goods!=null && StringUtils.isNotBlank(goods.getImages())){
                WHERE("a.Images like CONCAT('%',#{images},'%')");
            }
            if(goods!=null && goods.getCreateTime()!=null && goods.getCreateTime().toString().length()>0){
                WHERE("a.Create_time = #{createTime}");
            }
            if(goods!=null && goods.getUpdateTime()!=null && goods.getUpdateTime().toString().length()>0){
                WHERE("a.Update_time = #{updateTime}");
            }
        }}.toString();
    }

    public static String insert(final Goods goods){
        return new SQL(){{
            INSERT_INTO("goods");
            if(StringUtils.isNotBlank(goods.getGoodsId())){
                VALUES("goods_id", "#{goodsId}");
            }
            if(StringUtils.isNotBlank(goods.getName())){
                VALUES("name", "#{name}");
            }
            if(StringUtils.isNotBlank(goods.getShopId())){
                VALUES("shop_id", "#{shopId}");
            }
            if(StringUtils.isNotBlank(goods.getImages())){
                VALUES("images", "#{images}");
            }

            if(goods.getCreateTime()!=null && goods.getCreateTime().toString().length()>0){
                VALUES("create_time", "#{createTime}");
            }

            if(goods.getUpdateTime()!=null && goods.getUpdateTime().toString().length()>0){
                VALUES("update_time", "#{updateTime}");
            }
    }}.toString();
    }

    public static String update(final Goods goods){
        return new SQL(){{
            UPDATE("goods");
                if(StringUtils.isNotBlank(goods.getGoodsId())){
                SET("goods_id = #{goodsId}");
            }
                if(StringUtils.isNotBlank(goods.getName())){
                SET("name = #{name}");
            }
                if(StringUtils.isNotBlank(goods.getShopId())){
                SET("shop_id = #{shopId}");
            }
                if(StringUtils.isNotBlank(goods.getImages())){
                SET("images = #{images}");
            }

                if(goods.getCreateTime()!=null && goods.getCreateTime().toString().length()>0){
                SET("create_time = #{createTime}");
            }

                if(goods.getUpdateTime()!=null && goods.getUpdateTime().toString().length()>0){
                SET("update_time = #{updateTime}");
            }
                if(StringUtils.isNotBlank(goods.getGoodsId())){
                WHERE("goods_id = #{goodsId}");
            }
        }}.toString();
    }

    public static String delete(final Goods goods){
        return new SQL(){{
            DELETE_FROM("goods");
                if(StringUtils.isNotBlank(goods.getGoodsId())){
                WHERE("goods_id = #{goodsId}");
            }
                if(StringUtils.isNotBlank(goods.getName())){
                WHERE("name = #{name}");
            }
                if(StringUtils.isNotBlank(goods.getShopId())){
                WHERE("shop_id = #{shopId}");
            }
                if(StringUtils.isNotBlank(goods.getImages())){
                WHERE("images = #{images}");
            }

                if(goods.getCreateTime()!=null && goods.getCreateTime().toString().length()>0){
                WHERE("create_time = #{createTime}");
            }

                if(goods.getUpdateTime()!=null && goods.getUpdateTime().toString().length()>0){
                WHERE("update_time = #{updateTime}");
            }
        }}.toString();
    }
}
