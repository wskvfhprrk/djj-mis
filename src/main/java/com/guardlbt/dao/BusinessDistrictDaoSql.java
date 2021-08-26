package com.guardlbt.dao;

import com.guardlbt.entity.BusinessDistrict;
import org.apache.ibatis.jdbc.SQL;
import org.apache.commons.lang3.StringUtils;

/**
* 商圈SQL语句
* Created by 代码自动生成.
* 时间:2021-08-25 18:06:23
*/
public class BusinessDistrictDaoSql {

    public static String selectBusinessDistricts(final BusinessDistrict businessDistrict){
        return new SQL(){{
            SELECT("a.business_district_id ,a.name ,a.images ,a.province ,a.city ,a.county ,a.area ,a.address ,a.longitude ,a.latitude ,a.details");
            FROM("business_district a");
            if(businessDistrict!=null && StringUtils.isNotBlank(businessDistrict.getBusinessDistrictId())){
                WHERE("a.Business_district_id like CONCAT('%',#{businessDistrictId},'%')");
            }            if(businessDistrict!=null && StringUtils.isNotBlank(businessDistrict.getName())){
                WHERE("a.Name like CONCAT('%',#{name},'%')");
            }            if(businessDistrict!=null && StringUtils.isNotBlank(businessDistrict.getImages())){
                WHERE("a.Images like CONCAT('%',#{images},'%')");
            }            if(businessDistrict!=null && StringUtils.isNotBlank(businessDistrict.getProvince())){
                WHERE("a.Province like CONCAT('%',#{province},'%')");
            }            if(businessDistrict!=null && StringUtils.isNotBlank(businessDistrict.getCity())){
                WHERE("a.City like CONCAT('%',#{city},'%')");
            }            if(businessDistrict!=null && StringUtils.isNotBlank(businessDistrict.getCounty())){
                WHERE("a.County like CONCAT('%',#{county},'%')");
            }            if(businessDistrict!=null && StringUtils.isNotBlank(businessDistrict.getArea())){
                WHERE("a.Area like CONCAT('%',#{area},'%')");
            }            if(businessDistrict!=null && StringUtils.isNotBlank(businessDistrict.getAddress())){
                WHERE("a.Address like CONCAT('%',#{address},'%')");
            }
            if(businessDistrict!=null && businessDistrict.getLongitude()!=null && businessDistrict.getLongitude().toString().length()>0){
                WHERE("a.Longitude = #{longitude}");
            }
            if(businessDistrict!=null && businessDistrict.getLatitude()!=null && businessDistrict.getLatitude().toString().length()>0){
                WHERE("a.Latitude = #{latitude}");
            }            if(businessDistrict!=null && StringUtils.isNotBlank(businessDistrict.getDetails())){
                WHERE("a.Details like CONCAT('%',#{details},'%')");
            }
        }}.toString();
    }

    public static String insert(final BusinessDistrict businessDistrict){
        return new SQL(){{
            INSERT_INTO("business_district");
            if(StringUtils.isNotBlank(businessDistrict.getBusinessDistrictId())){
                VALUES("business_district_id", "#{businessDistrictId}");
            }
            if(StringUtils.isNotBlank(businessDistrict.getName())){
                VALUES("name", "#{name}");
            }
            if(StringUtils.isNotBlank(businessDistrict.getImages())){
                VALUES("images", "#{images}");
            }
            if(StringUtils.isNotBlank(businessDistrict.getProvince())){
                VALUES("province", "#{province}");
            }
            if(StringUtils.isNotBlank(businessDistrict.getCity())){
                VALUES("city", "#{city}");
            }
            if(StringUtils.isNotBlank(businessDistrict.getCounty())){
                VALUES("county", "#{county}");
            }
            if(StringUtils.isNotBlank(businessDistrict.getArea())){
                VALUES("area", "#{area}");
            }
            if(StringUtils.isNotBlank(businessDistrict.getAddress())){
                VALUES("address", "#{address}");
            }

            if(businessDistrict.getLongitude()!=null && businessDistrict.getLongitude().toString().length()>0){
                VALUES("longitude", "#{longitude}");
            }

            if(businessDistrict.getLatitude()!=null && businessDistrict.getLatitude().toString().length()>0){
                VALUES("latitude", "#{latitude}");
            }
            if(StringUtils.isNotBlank(businessDistrict.getDetails())){
                VALUES("details", "#{details}");
            }
    }}.toString();
    }

    public static String update(final BusinessDistrict businessDistrict){
        return new SQL(){{
            UPDATE("business_district");
                if(StringUtils.isNotBlank(businessDistrict.getBusinessDistrictId())){
                SET("business_district_id = #{businessDistrictId}");
            }
                if(StringUtils.isNotBlank(businessDistrict.getName())){
                SET("name = #{name}");
            }
                if(StringUtils.isNotBlank(businessDistrict.getImages())){
                SET("images = #{images}");
            }
                if(StringUtils.isNotBlank(businessDistrict.getProvince())){
                SET("province = #{province}");
            }
                if(StringUtils.isNotBlank(businessDistrict.getCity())){
                SET("city = #{city}");
            }
                if(StringUtils.isNotBlank(businessDistrict.getCounty())){
                SET("county = #{county}");
            }
                if(StringUtils.isNotBlank(businessDistrict.getArea())){
                SET("area = #{area}");
            }
                if(StringUtils.isNotBlank(businessDistrict.getAddress())){
                SET("address = #{address}");
            }

                if(businessDistrict.getLongitude()!=null && businessDistrict.getLongitude().toString().length()>0){
                SET("longitude = #{longitude}");
            }

                if(businessDistrict.getLatitude()!=null && businessDistrict.getLatitude().toString().length()>0){
                SET("latitude = #{latitude}");
            }
                if(StringUtils.isNotBlank(businessDistrict.getDetails())){
                SET("details = #{details}");
            }
                if(StringUtils.isNotBlank(businessDistrict.getBusinessDistrictId())){
                WHERE("business_district_id = #{businessDistrictId}");
            }
        }}.toString();
    }

    public static String delete(final BusinessDistrict businessDistrict){
        return new SQL(){{
            DELETE_FROM("business_district");
                if(StringUtils.isNotBlank(businessDistrict.getBusinessDistrictId())){
                WHERE("business_district_id = #{businessDistrictId}");
            }
                if(StringUtils.isNotBlank(businessDistrict.getName())){
                WHERE("name = #{name}");
            }
                if(StringUtils.isNotBlank(businessDistrict.getImages())){
                WHERE("images = #{images}");
            }
                if(StringUtils.isNotBlank(businessDistrict.getProvince())){
                WHERE("province = #{province}");
            }
                if(StringUtils.isNotBlank(businessDistrict.getCity())){
                WHERE("city = #{city}");
            }
                if(StringUtils.isNotBlank(businessDistrict.getCounty())){
                WHERE("county = #{county}");
            }
                if(StringUtils.isNotBlank(businessDistrict.getArea())){
                WHERE("area = #{area}");
            }
                if(StringUtils.isNotBlank(businessDistrict.getAddress())){
                WHERE("address = #{address}");
            }

                if(businessDistrict.getLongitude()!=null && businessDistrict.getLongitude().toString().length()>0){
                WHERE("longitude = #{longitude}");
            }

                if(businessDistrict.getLatitude()!=null && businessDistrict.getLatitude().toString().length()>0){
                WHERE("latitude = #{latitude}");
            }
                if(StringUtils.isNotBlank(businessDistrict.getDetails())){
                WHERE("details = #{details}");
            }
        }}.toString();
    }
}
