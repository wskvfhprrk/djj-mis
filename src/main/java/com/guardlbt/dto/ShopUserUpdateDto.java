package com.guardlbt.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.*;
import lombok.Data;
           
    
import java.util.Date;
/**
* Created by 代码自动生成.
* 时间:2021-08-28 11:42:14
*/
@ApiModel("商店管理员实体类")
@Data
public class ShopUserUpdateDto {

    @ApiModelProperty(value ="pc端用户唯一标识") 
    @NotBlank(message = "pc端用户唯一标识不能为空值")     private String userId;

    @ApiModelProperty(value ="昵称") 
    @NotBlank(message = "昵称不能为空值")     private String name;

    @ApiModelProperty(value ="性别（0:男，1:女）") @NotNull(message = "性别（0:男，1:女）不能为空值")
     private Integer sex;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value ="生日") @NotNull(message = "生日不能为空值")
     private Date birthday;

    @ApiModelProperty(value ="联系方式") 
    @NotBlank(message = "联系方式不能为空值")     private String phone;

    @ApiModelProperty(value ="角色（0-老板 1-店长 2-员工）") @NotNull(message = "角色（0-老板 1-店长 2-员工）不能为空值")
     private Integer role;

    @ApiModelProperty(value ="店铺编号") 
    @NotBlank(message = "店铺编号不能为空值")     private String shopId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value ="创建时间",example = "2000-12-12 10:10:10") @NotNull(message = "创建时间不能为空值")
     private Date createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value ="更新时间",example = "2000-12-12 10:10:10") @NotNull(message = "更新时间不能为空值")
     private Date updateTime;

    @ApiModelProperty(value ="状态（0-正常 1-暂停 2-注销）") @NotNull(message = "状态（0-正常 1-暂停 2-注销）不能为空值")
     private Integer status;

    @ApiModelProperty(value ="用户在微信端的唯一标识") 
    @NotBlank(message = "用户在微信端的唯一标识不能为空值")     private String openId;
}
