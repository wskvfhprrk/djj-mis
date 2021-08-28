package com.guardlbt.dto;

import org.springframework.format.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import javax.validation.constraints.*;

      
   
import java.util.Date;

/**
* Created by 代码自动生成.
* 时间:2021-08-28 11:42:19
*/
@ApiModel("图片管理PageDto")
@Data
public class  PicturePageDto {

    @NotNull(message = "pageNumber不能为空")
    @ApiModelProperty(value = "查询页码（默认值为1）",example = "1")
    private Integer pageNumber;

    @NotNull(message = "pageSize不能为空")
    @ApiModelProperty(value = "每页多少条（默认值为30）",example = "1")
    private Integer pageSize;



    @ApiModelProperty(value ="图片访问路径")
    private String url;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value ="创建时间",example = "2000-12-12 10:10:10")
    private Date createTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value ="修改时间",example = "2000-12-12 10:10:10")
    private Date updateTime;

    @ApiModelProperty(value ="是否有缩略图")
    private Integer isThumbImage;

    @ApiModelProperty(value ="状态（0:弃用，1:在用）")
    private Integer status;
}
