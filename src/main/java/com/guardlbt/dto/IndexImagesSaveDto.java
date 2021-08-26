package com.guardlbt.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.*;
import lombok.Data;
    
    
/**
* Created by 代码自动生成.
* 时间:2021-08-25 18:06:23
*/
@ApiModel("轮播图实体类")
@Data
public class IndexImagesSaveDto {


    @ApiModelProperty("图片地址") 
    @NotBlank(message = "图片地址不能为空值")
    private String imageUrl;

    @ApiModelProperty("类型（0-店铺 1-代金券 2-网址 ）") 
    @NotBlank(message = "类型（0-店铺 1-代金券 2-网址 ）不能为空值")
    private String type;

    @ApiModelProperty("链接地址") 
    @NotBlank(message = "链接地址不能为空值")
    private String address;
}
