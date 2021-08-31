package com.guardlbt.controller;

import com.guardlbt.common.util.PageResult;
import com.guardlbt.common.util.Result;
import com.guardlbt.dto.CouponPageDto;
import com.guardlbt.dto.ShareCouponDto;
import com.guardlbt.service.WxCouponService;
import com.guardlbt.vo.CouponHistoryPageVo;
import com.guardlbt.vo.CouponPageVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
@Api(value = "小程序优惠券页面接口", tags = "小程序优惠券页面接口")
public class wxCouponController {

    @Autowired
    private WxCouponService wxCouponService;

    @ApiOperation("代金券分页查询列表")
    @PostMapping("couponList")
    public Result<PageResult<List<CouponPageVo>>> couponList(@RequestBody @Validated CouponPageDto dto) {
        return wxCouponService.couponList(dto);
    }

    @ApiOperation("历史记录")
    @GetMapping("getCouponHistory/{couponId}")
    public Result<List<CouponHistoryPageVo>> getCouponHistory(@PathVariable String couponId){
        return wxCouponService.getCouponHistory(couponId);
    }

    @ApiOperation("分享转让代金券")
    @PostMapping("shareCoupon")
    public Result shareCoupon(ShareCouponDto dto){
        return wxCouponService.shareCoupon(dto);
    }
}
