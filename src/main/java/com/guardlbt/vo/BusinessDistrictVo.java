package com.guardlbt.vo;

import org.springframework.format.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
           
           
/**
* Created by 代码自动生成.
* 时间:2021-08-25 18:06:23
*/
@ApiModel("商圈实体类")
@Data
public class BusinessDistrictVo {

    @ApiModelProperty("店铺编号") 
    private String businessDistrictId;

    @ApiModelProperty("店铺名称") 
    private String name;

    @ApiModelProperty("图片（可以多张）") 
    private String images;

    @ApiModelProperty("省") 
    private String province;

    @ApiModelProperty("市") 
    private String city;

    @ApiModelProperty("县") 
    private String county;

    @ApiModelProperty("区") 
    private String area;

    @ApiModelProperty("详细地址") 
    private String address;

    @ApiModelProperty("经度") 
    private Double longitude;

    @ApiModelProperty("纬度") 
    private Double latitude;

    @ApiModelProperty("店面介绍") 
    private String details;
}
