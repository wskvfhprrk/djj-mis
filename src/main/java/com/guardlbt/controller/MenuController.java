package com.guardlbt.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import com.guardlbt.common.util.*;
import com.guardlbt.vo.*;
import com.guardlbt.dto.*;
import com.guardlbt.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * Created by 代码自动生成.
 * 时间:2019-03-29 13:00:13
 */
@Api("菜单管理控制器")
@RestController
@Slf4j
public class MenuController {

    @Autowired
    private MenuService service;

    @PostMapping("menu")
    @ApiOperation("添加菜单——添加菜单")
    public Result saveMenu(@Validated @RequestBody SaveMenuDto saveMenuDto) {
        log.info("添加菜单：menu: {})", saveMenuDto);
        return service.saveMenu(saveMenuDto);
    }

    @PutMapping("menu")
    @ApiOperation("修改菜单——修改菜单")
    public Result updateMenu(@Validated @RequestBody UpdateMenuDto updateMenuDto) {
        log.info("修改菜单：menu: {})", updateMenuDto);
        return service.updateMenu(updateMenuDto);
    }

    @DeleteMapping("menu/{menuId}")
    @ApiOperation("删除菜单")
    public Result deleteMenuByMenuId(@PathVariable("menuId") Integer menuId) {
        log.info("删除菜单：menu/{menuId}:  {})", menuId);
        return service.deleteMenuByMenuId(menuId);
    }

    @GetMapping("menu/{menuId}")
    @ApiOperation("查看菜单明细")
    public Result selectMenuByMenuId(@PathVariable("menuId") Integer menuId) {
        log.info("查看菜单明细：menu/{menuId}:  {})", menuId);
        return service.selectMenuByMenuId(menuId);
    }

    @GetMapping("menu")
    @ApiOperation("查询所有查询菜单——分页查询菜单")
    public Result<List<MenuVo>> menu(HttpServletRequest request) {
        log.info("查询所有查询菜单：menu)");
        return service.menu(TokenUtil.getToken(request));
    }

    @GetMapping("parentMenu")
    @ApiOperation("查询父级菜单")
    public Result<List<MenuVo>> parentMenu(HttpServletRequest request) {
        log.info("查询父级菜单：parentMenu)");
        return service.parentMenu(TokenUtil.getToken(request));
    }

    @GetMapping("allMenu/{roleId}")
    @ApiOperation("查询角色的菜单——查询角色下的菜单和按纽：查询所有菜单和按纽，如果角色拥有的菜单和按纽处于选中状态isCheck为true")
    public Result<List<SelectAllMenuByRoleIdVo>> selectAllMenuByRoleId(@PathVariable("roleId") Integer roleId) {
        log.info("查询角色的菜单：allMenu/{roleId}:  {})", roleId);
        return service.selectAllMenuByRoleId(roleId);
    }

    @PostMapping("roleMenu")
    @ApiOperation("添加角色的菜单——关联角色菜单：添加前先清此角色下所有数据，然后再批量添加")
    public Result saveRoleMenu(@Validated @RequestBody SaveRoleMenuDto saveRoleMenuDto) {
        log.info("添加角色的菜单：roleMenu: {})", saveRoleMenuDto);
        return service.saveRoleMenu(saveRoleMenuDto);
    }

}
