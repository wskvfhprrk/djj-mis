package com.guardlbt.vo;

import org.springframework.format.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
    
    
/**
* Created by 代码自动生成.
* 时间:2021-08-28 13:20:39
*/
@ApiModel("轮播图实体类")
@Data
public class IndexImagesVo {

    @ApiModelProperty(value="序号")
    private Integer id;

    @ApiModelProperty(value="图片地址")
    private String imageUrl;

    @ApiModelProperty(value="类型（0-店铺 1-代金券 2-网址 ）")
    private Integer type;

    @ApiModelProperty(value="链接地址")
    private String address;
}
