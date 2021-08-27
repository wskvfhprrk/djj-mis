package com.guardlbt.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.guardlbt.dao.ShopUserDao;
import com.guardlbt.entity.ShopUser;
import com.guardlbt.service.ShopUserService;
import com.guardlbt.util.*;
import com.guardlbt.common.util.*;
import com.guardlbt.dto.*;
import com.guardlbt.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;


/**
* 商店管理员方法实现类
* Created by 代码自动生成.
* 时间:2021-08-27 13:42:55
*/
@Service
@Transactional
public class ShopUserServiceImpl implements ShopUserService {

    @Autowired
    private ShopUserDao dao;

    @Override
    public Result findPageShopUser(ShopUserPageDto dto) {
        PageResult pageResult=new PageResult();
        PageHelper.startPage(dto.getPageNumber(),dto.getPageSize());
        ShopUser shopUser=new ShopUser();
        BeanUtils.copyProperties(dto,shopUser);
        List<ShopUser> list = dao.selectShopUsers(shopUser);
        PageInfo<ShopUser> info=new PageInfo<>(list);
        pageResult.setTotle(info.getTotal());
        pageResult.setPageSize(dto.getPageSize());
        pageResult.setPageNumber(dto.getPageNumber());
        //转换vo出去
        List<ShopUserPageVo> vos = info.getList().stream().map(l -> {
            ShopUserPageVo vo = new ShopUserPageVo();
            BeanUtils.copyProperties(l, vo);
            return vo;
        }).collect(Collectors.toList());
        pageResult.setPages(vos);
        return Result.ok(pageResult);
    }

    @Override
    public Result getAll() {
        List<ShopUser> shopUsers = dao.selectShopUsers(null);
        return Result.ok(shopUsers);
    }
        
    @Override
    public Result findAllByShopUser(ShopUser shopUser) {
        List<ShopUser> shopUsers = dao.selectShopUsers(shopUser);
        //转换vo出去
        List<ShopUserPageVo> vos = shopUsers.stream().map(l -> {
        ShopUserPageVo vo = new ShopUserPageVo();
        BeanUtils.copyProperties(l, vo);
        return vo;
        }).collect(Collectors.toList());
        return Result.ok(vos);
    }

    @Override
    public ShopUser findShopUser(ShopUser shopUser) {
        List<ShopUser> list = dao.selectShopUsers(shopUser);
        if(!list.isEmpty()){
            return list.get(0);
        }
        return null;
    }

    @Override
    public Result insert(ShopUserSaveDto dto) {
        ShopUser shopUser=new ShopUser();
        BeanUtils.copyProperties(dto,shopUser);
        shopUser.setUserId(UuidUtild.getUUID());
        try{
            dao.insert(shopUser);
            return Result.ok();
        }catch (Exception e){
            e.printStackTrace();
            return Result.error(500,e.getCause().getMessage());
        }
    }

    @Override
    public Result update(ShopUserUpdateDto dto) {
        ShopUser shopUser=new ShopUser();
        BeanUtils.copyProperties(dto,shopUser);
        try{
            dao.update(shopUser);
            return Result.ok();
        }catch (Exception e){
            e.printStackTrace();
            return Result.error(500,e.getCause().getMessage());
        }
    }

    @Override
    public Result delete(ShopUser shopUser) {
        try{
            dao.delete(shopUser);
            return Result.ok();
        }catch (Exception e){
            e.printStackTrace();
            return Result.error(500,e.getCause().getMessage());
        }
    }

    @Override
    public Result deleteAll(String ids) {
        try{
            String[] strings = ids.split(",");
            List<String> list=new ArrayList<>();
            for (int i = 0; i <strings.length ; i++) {
                list.add(strings[i]);
            }
            dao.deleteAll(list);
            return Result.ok();
        }catch (Exception e){
            e.printStackTrace();
            return Result.error(500,e.getCause().getMessage());
        }
    }

    @Override
    public Result getById(String userId) {
        ShopUser shopUser=new ShopUser();
        shopUser.setUserId(userId);
        List<ShopUser> shopUsers = dao.selectShopUsers(shopUser);
        if(shopUsers.isEmpty()){
            return Result.ok();
        }
        return Result.ok(shopUsers.get(0));
    }
}
