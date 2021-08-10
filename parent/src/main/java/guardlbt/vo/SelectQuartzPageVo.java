package guardlbt.vo;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;



/**
 * Created by 代码自动生成.
 * 时间:2019-04-01 13:00:57
 */
@Data
public class SelectQuartzPageVo {
    
    @ApiModelProperty("id")
    private Long id;
    
    @ApiModelProperty("定时任务名称")
    private String name;
    
    @ApiModelProperty("定时任务组")
    private String jobGroup;
    
    @ApiModelProperty("定时任务类")
    private String jobClass;
    
    @ApiModelProperty("定时任务时间配置")
    private String cron;
    
    @ApiModelProperty("状态：0禁用；1启用")
    private Integer status;
    
    @ApiModelProperty("描述")
    private String remark;
}
