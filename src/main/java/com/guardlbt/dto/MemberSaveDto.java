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
* 时间:2021-08-27 13:42:56
*/
@ApiModel("会员实体类")
@Data
public class MemberSaveDto {

    @ApiModelProperty(value ="用户在微信端的唯一标识",example = "")
    @NotBlank(message = "用户在微信端的唯一标识不能为空值")
    private String openId;

    @ApiModelProperty(value ="联系方式",example = "")
    @NotBlank(message = "联系方式不能为空值")
    private String phone;

    @ApiModelProperty(value ="性别（0：未知,1:男，2:女）",example = "")
    @NotNull(message = "性别（0：未知,1:男，2:女）不能为空值")
    private Integer sex;


    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value ="生日",example = "2000-12-12 10:10:10")
    @NotNull(message = "生日不能为空值")
    private Date birthday;


    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value ="注册时间",example = "2000-12-12 10:10:10")
    @NotNull(message = "注册时间不能为空值")
    private Date registerTime;

    @ApiModelProperty(value ="头像",example = "")
    @NotBlank(message = "头像不能为空值")
    private String imageUrl;

    @ApiModelProperty(value ="用户昵称",example = "")
    @NotBlank(message = "用户昵称不能为空值")
    private String nickname;

    @ApiModelProperty(value ="用户姓名",example = "")
    @NotBlank(message = "用户姓名不能为空值")
    private String name;

    @ApiModelProperty(value ="标签",example = "")
    @NotBlank(message = "标签不能为空值")
    private String label;

    @ApiModelProperty(value ="描述",example = "")
    @NotBlank(message = "描述不能为空值")
    private String description;

    @ApiModelProperty(value ="归属店铺ID",example = "")
    @NotBlank(message = "归属店铺ID不能为空值")
    private String shopId;
}
