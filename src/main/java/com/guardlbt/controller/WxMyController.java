package com.guardlbt.controller;

import com.guardlbt.common.util.Result;
import com.guardlbt.eum.Role;
import com.guardlbt.service.WxMyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
