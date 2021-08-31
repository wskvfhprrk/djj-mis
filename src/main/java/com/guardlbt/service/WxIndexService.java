package com.guardlbt.service;


import com.guardlbt.common.util.Result;
import com.guardlbt.dto.ReportSiteSaveDto;
import com.guardlbt.dto.UseCouponDto;
import com.guardlbt.vo.*;
import com.guardlbt.wx.vo.GetAccessTokenVo;

/**
 * 调用微信通用接口
 */

public interface WxIndexService {
    /**
     * 登录凭证校验。通过 wx.login 接口获得临时登录凭证 code 后传到开发者服务器调用此接口完成登录流程
     * @param code 前端获取到的code
     * @return 会话密钥 session_key 是对用户数据进行 加密签名 的密钥。为了应用自身的数据安全，开发者服务器不应该把会话密钥下发到小程序，也不应该对外提供这个密钥。
     * @throws Exception
     */
    Result<String> login(String code) ;

    /**
     * 获取accessToken
     * @return
     * @throws Exception
     */
    GetAccessTokenVo getAccessToken() throws  Exception;

//    Result getUserInfo(MemberSaveDto memberSaveDto);

    Result reportSite(ReportSiteSaveDto reportSiteSaveDto);

    Result<IndexImagesPageVo> getIndexImage();

    Result<ShopPageVo> indexShop();

    Result<CouponPageVo> indexCoupon(String openid);

    Result<ShopVo> shopInfo(String shopId);

    Result<ShopPageVo> shopCoupon(String shopId);

    Result useCoupon(UseCouponDto useCouponDto);

    Result<GoodsPageVo> shopGoods(String shopId);
}
