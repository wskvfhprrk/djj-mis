package guardlbt.dto;

import javax.validation.constraints.*;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


/**
 * Created by 代码自动生成.
 * 时间:2019-04-10 10:07:23
 */
@Data
public class SelectCouponCheckPageDto {
    @NotNull(message = "pageNumber不能为空")
    @ApiModelProperty("查询页码")
    private Integer pageNumber;
    @NotNull(message = "pageSize不能为空")
    @ApiModelProperty("每页多少条")
    private Integer pageSize;
}
