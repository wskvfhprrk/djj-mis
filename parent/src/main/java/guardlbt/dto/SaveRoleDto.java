package guardlbt.dto;

import javax.validation.constraints.*;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


/**
 * Created by 代码自动生成.
 * 时间:2019-03-27 09:01:24
 */
@Data
public class SaveRoleDto {
    @NotBlank(message = "roleName不能为空")
    @ApiModelProperty("角色名称")
    private String roleName;
    private String roleDescribe;
}
