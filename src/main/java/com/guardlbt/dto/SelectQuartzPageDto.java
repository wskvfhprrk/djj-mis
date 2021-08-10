package com.guardlbt.dto;

import javax.validation.constraints.*;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


/**
 * Created by 代码自动生成.
 * 时间:2019-04-01 13:00:57
 */
@Data
public class SelectQuartzPageDto {
@NotNull(message = "pageNumber不能为空") @ApiModelProperty("查询页码")
    private Integer pageNumber;
@NotNull(message = "pageSize不能为空") @ApiModelProperty("每页多少条")
    private Integer pageSize;
@ApiModelProperty("模糊查询")
    private String name;
}
