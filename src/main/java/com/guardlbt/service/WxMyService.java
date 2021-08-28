package com.guardlbt.service;

import com.guardlbt.common.util.Result;
import com.guardlbt.dto.ApplyShopDto;
import com.guardlbt.dto.BusinessDistrictPageDto;
import com.guardlbt.dto.SaveUserInfoDto;
import com.guardlbt.eum.Role;
import com.guardlbt.vo.BusinessDistrictPageVo;
import com.guardlbt.vo.ShopsVo;
import com.guardlbt.vo.UserInfoVo;

public interface WxMyService {
    Result<Role> getRole(String openid);

    Result<UserInfoVo> userInfo(String openid);

    Result saveUserInfo(SaveUserInfoDto dto);

    Result applyShop(ApplyShopDto dto);

    Result<BusinessDistrictPageVo> businessDistrict(BusinessDistrictPageDto businessDistrictPageDto);

    Result<ShopsVo> shops(String businessDistrictId);
}
