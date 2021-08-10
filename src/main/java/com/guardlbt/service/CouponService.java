package com.guardlbt.service;

import com.guardlbt.common.util.PageResult;
import com.guardlbt.common.util.Result;
import com.guardlbt.dto.*;
import com.guardlbt.vo.SelectCouponByCouponIdVo;
import com.guardlbt.vo.SelectCouponPageVo;

import java.util.List;

public interface CouponService {


    Result<PageResult<List<SelectCouponPageVo>>> selectCouponPage(String token, SelectCouponPageDto selectCouponPageDto);


    /**
     * 验证促销卷
     * @param dto
     * @return
     */
    Result valiteCode(ValiteCodedto dto);

    Result selectWinning(SelectWinningDto dto);

    Result getRecodById(String winningCode);

    Result updateIsWining(String winningCode);
}
