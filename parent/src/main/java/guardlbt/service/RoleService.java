package guardlbt.service;

import guardlbt.common.util.PageResult;
import guardlbt.common.util.Result;
import guardlbt.dto.SaveRoleDto;
import guardlbt.dto.SaveUserRoleDto;
import guardlbt.dto.SelectRolePageDto;
import guardlbt.dto.UpdateRoleDto;
import guardlbt.vo.AllRoleVo;
import guardlbt.vo.SelectAllRoleByUserIdVo;
import guardlbt.vo.SelectRoleByRoleIdVo;
import guardlbt.vo.SelectRolePageVo;

import java.util.List;

/**
 * 角色管理方法类接口
 * <p>
 * Created by 代码自动生成.
 * 时间:2019-03-27 09:01:24
 */
public interface RoleService {

    /**
     * 添加角色——添加角色
     */
    Result saveRole(SaveRoleDto saveRoleDto);

    /**
     * 修改角色——修改角色
     */
    Result updateRole(UpdateRoleDto updateRoleDto);

    /**
     * 删除角色——删除角色：如果此角色被使用则不能删除
     */
    Result deleteRoleByRoleId(Integer roleId);

    /**
     * 分页查询角色——分页查询角色
     */
    Result<PageResult<List<SelectRolePageVo>>> selectRolePage(SelectRolePageDto selectRolePageDto);

    /**
     * 根据id查询角色——根据id查询角色
     */
    Result<SelectRoleByRoleIdVo> selectRoleByRoleId(Integer roleId);

    /**
     * 查询全部角色——分页查询角色：查询所有角色，当前选中人员的角色isCheck为true
     */
    Result<List<SelectAllRoleByUserIdVo>> selectAllRoleByUserId(Integer userId);

    /**
     * 人员关联角色——人员关联角色：后端处理先删除中间表中这个人员下所有关联数据，再添加
     */
    Result saveUserRole(List<SaveUserRoleDto> saveUserRoleDtos);

    Result<List<AllRoleVo>> allRole();
}
