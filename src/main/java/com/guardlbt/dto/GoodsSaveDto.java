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
* 时间:2021-08-26 16:20:27
*/
@ApiModel("商品实体类")
@Data
public class GoodsSaveDto {


    @ApiModelProperty("名称") 
    @NotBlank(message = "名称不能为空值")
    private String name;

    @ApiModelProperty("店铺编号") 
    @NotBlank(message = "店铺编号不能为空值")
    private String shopId;

    @ApiModelProperty("图片（可以多张）") 
    @NotBlank(message = "图片（可以多张）不能为空值")
    private String images;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty("创建时间") @NotNull(message = "创建时间不能为空值")
    private Date createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty("修改时间") @NotNull(message = "修改时间不能为空值")
    private Date updateTime;
}
