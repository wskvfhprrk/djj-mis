package guardlbt.vo;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


/**
 * Created by 代码自动生成.
 * 时间:2019-03-27 10:41:51
 */
@Data
public class SelectMenuByMenuIdVo {

    private Integer menuId;

    private String menuName;

    private String url;

    private Integer parentId;
    private String parentName;

    private String menuCode;

    private String permissionUi;

    private String permission;

    private String menuDescribe;

    private Integer orderby;

    private Integer menuType;
}
