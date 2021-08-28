package com.guardlbt.service.Impl;

import com.guardlbt.common.util.Result;
import com.guardlbt.dao.ShopUserDao;
import com.guardlbt.entity.ShopUser;
import com.guardlbt.eum.Role;
import com.guardlbt.service.WxMyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class WxMyServiceImpl implements WxMyService {
    @Autowired
    private ShopUserDao shopUserDao;
    @Override
    public Result<Role> getRole(String openid) {
        ShopUser shopUser=new ShopUser();
        shopUser.setOpenId(openid);
        List<ShopUser> shopUsers = shopUserDao.selectShopUsers(shopUser);
        if(shopUsers.isEmpty()){
            return Result.ok(Role.MEMBER);
        }
        for (Role role : Role.values()) {
            if (role.getState() == shopUsers.get(0).getRole()) {
                return Result.ok(role);
            }
        }
        return Result.ok();
    }
}
