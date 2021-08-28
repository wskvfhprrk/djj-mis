package com.guardlbt.dto;

import org.springframework.format.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import javax.validation.constraints.*;

            
     
import java.util.Date;

/**
* Created by 代码自动生成.
* 时间:2021-08-28 11:42:17
*/
@ApiModel("会员PageDto")
@Data
public class  MemberPageDto {

    @NotNull(message = "pageNumber不能为空")
    @ApiModelProperty(value = "查询页码（默认值为1）",example = "1")
    private Integer pageNumber;

    @NotNull(message = "pageSize不能为空")
    @ApiModelProperty(value = "每页多少条（默认值为30）",example = "1")
    private Integer pageSize;



    @ApiModelProperty(value ="用户在微信端的唯一标识")
    private String openId;

    @ApiModelProperty(value ="联系方式")
    private String phone;

    @ApiModelProperty(value ="性别（0：未知,1:男，2:女）")
    private Integer sex;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value ="生日",example = "2000-12-12 10:10:10")
    private Date birthday;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value ="注册时间",example = "2000-12-12 10:10:10")
    private Date registerTime;

    @ApiModelProperty(value ="头像")
    private String imageUrl;

    @ApiModelProperty(value ="用户昵称")
    private String nickname;

    @ApiModelProperty(value ="用户姓名")
    private String name;

    @ApiModelProperty(value ="标签")
    private String label;

    @ApiModelProperty(value ="描述")
    private String description;

    @ApiModelProperty(value ="归属店铺ID")
    private String shopId;
}
