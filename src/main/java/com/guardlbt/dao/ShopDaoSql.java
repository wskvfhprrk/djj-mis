package com.guardlbt.dao;

import com.guardlbt.entity.Shop;
import org.apache.ibatis.jdbc.SQL;
import org.apache.commons.lang3.StringUtils;

/**
* 商店SQL语句
* Created by 代码自动生成.
* 时间:2021-08-26 16:20:26
*/
public class ShopDaoSql {

    public static String selectShops(final Shop shop){
        return new SQL(){{
            SELECT("a.shop_id ,a.name ,a.logo_image ,a.images ,a.business_district_id ,a.province ,a.city ,a.county ,a.area ,a.address ,a.longitude ,a.latitude ,a.phone ,a.custodian ,a.profession ,a.details ,a.create_time ,a.status ,a.start_time ,a.stop_time");
            FROM("shop a");
            if(shop!=null && StringUtils.isNotBlank(shop.getShopId())){
                WHERE("a.Shop_id like CONCAT('%',#{shopId},'%')");
            }            if(shop!=null && StringUtils.isNotBlank(shop.getName())){
                WHERE("a.Name like CONCAT('%',#{name},'%')");
            }            if(shop!=null && StringUtils.isNotBlank(shop.getLogoImage())){
                WHERE("a.Logo_image like CONCAT('%',#{logoImage},'%')");
            }            if(shop!=null && StringUtils.isNotBlank(shop.getImages())){
                WHERE("a.Images like CONCAT('%',#{images},'%')");
            }            if(shop!=null && StringUtils.isNotBlank(shop.getBusinessDistrictId())){
                WHERE("a.Business_district_id like CONCAT('%',#{businessDistrictId},'%')");
            }            if(shop!=null && StringUtils.isNotBlank(shop.getProvince())){
                WHERE("a.Province like CONCAT('%',#{province},'%')");
            }            if(shop!=null && StringUtils.isNotBlank(shop.getCity())){
                WHERE("a.City like CONCAT('%',#{city},'%')");
            }            if(shop!=null && StringUtils.isNotBlank(shop.getCounty())){
                WHERE("a.County like CONCAT('%',#{county},'%')");
            }            if(shop!=null && StringUtils.isNotBlank(shop.getArea())){
                WHERE("a.Area like CONCAT('%',#{area},'%')");
            }            if(shop!=null && StringUtils.isNotBlank(shop.getAddress())){
                WHERE("a.Address like CONCAT('%',#{address},'%')");
            }
            if(shop!=null && shop.getLongitude()!=null && shop.getLongitude().toString().length()>0){
                WHERE("a.Longitude = #{longitude}");
            }
            if(shop!=null && shop.getLatitude()!=null && shop.getLatitude().toString().length()>0){
                WHERE("a.Latitude = #{latitude}");
            }            if(shop!=null && StringUtils.isNotBlank(shop.getPhone())){
                WHERE("a.Phone like CONCAT('%',#{phone},'%')");
            }            if(shop!=null && StringUtils.isNotBlank(shop.getCustodian())){
                WHERE("a.Custodian like CONCAT('%',#{custodian},'%')");
            }            if(shop!=null && StringUtils.isNotBlank(shop.getProfession())){
                WHERE("a.Profession like CONCAT('%',#{profession},'%')");
            }            if(shop!=null && StringUtils.isNotBlank(shop.getDetails())){
                WHERE("a.Details like CONCAT('%',#{details},'%')");
            }
            if(shop!=null && shop.getCreateTime()!=null && shop.getCreateTime().toString().length()>0){
                WHERE("a.Create_time = #{createTime}");
            }            if(shop!=null && StringUtils.isNotBlank(shop.getStatus())){
                WHERE("a.Status like CONCAT('%',#{status},'%')");
            }
            if(shop!=null && shop.getStartTime()!=null && shop.getStartTime().toString().length()>0){
                WHERE("a.Start_time = #{startTime}");
            }
            if(shop!=null && shop.getStopTime()!=null && shop.getStopTime().toString().length()>0){
                WHERE("a.Stop_time = #{stopTime}");
            }
        }}.toString();
    }

