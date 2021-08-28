package com.guardlbt.dto;

import org.springframework.format.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import javax.validation.constraints.*;

           
           

/**
* Created by 代码自动生成.
* 时间:2021-08-28 11:42:13
*/
@ApiModel("商圈PageDto")
@Data
public class  BusinessDistrictPageDto {

    @NotNull(message = "pageNumber不能为空")
    @ApiModelProperty(value = "查询页码（默认值为1）",example = "1")
    private Integer pageNumber;

    @NotNull(message = "pageSize不能为空")
    @ApiModelProperty(value = "每页多少条（默认值为30）",example = "1")
    private Integer pageSize;



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
