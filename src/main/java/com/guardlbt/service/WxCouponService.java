package com.guardlbt.service;

import com.guardlbt.common.util.PageResult;
import com.guardlbt.common.util.Result;
import com.guardlbt.dto.CouponPageDto;
import com.guardlbt.vo.CouponHistoryPageVo;
import com.guardlbt.vo.CouponPageVo;

import java.util.List;

public interface WxCouponService {
    Result<PageResult<List<CouponPageVo>>> couponList(CouponPageDto dto);

    Result<List<CouponHistoryPageVo>> getCouponHistory(String couponId);
}
