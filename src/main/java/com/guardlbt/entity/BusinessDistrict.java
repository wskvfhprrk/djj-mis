package com.guardlbt.entity;

import org.springframework.format.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
           
           
           
/**
* Created by 代码自动生成.
* 时间:2021-08-28 11:42:13
*/
@ApiModel("商圈实体类")
@Data
public class BusinessDistrict {

    @ApiModelProperty(value ="店铺编号")
    private String businessDistrictId;

    @ApiModelProperty(value ="店铺名称")
    private String name;

    @ApiModelProperty(value ="图片（可以多张）")
    private String images;

    @ApiModelProperty(value ="省")
    private String province;

    @ApiModelProperty(value ="市")
    private String city;

    @ApiModelProperty(value ="县")
    private String county;

    @ApiModelProperty(value ="区")
    private String area;

    @ApiModelProperty(value ="详细地址")
    private String address;

    @ApiModelProperty(value ="经度")
    private Double longitude;

    @ApiModelProperty(value ="纬度")
    private Double latitude;

    @ApiModelProperty(value ="店面介绍")
    private String details;
}
