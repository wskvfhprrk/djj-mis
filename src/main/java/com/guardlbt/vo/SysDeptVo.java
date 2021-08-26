package com.guardlbt.vo;

import org.springframework.format.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
     
     
/**
* Created by 代码自动生成.
* 时间:2021-08-25 18:06:23
*/
@ApiModel("商店部门管理实体类")
@Data
public class SysDeptVo {

    @ApiModelProperty("") 
    private Integer deptId;

    @ApiModelProperty("上级部门ID，一级部门为0") 
    private Long parentId;

    @ApiModelProperty("部门名称") 
    private String name;

    @ApiModelProperty("排序") 
    private Integer orderNum;

    @ApiModelProperty("是否删除  -1：已删除  0：正常") 
    private String delFlag;
}
