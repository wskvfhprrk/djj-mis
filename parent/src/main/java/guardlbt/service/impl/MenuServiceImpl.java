package guardlbt.service.impl;

import guardlbt.common.util.Result;
import guardlbt.common.util.ResultErrorCode;
import guardlbt.dto.SaveMenuDto;
import guardlbt.dto.SaveRoleMenuDto;
import guardlbt.dto.UpdateMenuDto;
import guardlbt.entity.Menu;
import guardlbt.entity.MenuExample;
import guardlbt.entity.RoleMenuExample;
import guardlbt.entity.RoleMenuKey;
import guardlbt.mapper.MenuMapper;
import guardlbt.mapper.RoleMenuMapper;
import guardlbt.service.MenuService;
import guardlbt.vo.MenuVo;
import guardlbt.vo.SelectAllMenuByRoleIdVo;
import guardlbt.vo.SelectMenuByMenuIdVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service("menuService")
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuMapper menuMapper;
    @Autowired
    private RoleMenuMapper roleMenuMapper;
    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    @Transactional
    public Result saveMenu(SaveMenuDto dto) {
        Menu menu = new Menu();
        BeanUtils.copyProperties(dto, menu);
        menu.setmPid(dto.getParentId());
        menu.setOrderBy(dto.getOrderby());
        menuMapper.insert(menu);
        //添加给超级管理员权限

        return Result.ok();
    }


    @Override
    public Result updateMenu(UpdateMenuDto updateMenuDto) {
        Menu menu = new Menu();
        BeanUtils.copyProperties(updateMenuDto, menu);
        menu.setmPid(updateMenuDto.getParentId());
        menu.setOrderBy(updateMenuDto.getOrderby());
        menuMapper.updateByPrimaryKey(menu);
        return Result.ok();
    }

    @Override
    public Result deleteMenuByMenuId(Integer menuId) {
        try {
            RoleMenuExample ex = new RoleMenuExample();
            ex.createCriteria().andMenuIdEqualTo(menuId);
            roleMenuMapper.deleteByExample(ex);
            menuMapper.deleteByPrimaryKey(menuId);
        } catch (DataIntegrityViolationException e) {
            e.printStackTrace();
            return Result.error(ResultErrorCode.DELETE_ERROR);
        }
        return Result.ok();
    }

    @Override
    public Result<SelectMenuByMenuIdVo> selectMenuByMenuId(Integer menuId) {
        Menu menu = menuMapper.selectByPrimaryKey(menuId);
        if (menu == null) {
            return Result.ok();
        }
        SelectMenuByMenuIdVo vo = new SelectMenuByMenuIdVo();
        BeanUtils.copyProperties(menu, vo);
        if (menu.getmPid() == 0) {
            vo.setParentName("一级菜单");
        } else {
            Menu menu1 = menuMapper.selectByPrimaryKey(menuId);
            vo.setParentName(menu1.getMenuName());
        }
        vo.setParentId(menu.getmPid());
        return Result.ok(vo);
    }

    @Override
    public Result<List<MenuVo>> menu(String token) {
        MenuExample ex = new MenuExample();
        ex.setOrderByClause("order_by");
        List<Menu> menus = menuMapper.selectByExample(ex);
        List<MenuVo> vos = menus.stream().map(m -> {
            MenuVo vo = new MenuVo();
            BeanUtils.copyProperties(m, vo);
            vo.setParentId(m.getmPid());
            return vo;
        }).collect(Collectors.toList());
        return Result.ok(vos);
    }

    @Override
    public Result<List<MenuVo>> parentMenu(String token) {
        MenuExample ex = new MenuExample();
        ex.setOrderByClause("order_by");
        List<Menu> menus = menuMapper.selectByExample(ex);
        List<MenuVo> vos = menus.stream().map(m -> {
            if (m.getMenuType() == 0) {
                MenuVo vo = new MenuVo();
                BeanUtils.copyProperties(m, vo);
                vo.setParentId(m.getmPid());
                return vo;
            }
            return null;
        }).collect(Collectors.toList());
        List<MenuVo> vos1 = new ArrayList<>();
        for (MenuVo vo : vos) {
            if (vo != null) {
                vos1.add(vo);
            }
        }
        MenuVo vo = new MenuVo();
        vo.setMenuId(0);
        vo.setMenuName("顶级菜单");
        vos1.add(vo);
        return Result.ok(vos1);
    }

    @Override
    public Result<List<SelectAllMenuByRoleIdVo>> selectAllMenuByRoleId(Integer roleId) {
        RoleMenuExample ex = new RoleMenuExample();
        ex.createCriteria().andRoleIdEqualTo(roleId);
        List<RoleMenuKey> roleMenuKeys = roleMenuMapper.selectByExample(ex);
        List<Integer> menuCheckList = roleMenuKeys.stream().map(RoleMenuKey::getMenuId).collect(Collectors.toList());
        MenuExample e = new MenuExample();
        List<Menu> menus = menuMapper.selectByExample(e);

        List<SelectAllMenuByRoleIdVo> vos = menus.stream().map(menu -> {
            SelectAllMenuByRoleIdVo vo = new SelectAllMenuByRoleIdVo();
            BeanUtils.copyProperties(menu, vo);
            vo.setParentId(menu.getmPid());
            if (menuCheckList.contains(menu.getMenuId())) {
                vo.setIsCheck(true);
            } else {
                vo.setIsCheck(false);
            }
            return vo;
        }).collect(Collectors.toList());
        return Result.ok(vos);
    }

    @Override
    @Transactional
    public Result saveRoleMenu(SaveRoleMenuDto saveRoleMenuDto) {
        //1 清此角色下所有数据
        RoleMenuExample ex = new RoleMenuExample();
        ex.createCriteria().andRoleIdEqualTo(saveRoleMenuDto.getRoleId());
        roleMenuMapper.deleteByExample(ex);
        //2 批量添加
        saveRoleMenuDto.getMenuList().forEach(v -> {
            RoleMenuKey item = new RoleMenuKey();
            item.setRoleId(saveRoleMenuDto.getRoleId());
            item.setMenuId(v.getMenuId());
            roleMenuMapper.insert(item);
        });
        //清空授权缓存
        deleteRedisToken();
        return Result.ok();
    }
    //清空授权缓存
    private void deleteRedisToken() {
        redisTemplate.delete(redisTemplate.keys("c_token_p:" + "*"));
        redisTemplate.delete(redisTemplate.keys("c_token_u:" + "*"));
        redisTemplate.delete(redisTemplate.keys("c_token_v:" + "*"));
        redisTemplate.delete(redisTemplate.keys("c_user_token:" + "*"));
    }
}
