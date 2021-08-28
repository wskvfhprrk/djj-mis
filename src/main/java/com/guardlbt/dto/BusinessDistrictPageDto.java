package com.guardlbt.dto;

import org.springframework.format.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import javax.validation.constraints.*;

           
           
/**
* Created by 代码自动生成.
* 时间:2021-08-28 13:20:38
*/
@ApiModel("商圈PageDto")
@Data
public class  BusinessDistrictPageDto {

    @NotNull(message = "pageNumber不能为空")
    @ApiModelProperty("查询页码（默认值为1）")
    private Integer pageNumber;

    @NotNull(message = "pageSize不能为空")
    @ApiModelProperty("每页多少条（默认值为30）")
    private Integer pageSize;


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
