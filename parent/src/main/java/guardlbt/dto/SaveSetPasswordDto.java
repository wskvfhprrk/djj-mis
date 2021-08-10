package guardlbt.dto;

import javax.validation.constraints.*;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


/**
 * Created by 代码自动生成.
 * 时间:2019-03-25 16:49:43
 */
@Data
public class SaveSetPasswordDto {
    @NotBlank(message = "oldPassword不能为空")
    @ApiModelProperty("旧密码")
    private String oldPassword;
    @NotBlank(message = "newPassword不能为空")
    @ApiModelProperty("新密码")
    private String newPassword;
}
