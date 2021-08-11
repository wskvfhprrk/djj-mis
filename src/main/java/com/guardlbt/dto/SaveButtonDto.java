
package com.guardlbt.dto;

import javax.validation.constraints.*;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


/**
 * Created by 代码自动生成.
 * 时间:2019-03-25 16:53:35
 */
@Data
public class SaveButtonDto {
    @NotNull(message = "menuId不能为空")
    @ApiModelProperty("菜单id")
    private Integer menuId;

    @NotNull(message = "buttonId不能为空")
    @ApiModelProperty("菜单id")
    private Integer buttonId;

    @NotBlank(message = "buttonName不能为空")
    @ApiModelProperty("按纽名称")
    private String buttonName;
    @NotBlank(message = "buttonCode不能为空")
    @ApiModelProperty("按纽英文（select、update、delete、add等）")
    private String buttonCode;

    @NotBlank(message = "permissionIdentify不能为空")
    @ApiModelProperty("权限")
    private String permissionIdentify;
}


