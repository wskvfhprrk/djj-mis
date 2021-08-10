package com.guardlbt.dto;

import javax.validation.constraints.*;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

    import java.util.List;    
/**
 * Created by 代码自动生成.
 * 时间:2019-03-29 13:00:13
 */
@Data
public class SaveRoleMenuDto {
@NotNull(message = "roleId不能为空") @ApiModelProperty("角色id")
    private Integer roleId;
@ApiModelProperty("菜单id数组")
    private List<Menu> menuList;
    @Data
    public static class Menu{
        
        @ApiModelProperty("菜单id")
        private Integer menuId;
        
        @ApiModelProperty("父级id")
        private Integer parentId;
    }
}
