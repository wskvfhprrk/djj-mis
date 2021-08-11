package com.guardlbt.dto;

import javax.validation.constraints.*;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


/**
 * Created by 代码自动生成.
 * 时间:2019-03-29 13:00:12
 */
@Data
public class SaveMenuDto {
    @NotBlank(message = "menuName不能为空")
    @ApiModelProperty("菜单名称")
    private String menuName;
    //@NotBlank(message = "menuCode不能为空") @ApiModelProperty("菜单code")
    private String menuCode;
    @ApiModelProperty("url")
    private String url;
    @NotNull(message = "mPid不能为空")
    @ApiModelProperty("菜单父id：项级菜单为0")
    private Integer parentId;
    @ApiModelProperty("前台权限识别")
    private String permissionUi;
    @ApiModelProperty("前台权限识别")
    private String permission;
    @ApiModelProperty("描述")
    private String describe;
    @NotNull(message = "orderby不能为空")
    @ApiModelProperty("排序")
    private Integer orderby;
    @NotNull(message = "menuType不能为空")
    @ApiModelProperty("类别：0为菜单1为按纽")
    private Integer menuType;
}
