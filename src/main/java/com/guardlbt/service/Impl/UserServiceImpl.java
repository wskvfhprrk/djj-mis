
package com.guardlbt.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.guardlbt.common.util.*;
import com.guardlbt.dto.SaveUserDto;
import com.guardlbt.dto.SelectUserPageDto;
import com.guardlbt.dto.UpdateUserDto;
import com.guardlbt.entity.*;
import com.guardlbt.mapper.UserMapper;
import com.guardlbt.mapper.UserRoleMapper;
import com.guardlbt.service.UserService;
import com.guardlbt.vo.SelectAlluserByUserTypeVo;
import com.guardlbt.vo.SelectUserByUserIdVo;
import com.guardlbt.vo.SelectUserPageVo;
import org.apache.commons.collections4.map.HashedMap;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserRoleMapper userRoleMapper;
    @Autowired
    private TokenUtil tokenUtil;

    @Override
    @Transactional
    public Result saveUser(SaveUserDto saveUserDto) {
        UserExample ex = new UserExample();
        ex.createCriteria().andUsernameEqualTo(saveUserDto.getUsername());
        List<User> users = userMapper.selectByExample(ex);
        if (!users.isEmpty()) {
            return Result.error(ResultErrorCode.USERNAME_ERROR);
        }
        User user = new User();
        BeanUtils.copyProperties(saveUserDto, user);
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        user.setUserId(uuid);
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        user.setSalt("test");
        user.setStatus(saveUserDto.getStatus());
        user.setUserType(saveUserDto.getUserType());
        if (user.getPassword() == null || user.getPassword().length() == 0) {
            user.setPassword("888888");
        }
        String salt = UUID.randomUUID().toString().split("-")[0];
        user.setSalt(salt);
        //加密
        user.setPassword(MD5Util.getMD5String(user.getPassword() + salt));
        user.setUserType(1);
        userMapper.insert(user);
        UserRoleExample userRoleExample=new UserRoleExample();
        userRoleExample.createCriteria().andUserIdEqualTo(user.getUserId());
        userRoleMapper.deleteByExample(userRoleExample);
        //角色添加
        if (saveUserDto.getRoleIds() != null && !saveUserDto.getRoleIds().isEmpty()) {
            for (Integer roleId : saveUserDto.getRoleIds()) {
                UserRoleKey userRoleKey = new UserRoleKey();
                userRoleKey.setRoleId(roleId);
                userRoleKey.setUserId(uuid);
                userRoleMapper.insert(userRoleKey);
            }
        }
        return Result.ok();
    }

    @Override
    @Transactional
    public Result updateUser(UpdateUserDto dto) {
        User user1 = userMapper.selectByPrimaryKey(dto.getUserId());
        if (StringUtils.isNotBlank(dto.getUsername()) && !user1.getUsername().equals(dto.getUsername())) {
            return Result.error(ResultErrorCode.USERNAME_ERROR2);
        }
        User user = new User();
        BeanUtils.copyProperties(dto, user);
        user.setUpdateTime(new Date());
        user.setStatus(dto.getStatus());
        user.setUserType(dto.getUserType());
        userMapper.updateByPrimaryKeySelective(user);
        //先删除
        UserRoleExample ex = new UserRoleExample();
        ex.createCriteria().andUserIdEqualTo(user.getUserId());
        userRoleMapper.deleteByExample(ex);
        //角色添加
        if (dto.getRoleIds() != null && !dto.getRoleIds().isEmpty()) {
            for (Integer roleId : dto.getRoleIds()) {
                UserRoleKey userRoleKey = new UserRoleKey();
                userRoleKey.setRoleId(roleId);
                userRoleKey.setUserId(user.getUserId());
                userRoleMapper.insert(userRoleKey);
            }
        }
        return Result.ok();
    }

    @Override
    public Result deleteUserByUserId( String userId) {
        userMapper.deleteByPrimaryKey(userId);
        return Result.ok();
    }

    @Override
    public Result<PageResult<List<SelectUserPageVo>>> selectUserPage(String token,SelectUserPageDto dto) {
        User userByToken = tokenUtil.getUserByToken(token);
        PageHelper.startPage(dto.getPageNumber(), dto.getPageSize());
        UserExample ex = new UserExample();
        UserExample.Criteria criteria = ex.createCriteria();
        //超级管理员不显示
        criteria.andUsernameNotEqualTo("admin").andUserIdNotEqualTo(userByToken.getUserId());
        if (dto.getRealName() != null && StringUtils.isNotBlank(dto.getRealName())) {
            criteria.andRealNameLike("%" + dto.getRealName() + "%");
        }
        if (dto.getPhone() != null) {
            criteria.andPasswordLike("%" + dto.getPhone() + "%");
        }
        if (dto.getUsername() != null && StringUtils.isNotBlank(dto.getUsername())) {
            criteria.andUsernameLike("%" + dto.getUsername() + "%");
        }
        List<User> users = userMapper.selectByExample(ex);
        PageInfo<User> pageInfo = new PageInfo<>(users);
        PageResult pageResult = new PageResult();
        pageResult.setPageNumber(dto.getPageNumber());
        pageResult.setPageSize(dto.getPageSize());
        pageResult.setTotle(pageInfo.getTotal());
        if (users.isEmpty()) {
            pageResult.setPages(users);
            return Result.ok(pageResult);
        }
        List<SelectUserPageVo> vos = new ArrayList<>();
        users.forEach(user -> {
            SelectUserPageVo vo = new SelectUserPageVo();
            BeanUtils.copyProperties(user, vo);
            vos.add(vo);
        });
        pageResult.setPages(vos);
        return Result.ok(pageResult);
    }

    @Override
    public Result<SelectUserByUserIdVo> selectUserByUserId(String userId) {
        SelectUserByUserIdVo vo = userMapper.info(userId);
        UserRoleExample ex = new UserRoleExample();
        ex.createCriteria().andUserIdEqualTo(userId);
        List<UserRoleKey> userRoleKeys = userRoleMapper.selectByExample(ex);
        List<Integer> collect = userRoleKeys.stream().map(UserRoleKey::getRoleId).collect(Collectors.toList());
        vo.setRoleIds(collect);
        return Result.ok(vo);
    }

    //下拉框
    @Override
    public Result<List<SelectAlluserByUserTypeVo>> selectAlluserByUserType(Integer userType) {
        Map<String, Object> params = new HashedMap<String, Object>();
        params.put("userType", userType);
        List<Map<String, Object>> data = userMapper.userDown(params);
        return Result.ok(data);
    }

}

