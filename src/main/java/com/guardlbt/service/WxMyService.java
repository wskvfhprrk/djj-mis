package com.guardlbt.service;

import com.guardlbt.common.util.Result;
import com.guardlbt.dto.SaveUserInfoDto;
import com.guardlbt.eum.Role;
import com.guardlbt.vo.UserInfoVo;

public interface WxMyService {
    Result<Role> getRole(String openid);

    Result<UserInfoVo> userInfo(String openid);

    Result saveUserInfo(SaveUserInfoDto dto);
}
