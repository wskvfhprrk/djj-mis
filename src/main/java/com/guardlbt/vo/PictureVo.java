package com.guardlbt.vo;

import org.springframework.format.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
      
   
import java.util.Date;
/**
* Created by 代码自动生成.
* 时间:2021-08-25 18:06:24
*/
@ApiModel("图片管理实体类")
@Data
public class PictureVo {

    @ApiModelProperty("") 
    private String id;

    @ApiModelProperty("图片访问路径") 
    private String url;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty("创建时间") 
    private Date createTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty("修改时间") 
    private Date updateTime;

    @ApiModelProperty("是否有缩略图") 
    private Integer isThumbImage;

    @ApiModelProperty("状态（0:弃用，1:在用）") 
    private Integer status;
}
