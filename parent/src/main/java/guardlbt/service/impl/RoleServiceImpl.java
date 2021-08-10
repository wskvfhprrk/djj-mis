package guardlbt.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import guardlbt.common.util.PageResult;
import guardlbt.common.util.Result;
import guardlbt.common.util.ResultErrorCode;
import guardlbt.dto.SaveRoleDto;
import guardlbt.dto.SaveUserRoleDto;
import guardlbt.dto.SelectRolePageDto;
import guardlbt.dto.UpdateRoleDto;
import guardlbt.entity.*;
import guardlbt.mapper.RoleMapper;
import guardlbt.mapper.RoleMenuMapper;
import guardlbt.mapper.UserRoleMapper;
import guardlbt.service.RoleService;
import guardlbt.vo.AllRoleVo;
import guardlbt.vo.SelectAllRoleByUserIdVo;
import guardlbt.vo.SelectRoleByRoleIdVo;
import guardlbt.vo.SelectRolePageVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.beans.Transient;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private UserRoleMapper userRoleMapper;
    @Autowired
    private RoleMenuMapper roleMenuMapper;

    @Override
    public Result saveRole(SaveRoleDto saveRoleDto) {
        Role role = new Role();
        BeanUtils.copyProperties(saveRoleDto, role);
        roleMapper.insert(role);
        return Result.ok();
    }

    @Override
    public Result updateRole(UpdateRoleDto updateRoleDto) {
        Role role = new Role();
        BeanUtils.copyProperties(updateRoleDto, role);
        roleMapper.updateByPrimaryKey(role);
        return Result.ok();

    }

    @Override
    public Result deleteRoleByRoleId(Integer roleId) {
        //1 判断角色是否被使用，被使用则不能删除
        UserRoleExample userRoleExample = new UserRoleExample();
        UserRoleExample.Criteria criteria = userRoleExample.createCriteria();
        criteria.andRoleIdEqualTo(roleId);
        Long userRoleCount = userRoleMapper.countByExample(userRoleExample);
        if (userRoleCount > 0) {
            return Result.error(500,"此角色已经在使用中，请删除");
        }
        RoleMenuExample roleMenuExample = new RoleMenuExample();
        RoleMenuExample.Criteria criteria1 = roleMenuExample.createCriteria();
        criteria1.andRoleIdEqualTo(roleId);
        //删除菜单角色中间表数据
        RoleMenuExample ex=new RoleMenuExample();
        ex.createCriteria().andRoleIdEqualTo(roleId);
        roleMenuMapper.deleteByExample(ex);
        //2 判断角色
        roleMapper.deleteByPrimaryKey(roleId);
        return Result.ok();
    }

    @Override
    public Result<PageResult<List<SelectRolePageVo>>> selectRolePage(SelectRolePageDto selectRolePageDto) {
        PageResult pageResult = new PageResult<>();
        pageResult.setPageSize(selectRolePageDto.getPageSize());
        pageResult.setPageNumber(selectRolePageDto.getPageNumber());

        RoleExample roleExample = new RoleExample();
        RoleExample.Criteria criteria = roleExample.createCriteria();
        if (null != selectRolePageDto.getRoleName() && !"".equals(selectRolePageDto.getRoleName().trim())) {
            criteria.andRoleNameLike(selectRolePageDto.getRoleName());
        }
        PageHelper.startPage(selectRolePageDto.getPageNumber(), selectRolePageDto.getPageSize());
        List<Role> roles = roleMapper.selectByExample(roleExample);
        PageInfo<Role> pageInfo = new PageInfo<>(roles, selectRolePageDto.getPageSize());
        pageResult.setTotle(pageInfo.getTotal());
        pageResult.setPages(roles.stream().map(v -> {
            SelectRolePageVo selectRole = new SelectRolePageVo();
            BeanUtils.copyProperties(v, selectRole);
            selectRole.setRoleDescribe(v.getRoleDescribe());
            return selectRole;
        }).collect(Collectors.toList()));
        return Result.ok(pageResult);
    }

    @Override
    public Result<SelectRoleByRoleIdVo> selectRoleByRoleId(Integer roleId) {
        Role role = roleMapper.selectByPrimaryKey(roleId);
        if (role == null) {
            return Result.error(ResultErrorCode.SELECT_FAIL);
        }
        SelectRoleByRoleIdVo selectRole = new SelectRoleByRoleIdVo();
        BeanUtils.copyProperties(role, selectRole);
        return Result.ok(selectRole);
    }

    @Override
    public Result<List<SelectAllRoleByUserIdVo>> selectAllRoleByUserId(Integer userId) {
        //分页查询角色：查询所有角色，当前选中人员的角色isCheck为true
        List<SelectAllRoleByUserIdVo> roles = roleMapper.selectAllRoleByUserId(userId);
        return Result.ok(roles);
    }


    @Override
    @Transient
    public Result saveUserRole(List<SaveUserRoleDto> saveUserRoleDto) {
        //1 先批量删除再批量添加
        UserRoleExample userRoleExample = new UserRoleExample();
        UserRoleExample.Criteria criteria = userRoleExample.createCriteria();
        criteria.andRoleIdEqualTo(Integer.valueOf(saveUserRoleDto.get(0).getUserId()));
        userRoleMapper.insertBatch(saveUserRoleDto.stream().map(v -> {
            UserRoleKey userRoleKey = new UserRoleKey();
            BeanUtils.copyProperties(v, userRoleKey);
            return userRoleKey;
        }).collect(Collectors.toList()));
        return Result.ok();
    }

    @Override
    public Result<List<AllRoleVo>> allRole() {
        RoleExample ex = new RoleExample();
        ex.createCriteria().andRoleIdNotEqualTo(1);
        List<Role> roles = roleMapper.selectByExample(ex);
        List<AllRoleVo> vos = roles.stream().map(r -> {
            AllRoleVo vo = new AllRoleVo();
            BeanUtils.copyProperties(r, vo);
            return vo;
        }).collect(Collectors.toList());
        return Result.ok(vos);
    }
}
