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
 * 时间:2019-03-27 16:54:21
 */
@Api("人员管理控制器")
@RestController
@Slf4j
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("user")
    @ApiOperation("添加人员——添加人员")
    public Result saveUser(@RequestBody SaveUserDto saveUserDto) {
        log.info("添加人员：user: {})", saveUserDto);
        return service.saveUser(saveUserDto);
    }

    @PutMapping("user")
    @ApiOperation("修改人员——修改人员")
    public Result updateUser(@Validated @RequestBody UpdateUserDto updateUserDto) {
        log.info("修改人员：user: {})", updateUserDto);
        return service.updateUser(updateUserDto);
    }

    @DeleteMapping("user/{userId}")
    @ApiOperation("删除人员——删除人员：由于使用外键，如果报错就是有人使用，不能强制删除")
    public Result deleteUserByUserId(@PathVariable("userId") String userId) {
        log.info("删除人员：user/{userId}:  {})", userId);
        return service.deleteUserByUserId(userId);
    }

    @GetMapping("user")
    @ApiOperation("分页查询人员——查询人员：创建时间倒序排列")
    public Result<PageResult<List<SelectUserPageVo>>> selectUserPage(HttpServletRequest request, @Validated SelectUserPageDto selectUserPageDto) {
        log.info("分页查询人员：user: {})", selectUserPageDto);
        return service.selectUserPage(TokenUtil.getToken(request), selectUserPageDto);
    }

    @GetMapping("user/{userId}")
    @ApiOperation("根据id查询人员——查询人员:路径参数")
    public Result<SelectUserByUserIdVo> selectUserByUserId(@PathVariable("userId") String userId) {
        log.info("根据id查询人员：user/{userId}:  {})", userId);
        return service.selectUserByUserId(userId);
    }

    @GetMapping("alluser/{userType}")
    @ApiOperation("查询所有人员——查询所有人员：为添加商家和回收渠道做准备的")
    public Result<List<SelectAlluserByUserTypeVo>> selectAlluserByUserType(@PathVariable(value = "userType") Integer userType) {
        log.info("查询所有人员：alluser/{userType}:  {})", userType);
        return service.selectAlluserByUserType(userType);
    }



}
