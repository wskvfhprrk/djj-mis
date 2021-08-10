package guardlbt.service;

import guardlbt.common.util.PageResult;
import guardlbt.common.util.Result;
import guardlbt.dto.SelectCouponPageDto;
import guardlbt.dto.SelectWinningDto;
import guardlbt.dto.ValiteCodedto;
import guardlbt.vo.SelectCouponPageVo;

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
