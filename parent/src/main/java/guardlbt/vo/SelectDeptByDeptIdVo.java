package guardlbt.vo;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;



/**
 * Created by 代码自动生成.
 * 时间:2019-03-25 16:51:41
 */
@Data
public class SelectDeptByDeptIdVo {
    
    @ApiModelProperty("部门Id")
    private Integer deptId;
    
    @ApiModelProperty("部门名称")
    private String deptName;
    
    @ApiModelProperty("部门父级id")
    private Integer pId;
}
