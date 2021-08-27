package com.guardlbt.vo;

import org.springframework.format.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
                    
                 
import java.util.Date;
/**
* Created by 代码自动生成.
* 时间:2021-08-27 13:42:55
*/
@ApiModel("商店实体类")
@Data
public class ShopPageVo {

    @ApiModelProperty(value ="店铺编号")
    private String shopId;

    @ApiModelProperty(value ="店铺名称")
    private String name;

    @ApiModelProperty(value ="logo图片")
    private String logoImage;

    @ApiModelProperty(value ="图片（可以多张）")
    private String images;

    @ApiModelProperty(value ="商圈")
    private String businessDistrictId;

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

    @ApiModelProperty(value ="联系方式")
    private String phone;

    @ApiModelProperty(value ="负责人")
    private String custodian;

    @ApiModelProperty(value ="行业")
    private String profession;

    @ApiModelProperty(value ="店面介绍")
    private String details;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value ="入驻时间")
    private Date createTime;

    @ApiModelProperty(value ="状态（0-未审核 1-已发布 2-已下架）")
    private String status;

    @ApiModelProperty(value ="营业开始时间")
    private String startTime;

    @ApiModelProperty(value ="营业结束时间")
    private String stopTime;
}
