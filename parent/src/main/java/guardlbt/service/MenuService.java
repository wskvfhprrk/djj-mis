package guardlbt.service;

import guardlbt.common.util.Result;
import guardlbt.dto.SaveMenuDto;
import guardlbt.dto.SaveRoleMenuDto;
import guardlbt.dto.UpdateMenuDto;
import guardlbt.vo.MenuVo;
import guardlbt.vo.SelectAllMenuByRoleIdVo;

import java.util.List;

/**
 * 菜单管理方法类接口
 *
 * Created by 代码自动生成.
 * 时间:2019-03-29 13:00:13
 */
public interface MenuService {

    /**
    * 添加菜单——添加菜单
    */
    Result saveMenu(SaveMenuDto saveMenuDto);

    /**
    * 修改菜单——修改菜单
    */
    Result updateMenu( UpdateMenuDto updateMenuDto);

    /**
    * 修改菜单——删除菜单
    */
    Result deleteMenuByMenuId( Integer menuId);

    /**
    * 查询所有查询菜单——分页查询菜单
    */
    Result<List<MenuVo>> menu(String token);

    /**
    * 查询角色的菜单——查询角色下的菜单和按纽：查询所有菜单和按纽，如果角色拥有的菜单和按纽处于选中状态isCheck为true
    */
    Result<List<SelectAllMenuByRoleIdVo>> selectAllMenuByRoleId(Integer roleId);

    /**
    * 查询角色的菜单——关联角色菜单：添加前先清此角色下所有数据，然后再批量添加
    */
    Result saveRoleMenu( SaveRoleMenuDto saveRoleMenuDto);

    Result<List<MenuVo>> parentMenu(String token);

    Result selectMenuByMenuId(Integer menuId);
}
