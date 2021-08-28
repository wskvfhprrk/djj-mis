package com.guardlbt.dao;

import com.guardlbt.entity.IndexShop;
import org.apache.ibatis.jdbc.SQL;
import org.apache.commons.lang3.StringUtils;

/**
* 首页促销店铺SQL语句
* Created by 代码自动生成.
* 时间:2021-08-28 13:20:39
*/
public class IndexShopDaoSql {

    public static String selectIndexShops(final IndexShop indexShop){
        return new SQL(){{
            SELECT("a.sorting ,a.shop_id");
            FROM("index_shop a");

            if(indexShop!=null && indexShop.getSorting()!=null && indexShop.getSorting().toString().length()>0){
                WHERE("a.Sorting = #{sorting}");
            }            if(indexShop!=null && StringUtils.isNotBlank(indexShop.getShopId())){
                WHERE("a.Shop_id like CONCAT('%',#{shopId},'%')");
            }
        }}.toString();
    }

    public static String insert(final IndexShop indexShop){
        return new SQL(){{
            INSERT_INTO("index_shop");

            if(indexShop.getSorting()!=null && indexShop.getSorting().toString().length()>0){
                VALUES("sorting", "#{sorting}");
            }
            if(StringUtils.isNotBlank(indexShop.getShopId())){
                VALUES("shop_id", "#{shopId}");
            }
    }}.toString();
    }

    public static String update(final IndexShop indexShop){
        return new SQL(){{
            UPDATE("index_shop");

                if(indexShop.getSorting()!=null && indexShop.getSorting().toString().length()>0){
                SET("sorting = #{sorting}");
            }
                if(StringUtils.isNotBlank(indexShop.getShopId())){
                SET("shop_id = #{shopId}");
            }

                if(indexShop.getSorting()!=null && indexShop.getSorting().toString().length()>0){
                WHERE("sorting = #{sorting}");
            }
        }}.toString();
    }

    public static String delete(final IndexShop indexShop){
        return new SQL(){{
            DELETE_FROM("index_shop");

                if(indexShop.getSorting()!=null && indexShop.getSorting().toString().length()>0){
                WHERE("sorting = #{sorting}");
            }
                if(StringUtils.isNotBlank(indexShop.getShopId())){
                WHERE("shop_id = #{shopId}");
            }
        }}.toString();
    }
}
