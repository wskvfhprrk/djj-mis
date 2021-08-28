package com.guardlbt.vo;

import org.springframework.format.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
            
     
import java.util.Date;
/**
* Created by 代码自动生成.
* 时间:2021-08-28 11:42:17
*/
@ApiModel("会员实体类")
@Data
public class MemberPageVo {

    @ApiModelProperty(value ="编号")
    private String memberId;

    @ApiModelProperty(value ="用户在微信端的唯一标识")
    private String openId;

    @ApiModelProperty(value ="联系方式")
    private String phone;

    @ApiModelProperty(value ="性别（0：未知,1:男，2:女）")
    private Integer sex;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value ="生日")
    private Date birthday;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value ="注册时间")
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
