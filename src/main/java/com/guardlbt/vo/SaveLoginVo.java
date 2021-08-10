package com.guardlbt.vo;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * Created by 代码自动生成.
 * 时间:2019-03-25 16:49:43
 */
@Data
public class SaveLoginVo {

    private List<String> permissions;
    private List<Menus> menuList;

    @Data
    public static class Menus {
        @ApiModelProperty("菜单id")
        private Integer menuId;
        @ApiModelProperty("父级id")
        private Integer parentId;
        @ApiModelProperty("菜单名称")
        private String name;
        @ApiModelProperty("链接地址")
        private String url;
        private Integer orderBy;
    }
}
