package guardlbt.controller;

import guardlbt.common.util.PageResult;
import guardlbt.common.util.Result;
import guardlbt.common.util.TokenUtil;
import guardlbt.dto.SelectCouponPageDto;
import guardlbt.dto.SelectWinningDto;
import guardlbt.service.CouponService;
import guardlbt.vo.SelectCouponPageVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

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
