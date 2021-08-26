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
* 时间:2021-08-25 18:06:24
*/
@ApiModel("图片管理实体类")
@Data
public class PictureUpdateDto {

    @ApiModelProperty("") 
    @NotBlank(message = "不能为空值")    private String id;

    @ApiModelProperty("图片访问路径") 
    @NotBlank(message = "图片访问路径不能为空值")    private String url;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty("创建时间") @NotNull(message = "创建时间不能为空值")
    private Date createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty("修改时间") @NotNull(message = "修改时间不能为空值")
    private Date updateTime;

    @ApiModelProperty("是否有缩略图") @NotNull(message = "是否有缩略图不能为空值")
    private Integer isThumbImage;

    @ApiModelProperty("状态（0:弃用，1:在用）") @NotNull(message = "状态（0:弃用，1:在用）不能为空值")
    private Integer status;
}
