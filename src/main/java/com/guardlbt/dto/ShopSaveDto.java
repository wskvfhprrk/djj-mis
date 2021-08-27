package com.guardlbt.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.*;
import lombok.Data;
                    
                 
import java.util.Date;
/**
* Created by 代码自动生成.
* 时间:2021-08-27 13:42:55
*/
@ApiModel("商店实体类")
@Data
public class ShopSaveDto {

    @ApiModelProperty(value ="店铺名称",example = "")
    @NotBlank(message = "店铺名称不能为空值")
    private String name;

    @ApiModelProperty(value ="logo图片",example = "")
    @NotBlank(message = "logo图片不能为空值")
    private String logoImage;

    @ApiModelProperty(value ="图片（可以多张）",example = "")
    @NotBlank(message = "图片（可以多张）不能为空值")
    private String images;

    @ApiModelProperty(value ="商圈",example = "")
    @NotBlank(message = "商圈不能为空值")
    private String businessDistrictId;

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

    @ApiModelProperty(value ="联系方式",example = "")
    @NotBlank(message = "联系方式不能为空值")
    private String phone;

    @ApiModelProperty(value ="负责人",example = "")
    @NotBlank(message = "负责人不能为空值")
    private String custodian;

    @ApiModelProperty(value ="行业",example = "")
    @NotBlank(message = "行业不能为空值")
    private String profession;

    @ApiModelProperty(value ="店面介绍",example = "")
    @NotBlank(message = "店面介绍不能为空值")
    private String details;


    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value ="入驻时间",example = "2000-12-12 10:10:10")
    @NotNull(message = "入驻时间不能为空值")
    private Date createTime;

    @ApiModelProperty(value ="状态（0-未审核 1-已发布 2-已下架）",example = "")
    @NotBlank(message = "状态（0-未审核 1-已发布 2-已下架）不能为空值")
    private String status;

    @ApiModelProperty(value ="营业开始时间",example = "")
    @NotNull(message = "营业开始时间不能为空值")
    private String startTime;

    @ApiModelProperty(value ="营业结束时间",example = "")
    @NotNull(message = "营业结束时间不能为空值")
    private String stopTime;
}
