package com.guardlbt.entity;

import org.springframework.format.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
      
     
import java.util.Date;
      
/**
* Created by 代码自动生成.
* 时间:2021-08-27 13:42:55
*/
@ApiModel("商品实体类")
@Data
public class Goods {

    @ApiModelProperty(value ="商品编号")
    private String goodsId;

    @ApiModelProperty(value ="名称")
    private String name;

    @ApiModelProperty(value ="店铺编号")
    private String shopId;

    @ApiModelProperty(value ="图片（可以多张）")
    private String images;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value ="创建时间")
    private Date createTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value ="修改时间")
    private Date updateTime;
}
