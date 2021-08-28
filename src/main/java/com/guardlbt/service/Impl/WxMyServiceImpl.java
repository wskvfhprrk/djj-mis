package com.guardlbt.service.Impl;

import com.guardlbt.common.util.Result;
import com.guardlbt.dao.ShopUserDao;
import com.guardlbt.dto.SaveUserInfoDto;
import com.guardlbt.entity.ShopUser;
import com.guardlbt.eum.Role;
import com.guardlbt.service.WxMyService;
import com.guardlbt.vo.UserInfoVo;
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

    @Override
    public Result<UserInfoVo> userInfo(String openid) {
        //查看会员表中的信息
        return null;
    }

    @Override
    public Result saveUserInfo(SaveUserInfoDto dto) {
        //修改会员信息，如果是shopuser也要修改里面的信息
        return null;
    }
}
