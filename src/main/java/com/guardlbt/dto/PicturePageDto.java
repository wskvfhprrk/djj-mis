package com.guardlbt.dto;

import org.springframework.format.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import javax.validation.constraints.*;

      
   
import java.util.Date;
/**
* Created by 代码自动生成.
* 时间:2021-08-28 13:20:40
*/
@ApiModel("图片管理PageDto")
@Data
public class  PicturePageDto {

    @NotNull(message = "pageNumber不能为空")
    @ApiModelProperty("查询页码（默认值为1）")
    private Integer pageNumber;

    @NotNull(message = "pageSize不能为空")
    @ApiModelProperty("每页多少条（默认值为30）")
    private Integer pageSize;


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
