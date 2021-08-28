package com.guardlbt.service;

import com.guardlbt.common.util.Result;
import com.guardlbt.eum.Role;

public interface WxMyService {
    Result<Role> getRole(String openid);
}
