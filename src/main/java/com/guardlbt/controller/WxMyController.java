package com.guardlbt.controller;

import com.guardlbt.common.util.Result;
import com.guardlbt.dto.ApplyShopDto;
import com.guardlbt.dto.BusinessDistrictPageDto;
import com.guardlbt.dto.SaveUserInfoDto;
import com.guardlbt.eum.Role;
import com.guardlbt.service.WxMyService;
import com.guardlbt.vo.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api")
@RestController
@Api(value = "小程序我的页面接口", tags = "小程序我的页面接口")
public class WxMyController {

    @Autowired
    private WxMyService wxMyService;

    @ApiOperation("获取当前用户角色")
    @GetMapping("getRole/{openid}")
    public Result<Role> getRole(@PathVariable String openid) {
        return wxMyService.getRole(openid);
    }


    @ApiOperation("查看本人基本信息")
    @GetMapping("userInfo/{openid}")
    public Result<UserInfoVo> userInfo(@PathVariable String openid) {
        return wxMyService.userInfo(openid);
    }

    @ApiOperation("修改基本信息")
    @PostMapping("userInfo")
    public Result saveUserInfo( @RequestBody @Validated SaveUserInfoDto dto) {
        return wxMyService.saveUserInfo(dto);
    }

    @ApiOperation("申请店铺")
    @PostMapping("applyShop")
    public Result applyShop(ApplyShopDto dto){
        return wxMyService.applyShop(dto);
    }

    @ApiOperation("根据经纬度获取所有前10个商圈")
    @PostMapping("businessDistrict")
    public Result<BusinessDistrictPageVo> businessDistrict( @RequestBody @Validated BusinessDistrictPageDto dto){
        return wxMyService.businessDistrict(dto);
    }

    @ApiOperation("根据商圈查所有店铺")
    @GetMapping("shops/{businessDistrictId}")
    public Result<ShopsVo> shops(@PathVariable String businessDistrictId){
        return wxMyService.shops(businessDistrictId);
    }

}
