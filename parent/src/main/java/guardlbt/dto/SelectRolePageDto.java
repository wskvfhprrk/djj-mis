package guardlbt.dto;

import javax.validation.constraints.*;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


/**
 * Created by 代码自动生成.
 * 时间:2019-03-27 09:01:24
 */
@Data
public class SelectRolePageDto {
    @ApiModelProperty("角色名称（模糊）")
    private String roleName;
    @NotNull(message = "pageNumber不能为空")
    @ApiModelProperty("查询页码")
    private Integer pageNumber;
    @NotNull(message = "pageSize不能为空")
    @ApiModelProperty("每页多少条")
    private Integer pageSize;
}
