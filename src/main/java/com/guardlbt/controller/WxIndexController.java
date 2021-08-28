package com.guardlbt.controller;

import com.guardlbt.common.util.Result;
import com.guardlbt.dto.MemberSaveDto;
import com.guardlbt.dto.ReportSiteSaveDto;
import com.guardlbt.dto.UseCouponDto;
import com.guardlbt.service.WxIndexService;
import com.guardlbt.vo.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
@Api(value = "小程序登陆及首页接口",tags = "小程序登陆及首页接口")
public class WxIndexController {

    @Autowired
    private WxIndexService wxIndexService;

    /**
     * 登录凭证校验。通过 wx.login 接口获得临时登录凭证 code 后传到开发者服务器调用此接口完成登录流程
     *
     * @param code 前端获取到的code
     * @return openid
     */
    @ApiOperation(value = "小程序登陆", notes = "拿着code换取openid")
    @GetMapping("login/{code}")
    public Result<String> code2SessionVo(@PathVariable String code) {
        return wxIndexService.login(code);
    }

    @ApiOperation(value = "小程序上传用户信息", notes = "小程序上传用户信息")
    @PostMapping("getUserInfo")
    public Result getUserInfo(@RequestBody @Validated MemberSaveDto memberSaveDto) {
        return wxIndexService.getUserInfo(memberSaveDto);
    }

    @ApiOperation(value = "定位（确定商超位置）")
    @PostMapping("reportSite")
    public Result reportSite(@RequestBody @Validated ReportSiteSaveDto reportSiteSaveDto) {
        return wxIndexService.reportSite(reportSiteSaveDto);
    }

    @ApiOperation("轮播图")
    @GetMapping("indexImage")
    public Result<IndexImagesPageVo> getIndexImage() {
        return wxIndexService.getIndexImage();
    }

    @ApiOperation("店铺列表")
    @GetMapping("indexShop")
    public Result<ShopPageVo> indexShop() {
        return wxIndexService.indexShop();
    }

    @ApiOperation("代金券列表")
    @GetMapping("indexCoupon")
    public Result<CouponPageVo> indexCoupon() {
        return wxIndexService.indexCoupon();
    }

    @ApiOperation("浏览店铺信息")
    @GetMapping("shopInfo/{shopId}")
    public Result<ShopVo> shopInfo(@PathVariable String shopId){
        return wxIndexService.shopInfo(shopId);
    }

    @ApiOperation("浏览店铺内套餐")
    @GetMapping("shopGoods/{shopId}")
    public Result<GoodsPageVo> shopGoods(@PathVariable String shopId){
        return wxIndexService.shopGoods(shopId);
    }

    @ApiOperation("浏览店铺代金券")
    @GetMapping("shopCoupon/{shopId}")
    public Result<ShopPageVo> shopCoupon(@PathVariable String shopId){
        return wxIndexService.shopCoupon(shopId);
    }

    @ApiOperation("无门槛领取代金券")
    @PostMapping("useCoupon")
    public Result useCoupon(@RequestBody @Validated UseCouponDto useCouponDto){
        return wxIndexService.useCoupon(useCouponDto);
    }
}
