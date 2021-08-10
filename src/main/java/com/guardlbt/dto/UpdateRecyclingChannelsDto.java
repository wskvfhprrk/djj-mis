package com.guardlbt.dto;

import javax.validation.constraints.*;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


/**
 * Created by 代码自动生成.
 * 时间:2019-03-27 11:23:20
 */
@Data
public class UpdateRecyclingChannelsDto {
    @NotNull(message = "recyclingChannelsId不能为空")
    @ApiModelProperty("回收渠道ID")
    private Integer recyclingChannelsId;
    @NotBlank(message = "userId不能为空")
    @ApiModelProperty("user_id")
    private String userId;
    @NotBlank(message = "recyclingChannelsName不能为空")
    @ApiModelProperty("回收渠道名称")
    private String recyclingChannelsName;
    @NotNull(message = "recyclingChannelsStatus不能为空")
    @ApiModelProperty("回收渠道状态:0为正常1为锁定")
    private Integer recyclingChannelsStatus;
}
