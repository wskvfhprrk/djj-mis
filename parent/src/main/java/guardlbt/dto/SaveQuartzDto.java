package guardlbt.dto;

import javax.validation.constraints.*;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


/**
 * Created by 代码自动生成.
 * 时间:2019-04-01 13:00:57
 */
@Data
public class SaveQuartzDto {
@NotBlank(message = "name不能为空") @ApiModelProperty("定时任务名称")
    private String name;
@NotBlank(message = "jobGroup不能为空") @ApiModelProperty("定时任务组")
    private String jobGroup;
@NotBlank(message = "jobClass不能为空") @ApiModelProperty("定时任务类")
    private String jobClass;
@NotBlank(message = "cron不能为空") @ApiModelProperty("定时任务时间配置")
    private String cron;
@NotNull(message = "status不能为空") @ApiModelProperty("状态：0禁用；1启用")
    private Integer status;
@ApiModelProperty("描述")
    private String remark;
}
