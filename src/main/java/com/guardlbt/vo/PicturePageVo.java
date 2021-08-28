package com.guardlbt.vo;

import org.springframework.format.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
      
   
import java.util.Date;
/**
* Created by 代码自动生成.
* 时间:2021-08-28 11:42:19
*/
@ApiModel("图片管理实体类")
@Data
public class PicturePageVo {

    @ApiModelProperty(value ="")
    private String id;

    @ApiModelProperty(value ="图片访问路径")
    private String url;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value ="创建时间")
    private Date createTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value ="修改时间")
    private Date updateTime;

    @ApiModelProperty(value ="是否有缩略图")
    private Integer isThumbImage;

    @ApiModelProperty(value ="状态（0:弃用，1:在用）")
    private Integer status;
}
