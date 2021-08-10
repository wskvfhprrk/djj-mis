package com.guardlbt.controller;

import com.guardlbt.common.util.PageResult;
import com.guardlbt.common.util.Result;
import com.guardlbt.common.util.TokenUtil;
import com.guardlbt.dto.SelectCouponPageDto;
import com.guardlbt.dto.SelectWinningDto;
import com.guardlbt.service.CouponService;
import com.guardlbt.vo.SelectCouponPageVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by 代码自动生成.
 * 时间:2019-03-27 16:54:21
 */
@Api("电子卷管理控制器")
@RestController
@Slf4j
public class CouponController {

    @Autowired
    private CouponService service;

    @GetMapping("coupon")
    @ApiOperation("分页查询电子卷——查询电子卷：创建时间倒序排列")
    public Result<PageResult<List<SelectCouponPageVo>>> selectCouponPage(HttpServletRequest request, @Validated SelectCouponPageDto selectCouponPageDto) {
        log.info("分页查询电子卷：coupon: {})", selectCouponPageDto);
        return service.selectCouponPage(TokenUtil.getToken(request), selectCouponPageDto);
    }

    @GetMapping("winning")
    public Result selectWinning(@Validated SelectWinningDto dto){
        log.info("分页查询电子卷：coupon: {})", dto);
        return service.selectWinning(dto);
    }

    @GetMapping("recod/{winningCode}")
    public Result getRecodById(@PathVariable String winningCode){
        return service.getRecodById(winningCode);
    }

    @PutMapping("isWinning/{winningCode}")
    public Result updateIsWining(@PathVariable String winningCode){
        Result result = service.updateIsWining(winningCode);
        return result;
    }

}
