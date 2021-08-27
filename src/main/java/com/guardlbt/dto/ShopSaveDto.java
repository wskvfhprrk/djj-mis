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
* 时间:2021-08-26 16:20:26
*/
@ApiModel("商店实体类")
@Data
public class ShopSaveDto {


    @ApiModelProperty("店铺名称") 
    @NotBlank(message = "店铺名称不能为空值")
    private String name;

    @ApiModelProperty("logo图片") 
    @NotBlank(message = "logo图片不能为空值")
    private String logoImage;

    @ApiModelProperty("图片（可以多张）") 
    @NotBlank(message = "图片（可以多张）不能为空值")
    private String images;

    @ApiModelProperty("商圈") 
    @NotBlank(message = "商圈不能为空值")
    private String businessDistrictId;

    @ApiModelProperty("省") 
    @NotBlank(message = "省不能为空值")
    private String province;

    @ApiModelProperty("市") 
    @NotBlank(message = "市不能为空值")
    private String city;

    @ApiModelProperty("县") 
    @NotBlank(message = "县不能为空值")
    private String county;

    @ApiModelProperty("区") 
    @NotBlank(message = "区不能为空值")
    private String area;

    @ApiModelProperty("详细地址") 
    @NotBlank(message = "详细地址不能为空值")
    private String address;

    @ApiModelProperty("经度") @NotNull(message = "经度不能为空值")
    private Double longitude;

    @ApiModelProperty("纬度") @NotNull(message = "纬度不能为空值")
    private Double latitude;

    @ApiModelProperty("联系方式") 
    @NotBlank(message = "联系方式不能为空值")
    private String phone;

    @ApiModelProperty("负责人") 
    @NotBlank(message = "负责人不能为空值")
    private String custodian;

    @ApiModelProperty("行业") 
    @NotBlank(message = "行业不能为空值")
    private String profession;

    @ApiModelProperty("店面介绍") 
    @NotBlank(message = "店面介绍不能为空值")
    private String details;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty("入驻时间") @NotNull(message = "入驻时间不能为空值")
    private Date createTime;

    @ApiModelProperty("状态（0-未审核 1-已发布 2-已下架）") 
    @NotBlank(message = "状态（0-未审核 1-已发布 2-已下架）不能为空值")
    private String status;

    @ApiModelProperty("营业开始时间") @NotNull(message = "营业开始时间不能为空值")
    private String startTime;

    @ApiModelProperty("营业结束时间") @NotNull(message = "营业结束时间不能为空值")
    private String stopTime;
}
