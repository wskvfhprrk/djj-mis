package com.guardlbt.controller;

import cn.hutool.system.UserInfo;
import com.guardlbt.common.util.Result;
import com.guardlbt.dto.SaveUserInfoDto;
import com.guardlbt.eum.Role;
import com.guardlbt.service.WxMyService;
import com.guardlbt.vo.UserInfoVo;
import com.guardlbt.wx.dto.GetUserInfoDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api")
@RestController
@Api(value = "小程序我的页面接口",tags = "小程序我的页面接口")
public class WxMyController {

    @Autowired
    private WxMyService wxMyService;

    @ApiOperation("获取当前用户角色")
    @GetMapping("getRole/{openid}")
    public Result<Role> getRole(@PathVariable String openid){
        return wxMyService.getRole(openid);
    }


    @ApiOperation("查看本人基本信息")
    @GetMapping("userInfo/{openid}")
    public Result<UserInfoVo> userInfo(@PathVariable String openid){
        return wxMyService.userInfo(openid);
    }
    @ApiOperation("修改基本信息")
    @PostMapping("userInfo")
    public Result saveUserInfo(SaveUserInfoDto dto){
        return wxMyService.saveUserInfo(dto);
    }

}