    public static String insert(final Shop shop){
        return new SQL(){{
            INSERT_INTO("shop");
            if(StringUtils.isNotBlank(shop.getShopId())){
                VALUES("shop_id", "#{shopId}");
            }
            if(StringUtils.isNotBlank(shop.getName())){
                VALUES("name", "#{name}");
            }
            if(StringUtils.isNotBlank(shop.getLogoImage())){
                VALUES("logo_image", "#{logoImage}");
            }
            if(StringUtils.isNotBlank(shop.getImages())){
                VALUES("images", "#{images}");
            }
            if(StringUtils.isNotBlank(shop.getBusinessDistrictId())){
                VALUES("business_district_id", "#{businessDistrictId}");
            }
            if(StringUtils.isNotBlank(shop.getProvince())){
                VALUES("province", "#{province}");
            }
            if(StringUtils.isNotBlank(shop.getCity())){
                VALUES("city", "#{city}");
            }
            if(StringUtils.isNotBlank(shop.getCounty())){
                VALUES("county", "#{county}");
            }
            if(StringUtils.isNotBlank(shop.getArea())){
                VALUES("area", "#{area}");
            }
            if(StringUtils.isNotBlank(shop.getAddress())){
                VALUES("address", "#{address}");
            }

            if(shop.getLongitude()!=null && shop.getLongitude().toString().length()>0){
                VALUES("longitude", "#{longitude}");
            }

            if(shop.getLatitude()!=null && shop.getLatitude().toString().length()>0){
                VALUES("latitude", "#{latitude}");
            }
            if(StringUtils.isNotBlank(shop.getPhone())){
                VALUES("phone", "#{phone}");
            }
            if(StringUtils.isNotBlank(shop.getCustodian())){
                VALUES("custodian", "#{custodian}");
            }
            if(StringUtils.isNotBlank(shop.getProfession())){
                VALUES("profession", "#{profession}");
            }
            if(StringUtils.isNotBlank(shop.getDetails())){
                VALUES("details", "#{details}");
            }

            if(shop.getCreateTime()!=null && shop.getCreateTime().toString().length()>0){
                VALUES("create_time", "#{createTime}");
            }
            if(StringUtils.isNotBlank(shop.getStatus())){
                VALUES("status", "#{status}");
            }

            if(shop.getStartTime()!=null && shop.getStartTime().toString().length()>0){
                VALUES("start_time", "#{startTime}");
            }

            if(shop.getStopTime()!=null && shop.getStopTime().toString().length()>0){
                VALUES("stop_time", "#{stopTime}");
            }
    }}.toString();
    }

