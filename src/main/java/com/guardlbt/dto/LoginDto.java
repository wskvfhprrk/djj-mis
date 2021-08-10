package com.guardlbt.dto;

import javax.validation.constraints.*;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


/**
 * Created by 代码自动生成.
 * 时间:2019-03-25 16:49:43
 */
@Data
public class LoginDto {
    @NotBlank(message = "username不能为空")
    @ApiModelProperty(value = "用户名",example = "admin")
    private String username;
    @NotBlank(message = "password不能为空")
    @ApiModelProperty(value = "密码",example = "1")
    private String password;
    @NotBlank(message = "checkCode不能为空")
    @ApiModelProperty(value = "验证码",example = "123456")
    private String checkCode;
}
