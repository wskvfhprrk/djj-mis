package com.guardlbt.vo;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;



/**
 * Created by 代码自动生成.
 * 时间:2019-03-27 09:01:24
 */
@Data
public class SelectRoleByRoleIdVo {
    
    @ApiModelProperty("角色id")
    private Integer roleId;
    
    @ApiModelProperty("角色名称")
    private String roleName;
    
    @ApiModelProperty("角色描述")
    private String roleDescribe;
}