    public static String update(final Shop shop){
        return new SQL(){{
            UPDATE("shop");
                if(StringUtils.isNotBlank(shop.getShopId())){
                SET("shop_id = #{shopId}");
            }
                if(StringUtils.isNotBlank(shop.getName())){
                SET("name = #{name}");
            }
                if(StringUtils.isNotBlank(shop.getLogoImage())){
                SET("logo_image = #{logoImage}");
            }
                if(StringUtils.isNotBlank(shop.getImages())){
                SET("images = #{images}");
            }
                if(StringUtils.isNotBlank(shop.getBusinessDistrictId())){
                SET("business_district_id = #{businessDistrictId}");
            }
                if(StringUtils.isNotBlank(shop.getProvince())){
                SET("province = #{province}");
            }
                if(StringUtils.isNotBlank(shop.getCity())){
                SET("city = #{city}");
            }
                if(StringUtils.isNotBlank(shop.getCounty())){
                SET("county = #{county}");
            }
                if(StringUtils.isNotBlank(shop.getArea())){
                SET("area = #{area}");
            }
                if(StringUtils.isNotBlank(shop.getAddress())){
                SET("address = #{address}");
            }

                if(shop.getLongitude()!=null && shop.getLongitude().toString().length()>0){
                SET("longitude = #{longitude}");
            }

                if(shop.getLatitude()!=null && shop.getLatitude().toString().length()>0){
                SET("latitude = #{latitude}");
            }
                if(StringUtils.isNotBlank(shop.getPhone())){
                SET("phone = #{phone}");
            }
                if(StringUtils.isNotBlank(shop.getCustodian())){
                SET("custodian = #{custodian}");
            }
                if(StringUtils.isNotBlank(shop.getProfession())){
                SET("profession = #{profession}");
            }
                if(StringUtils.isNotBlank(shop.getDetails())){
                SET("details = #{details}");
            }

                if(shop.getCreateTime()!=null && shop.getCreateTime().toString().length()>0){
                SET("create_time = #{createTime}");
            }
                if(StringUtils.isNotBlank(shop.getStatus())){
                SET("status = #{status}");
            }

                if(shop.getStartTime()!=null && shop.getStartTime().toString().length()>0){
                SET("start_time = #{startTime}");
            }

                if(shop.getStopTime()!=null && shop.getStopTime().toString().length()>0){
                SET("stop_time = #{stopTime}");
            }
                if(StringUtils.isNotBlank(shop.getShopId())){
                WHERE("shop_id = #{shopId}");
            }
        }}.toString();
    }

    public static String delete(final Shop shop){
        return new SQL(){{
            DELETE_FROM("shop");
                if(StringUtils.isNotBlank(shop.getShopId())){
                WHERE("shop_id = #{shopId}");
            }
                if(StringUtils.isNotBlank(shop.getName())){
                WHERE("name = #{name}");
            }
                if(StringUtils.isNotBlank(shop.getLogoImage())){
                WHERE("logo_image = #{logoImage}");
            }
                if(StringUtils.isNotBlank(shop.getImages())){
                WHERE("images = #{images}");
            }
                if(StringUtils.isNotBlank(shop.getBusinessDistrictId())){
                WHERE("business_district_id = #{businessDistrictId}");
            }
                if(StringUtils.isNotBlank(shop.getProvince())){
                WHERE("province = #{province}");
            }
                if(StringUtils.isNotBlank(shop.getCity())){
                WHERE("city = #{city}");
            }
                if(StringUtils.isNotBlank(shop.getCounty())){
                WHERE("county = #{county}");
            }
                if(StringUtils.isNotBlank(shop.getArea())){
                WHERE("area = #{area}");
            }
                if(StringUtils.isNotBlank(shop.getAddress())){
                WHERE("address = #{address}");
            }

                if(shop.getLongitude()!=null && shop.getLongitude().toString().length()>0){
                WHERE("longitude = #{longitude}");
            }

                if(shop.getLatitude()!=null && shop.getLatitude().toString().length()>0){
                WHERE("latitude = #{latitude}");
            }
                if(StringUtils.isNotBlank(shop.getPhone())){
                WHERE("phone = #{phone}");
            }
                if(StringUtils.isNotBlank(shop.getCustodian())){
                WHERE("custodian = #{custodian}");
            }
                if(StringUtils.isNotBlank(shop.getProfession())){
                WHERE("profession = #{profession}");
            }
                if(StringUtils.isNotBlank(shop.getDetails())){
                WHERE("details = #{details}");
            }

                if(shop.getCreateTime()!=null && shop.getCreateTime().toString().length()>0){
                WHERE("create_time = #{createTime}");
            }
                if(StringUtils.isNotBlank(shop.getStatus())){
                WHERE("status = #{status}");
            }

                if(shop.getStartTime()!=null && shop.getStartTime().toString().length()>0){
                WHERE("start_time = #{startTime}");
            }

                if(shop.getStopTime()!=null && shop.getStopTime().toString().length()>0){
                WHERE("stop_time = #{stopTime}");
            }
        }}.toString();
    }
}
