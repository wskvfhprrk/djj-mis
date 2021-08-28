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
@ApiModel("首页促销代金券PageDto")
@Data
public class  IndexCouponPageDto {

    @NotNull(message = "pageNumber不能为空")
    @ApiModelProperty(value = "查询页码（默认值为1）",example = "1")
    private Integer pageNumber;

    @NotNull(message = "pageSize不能为空")
    @ApiModelProperty(value = "每页多少条（默认值为30）",example = "1")
    private Integer pageSize;



    @ApiModelProperty(value ="代金券编号")
    private String couponId;
}
