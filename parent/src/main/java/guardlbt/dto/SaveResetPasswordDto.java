package guardlbt.dto;

import javax.validation.constraints.*;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


/**
 * Created by 代码自动生成.
 * 时间:2019-03-25 16:49:43
 */
@Data
public class SaveResetPasswordDto {
    @NotBlank(message = "userId不能为空")
    @ApiModelProperty("用户ID")
    private String userId;
}
