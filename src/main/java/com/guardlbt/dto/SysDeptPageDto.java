package com.guardlbt.dto;

import org.springframework.format.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import javax.validation.constraints.*;

     
     

/**
* Created by 代码自动生成.
* 时间:2021-08-27 13:42:55
*/
@ApiModel("商店部门管理PageDto")
@Data
public class  SysDeptPageDto {

    @NotNull(message = "pageNumber不能为空")
    @ApiModelProperty("查询页码（默认值为1）")
    private Integer pageNumber;

    @NotNull(message = "pageSize不能为空")
    @ApiModelProperty("每页多少条（默认值为30）")
    private Integer pageSize;


    @ApiModelProperty(value ="上级部门ID，一级部门为0")
    private Long parentId;

    @ApiModelProperty(value ="部门名称")
    private String name;

    @ApiModelProperty(value ="排序")
    private Integer orderNum;

    @ApiModelProperty(value ="是否删除  -1：已删除  0：正常")
    private String delFlag;
}
