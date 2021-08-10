package guardlbt.vo;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;



/**
 * Created by 代码自动生成.
 * 时间:2019-03-29 11:47:28
 */
@Data
public class SelectMenuPageVo {
    
    @ApiModelProperty("菜单id")
    private Integer menuId;
    
    @ApiModelProperty("菜单名称")
    private String menuName;
    
    @ApiModelProperty("url")
    private String url;
    
    @ApiModelProperty("菜单父id：一级菜单为0")
    private Integer mPid;
}
