package com.guardlbt.vo;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;



/**
 * Created by 代码自动生成.
 * 时间:2019-03-25 17:22:36
 */
@Data
public class AllRoleVo {
    
    @ApiModelProperty("角色id")
    private Integer roleId;
    
    @ApiModelProperty("角色名称")
    private String roleName;
    
    @ApiModelProperty("角色描述")
    private String roleDescribe;
}
