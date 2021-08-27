package com.guardlbt.dto;

import org.springframework.format.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import javax.validation.constraints.*;

      
     
import java.util.Date;

/**
* Created by 代码自动生成.
* 时间:2021-08-26 16:20:27
*/
@ApiModel("商品PageDto")
@Data
public class  GoodsPageDto {

    @NotNull(message = "pageNumber不能为空")
    @ApiModelProperty("查询页码（默认值为1）")
    private Integer pageNumber;

    @NotNull(message = "pageSize不能为空")
    @ApiModelProperty("每页多少条（默认值为30）")
    private Integer pageSize;


    @ApiModelProperty("名称") 
    private String name;

    @ApiModelProperty("店铺编号") 
    private String shopId;

    @ApiModelProperty("图片（可以多张）") 
    private String images;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty("创建时间") 
    private Date createTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty("修改时间") 
    private Date updateTime;
}