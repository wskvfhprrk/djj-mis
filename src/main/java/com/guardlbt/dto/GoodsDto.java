package com.guardlbt.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author hejz
 * @version 1.0
 * @date 2021/5/27 15:41
 */
@Data
public class GoodsDto {
    @NotNull(message = "pageNumber不能为空") @ApiModelProperty("查询页码（默认值为1）")
    private Integer pageNumber;
    @NotNull(message = "pageSize不能为空") @ApiModelProperty("每页多少条（默认值为30）")
    private Integer pageSize;
    private String name;
}
