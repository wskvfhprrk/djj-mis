package guardlbt.vo;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;



/**
 * Created by 代码自动生成.
 * 时间:2019-03-29 13:00:13
 */
@Data
public class SelectAllMenuByRoleIdVo {
    
    @ApiModelProperty("菜单Id")
    private Integer menuId;
    
    @ApiModelProperty("菜单名称")
    private String menuName;
    
    @ApiModelProperty("菜单父级Id")
    private Integer parentId;
    
    @ApiModelProperty("是否选中：false未选中，true是选中")
    private Boolean isCheck;
}
