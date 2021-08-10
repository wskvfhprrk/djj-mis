package com.guardlbt.dto;

import javax.validation.constraints.*;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


/**
 * Created by 代码自动生成.
 * 时间:2019-03-25 16:53:35
 */
@Data
public class UpdateButtonDto {	
@NotNull(message = "menuId不能为空") @ApiModelProperty("菜单id")
    private Integer menuId;
@NotBlank(message = "buttonId不能为空") @ApiModelProperty("按钮id")
private Integer buttonId;
@NotBlank(message = "buttonName不能为空") @ApiModelProperty("按钮名称")
    private String buttonName;
@ApiModelProperty("buttonCode")
    private String buttonCode;
@NotNull(message = "permissionIdentify不能为空") @ApiModelProperty("权限")
    private Integer permissiondentify;
}
