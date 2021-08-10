package guardlbt.dto;

import javax.validation.constraints.*;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


/**
 * Created by 代码自动生成.
 * 时间:2019-03-25 16:51:41
 */
@Data
public class DeptDto {
    @ApiModelProperty("部门名称")
    private String deptName;
}
