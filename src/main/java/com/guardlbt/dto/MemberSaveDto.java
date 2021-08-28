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
* 时间:2021-08-28 13:20:39
*/
@ApiModel("会员实体类")
@Data
public class MemberSaveDto {


    @ApiModelProperty("用户在微信端的唯一标识") 
    @NotBlank(message = "用户在微信端的唯一标识不能为空值")
    private String openId;

    @ApiModelProperty("联系方式") 
    @NotBlank(message = "联系方式不能为空值")
    private String phone;

    @ApiModelProperty("性别（0：未知,1:男，2:女）") @NotNull(message = "性别（0：未知,1:男，2:女）不能为空值")
    private Integer sex;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty("生日") @NotNull(message = "生日不能为空值")
    private Date birthday;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty("注册时间") @NotNull(message = "注册时间不能为空值")
    private Date registerTime;

    @ApiModelProperty("头像") 
    @NotBlank(message = "头像不能为空值")
    private String imageUrl;

    @ApiModelProperty("用户昵称") 
    @NotBlank(message = "用户昵称不能为空值")
    private String nickname;

    @ApiModelProperty("用户姓名") 
    @NotBlank(message = "用户姓名不能为空值")
    private String name;

    @ApiModelProperty("标签") 
    @NotBlank(message = "标签不能为空值")
    private String label;

    @ApiModelProperty("描述") 
    @NotBlank(message = "描述不能为空值")
    private String description;

    @ApiModelProperty("归属店铺ID") 
    @NotBlank(message = "归属店铺ID不能为空值")
    private String shopId;
}
