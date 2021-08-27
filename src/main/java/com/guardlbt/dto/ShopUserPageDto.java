package com.guardlbt.dto;

import org.springframework.format.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import javax.validation.constraints.*;

           
    
import java.util.Date;

/**
* Created by 代码自动生成.
* 时间:2021-08-27 13:42:55
*/
@ApiModel("商店管理员PageDto")
@Data
public class  ShopUserPageDto {

    @NotNull(message = "pageNumber不能为空")
    @ApiModelProperty("查询页码（默认值为1）")
    private Integer pageNumber;

    @NotNull(message = "pageSize不能为空")
    @ApiModelProperty("每页多少条（默认值为30）")
    private Integer pageSize;


    @ApiModelProperty(value ="昵称")
    private String name;

    @ApiModelProperty(value ="性别（0:男，1:女）")
    private String sex;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value ="生日")
    private Date birthday;

    @ApiModelProperty(value ="联系方式")
    private String phone;

    @ApiModelProperty(value ="角色（0-老板 1-店长 2-员工）")
    private String role;

    @ApiModelProperty(value ="店铺编号")
    private String shopId;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value ="创建时间",example = "2000-12-12 10:10:10")
    private Date createTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value ="更新时间",example = "2000-12-12 10:10:10")
    private Date updateTime;

    @ApiModelProperty(value ="状态（0-正常 1-暂停 2-注销）")
    private String status;

    @ApiModelProperty(value ="用户在微信端的唯一标识")
    private String openId;
}
