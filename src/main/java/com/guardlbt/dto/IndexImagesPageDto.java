package com.guardlbt.dto;

import org.springframework.format.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import javax.validation.constraints.*;

    
    

/**
* Created by 代码自动生成.
* 时间:2021-08-28 11:42:15
*/
@ApiModel("轮播图PageDto")
@Data
public class  IndexImagesPageDto {

    @NotNull(message = "pageNumber不能为空")
    @ApiModelProperty(value = "查询页码（默认值为1）",example = "1")
    private Integer pageNumber;

    @NotNull(message = "pageSize不能为空")
    @ApiModelProperty(value = "每页多少条（默认值为30）",example = "1")
    private Integer pageSize;



    @ApiModelProperty(value ="图片地址")
    private String imageUrl;

    @ApiModelProperty(value ="类型（0-店铺 1-代金券 2-网址 ）")
    private Integer type;

    @ApiModelProperty(value ="链接地址")
    private String address;
}
