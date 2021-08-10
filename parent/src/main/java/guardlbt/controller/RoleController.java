package guardlbt.controller;

import guardlbt.common.util.PageResult;
import guardlbt.common.util.Result;
import guardlbt.dto.SaveRoleDto;
import guardlbt.dto.SaveUserRoleDto;
import guardlbt.dto.SelectRolePageDto;
import guardlbt.dto.UpdateRoleDto;
import guardlbt.service.RoleService;
import guardlbt.vo.AllRoleVo;
import guardlbt.vo.SelectAllRoleByUserIdVo;
import guardlbt.vo.SelectRoleByRoleIdVo;
import guardlbt.vo.SelectRolePageVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by 代码自动生成.
 * 时间:2019-03-27 09:01:24
 */
@Api("角色管理控制器")
@RestController
@Slf4j
public class RoleController {

    @Autowired
    private RoleService service;

    @PostMapping("role")
    @ApiOperation("添加角色——添加角色")
    public Result saveRole(@Validated @RequestBody SaveRoleDto saveRoleDto) {
        log.info("添加角色：role: {})", saveRoleDto);
        return service.saveRole(saveRoleDto);
    }

    @PutMapping("role")
    @ApiOperation("修改角色——修改角色")
    public Result updateRole(@Validated @RequestBody UpdateRoleDto updateRoleDto) {
        log.info("修改角色：role: {})", updateRoleDto);
        return service.updateRole(updateRoleDto);
    }

    @DeleteMapping("role/{roleId}")
    @ApiOperation("删除角色——删除角色：如果此角色被使用则不能删除")
    public Result deleteRoleByRoleId(@PathVariable("roleId") Integer roleId) {
        log.info("删除角色：role/{roleId}:  {})", roleId);
        return service.deleteRoleByRoleId(roleId);
    }

    @GetMapping("role")
    @ApiOperation("分页查询角色——分页查询角色")
    public Result<PageResult<List<SelectRolePageVo>>> selectRolePage(SelectRolePageDto selectRolePageDto) {
        log.info("分页查询角色：role: {})", selectRolePageDto);
        return service.selectRolePage(selectRolePageDto);
    }

    @GetMapping("role/{roleId}")
    @ApiOperation("根据id查询角色——根据id查询角色")
    public Result<SelectRoleByRoleIdVo> selectRoleByRoleId(@PathVariable("roleId") Integer roleId) {
        log.info("根据id查询角色：role/{roleId}:  {})", roleId);
        return service.selectRoleByRoleId(roleId);
    }

    @GetMapping("allRole/{userId}")
    @ApiOperation("查询全部角色——分页查询角色：查询所有角色，当前选中人员的角色isCheck为true")
    public Result<List<SelectAllRoleByUserIdVo>> selectAllRoleByUserId(@PathVariable("userId") Integer userId) {
        log.info("查询全部角色：allRole/{userId}:  {})", userId);
        return service.selectAllRoleByUserId(userId);
    }

    @GetMapping("allRole")
    @ApiOperation("查询全部角色")
    public Result<List<AllRoleVo>> allRole() {
        log.info("查询全部角色：allRole)");
        return service.allRole();
    }


    @PostMapping("userRole")
    @ApiOperation("人员关联角色——人员关联角色：后端处理先删除中间表中这个人员下所有关联数据，再添加")
    public Result saveUserRole(@Validated @RequestBody List<SaveUserRoleDto> saveUserRoleDtos) {
        log.info("人员关联角色：userRole: {})", saveUserRoleDtos);
        return service.saveUserRole(saveUserRoleDtos);
    }

}
