package guardlbt.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class AdminLoginDto {
    @NotBlank(message = "手机号码不能为空值")
    @ApiModelProperty(value = "手机号码")
    private String phone;

    @NotBlank(message = "密码不能为空值")
    @ApiModelProperty(value = "密码")
    private String password;

    @NotBlank(message = "手机imei不能为空值")
    @ApiModelProperty(value = "手机imei")
    private String imei;

    @NotBlank(message = "图形验证码不能为空值")
    @ApiModelProperty(value = "图形验证码")
    private String imageCode;
}
