package guardlbt.vo;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;    

/**
 * Created by 代码自动生成.
 * 时间:2019-03-27 10:05:58
 */
@Data
public class SelectAllRoleByRoleIdVo {
    
    @ApiModelProperty("菜单Id")
    private Integer menuId;
    
    @ApiModelProperty("菜单名称")
    private String menuName;
    
    @ApiModelProperty("菜单父级Id")
    private Integer parentId;
    
    @ApiModelProperty("是否选中：false未选中，true是选中")
    private Boolean isCheck;
    
//    @ApiModelProperty("按纽")
//    private List<ButtonVo> buttonList;
//
//    @Data
//    private static class Button {
//
//        @ApiModelProperty("按纽id")
//        private Integer buttonId;
//
//        @ApiModelProperty("按纽名称")
//        private String buttonName;
//
//        @ApiModelProperty("是否选中：false未选中，true是选中")
//        private Boolean isCheck;
//    }
}
