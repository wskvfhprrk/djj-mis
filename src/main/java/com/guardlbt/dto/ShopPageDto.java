package com.guardlbt.dto;

import org.springframework.format.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import javax.validation.constraints.*;

                    
                 
import java.util.Date;

/**
* Created by 代码自动生成.
* 时间:2021-08-28 11:42:13
*/
@ApiModel("商店PageDto")
@Data
public class  ShopPageDto {

    @NotNull(message = "pageNumber不能为空")
    @ApiModelProperty(value = "查询页码（默认值为1）",example = "1")
    private Integer pageNumber;

    @NotNull(message = "pageSize不能为空")
    @ApiModelProperty(value = "每页多少条（默认值为30）",example = "1")
    private Integer pageSize;



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
    @ApiModelProperty(value ="入驻时间",example = "2000-12-12 10:10:10")
    private Date createTime;

    @ApiModelProperty(value ="状态（0-未审核 1-已发布 2-已下架）")
    private Integer status;

    @ApiModelProperty(value ="营业开始时间")
    private String startTime;

    @ApiModelProperty(value ="营业结束时间")
    private String stopTime;
}
