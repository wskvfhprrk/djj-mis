package com.guardlbt.dto;

import javax.validation.constraints.*;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


/**
 * Created by 代码自动生成.
 * 时间:2019-03-25 16:51:41
 */
@Data
public class SaveDeptDto {
@NotBlank(message = "deptName不能为空") @ApiModelProperty("部门名称")
    private String deptName;
@NotNull(message = "pId不能为空") @ApiModelProperty("如果没有填写0")
    private Integer pId;
}
