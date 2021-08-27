package com.guardlbt.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.*;
import lombok.Data;
           
           
/**
* Created by 代码自动生成.
* 时间:2021-08-27 13:42:55
*/
@ApiModel("商圈实体类")
@Data
public class BusinessDistrictSaveDto {

    @ApiModelProperty(value ="店铺名称",example = "")
    @NotBlank(message = "店铺名称不能为空值")
    private String name;

    @ApiModelProperty(value ="图片（可以多张）",example = "")
    @NotBlank(message = "图片（可以多张）不能为空值")
    private String images;

    @ApiModelProperty(value ="省",example = "")
    @NotBlank(message = "省不能为空值")
    private String province;

    @ApiModelProperty(value ="市",example = "")
    @NotBlank(message = "市不能为空值")
    private String city;

    @ApiModelProperty(value ="县",example = "")
    @NotBlank(message = "县不能为空值")
    private String county;

    @ApiModelProperty(value ="区",example = "")
    @NotBlank(message = "区不能为空值")
    private String area;

    @ApiModelProperty(value ="详细地址",example = "")
    @NotBlank(message = "详细地址不能为空值")
    private String address;

    @ApiModelProperty(value ="经度",example = "")
    @NotNull(message = "经度不能为空值")
    private Double longitude;

    @ApiModelProperty(value ="纬度",example = "")
    @NotNull(message = "纬度不能为空值")
    private Double latitude;

    @ApiModelProperty(value ="店面介绍",example = "")
    @NotBlank(message = "店面介绍不能为空值")
    private String details;
}
