package com.guardlbt.dto;

import org.springframework.format.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import javax.validation.constraints.*;

            
     
import java.util.Date;

/**
* Created by 代码自动生成.
* 时间:2021-08-26 16:20:27
*/
@ApiModel("会员PageDto")
@Data
public class  MemberPageDto {

    @NotNull(message = "pageNumber不能为空")
    @ApiModelProperty("查询页码（默认值为1）")
    private Integer pageNumber;

    @NotNull(message = "pageSize不能为空")
    @ApiModelProperty("每页多少条（默认值为30）")
    private Integer pageSize;


    @ApiModelProperty("用户在微信端的唯一标识") 
    private String openId;

    @ApiModelProperty("联系方式") 
    private String phone;

    @ApiModelProperty("性别（0：未知,1:男，2:女）") 
    private String sex;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty("生日") 
    private Date birthday;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty("注册时间") 
    private Date registerTime;

    @ApiModelProperty("头像") 
    private String imageUrl;

    @ApiModelProperty("用户昵称") 
    private String nickname;

    @ApiModelProperty("用户姓名") 
    private String name;

    @ApiModelProperty("标签") 
    private String label;

    @ApiModelProperty("描述") 
    private String description;

    @ApiModelProperty("归属店铺ID") 
    private String shopId;
}