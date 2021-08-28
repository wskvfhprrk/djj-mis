package com.guardlbt.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.guardlbt.dao.ShopDao;
import com.guardlbt.entity.Shop;
import com.guardlbt.service.ShopService;
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
* 商店方法实现类
* Created by 代码自动生成.
* 时间:2021-08-28 11:42:13
*/
@Service
@Transactional
public class ShopServiceImpl implements ShopService {

    @Autowired
    private ShopDao dao;

    @Override
    public Result findPageShop(ShopPageDto dto) {
        PageResult pageResult=new PageResult();
        PageHelper.startPage(dto.getPageNumber(),dto.getPageSize());
        Shop shop=new Shop();
        BeanUtils.copyProperties(dto,shop);
        List<Shop> list = dao.selectShops(shop);
        PageInfo<Shop> info=new PageInfo<>(list);
        pageResult.setTotle(info.getTotal());
        pageResult.setPageSize(dto.getPageSize());
        pageResult.setPageNumber(dto.getPageNumber());
        //转换vo出去
        List<ShopPageVo> vos = info.getList().stream().map(l -> {
            ShopPageVo vo = new ShopPageVo();
            BeanUtils.copyProperties(l, vo);
            return vo;
        }).collect(Collectors.toList());
        pageResult.setPages(vos);
        return Result.ok(pageResult);
    }

    @Override
    public Result getAll() {
        List<Shop> shops = dao.selectShops(null);
        return Result.ok(shops);
    }
        
    @Override
    public Result findAllByShop(Shop shop) {
        List<Shop> shops = dao.selectShops(shop);
        //转换vo出去
        List<ShopPageVo> vos = shops.stream().map(l -> {
        ShopPageVo vo = new ShopPageVo();
        BeanUtils.copyProperties(l, vo);
        return vo;
        }).collect(Collectors.toList());
        return Result.ok(vos);
    }

    @Override
    public Shop findShop(Shop shop) {
        List<Shop> list = dao.selectShops(shop);
        if(!list.isEmpty()){
            return list.get(0);
        }
        return null;
    }

    @Override
    public Result insert(ShopSaveDto dto) {
        Shop shop=new Shop();
        BeanUtils.copyProperties(dto,shop);
        shop.setShopId(UuidUtild.getUUID());
        try{
            dao.insert(shop);
            return Result.ok();
        }catch (Exception e){
            e.printStackTrace();
            return Result.error(500,e.getCause().getMessage());
        }
    }

    @Override
    public Result update(ShopUpdateDto dto) {
        Shop shop=new Shop();
        BeanUtils.copyProperties(dto,shop);
        try{
            dao.update(shop);
            return Result.ok();
        }catch (Exception e){
            e.printStackTrace();
            return Result.error(500,e.getCause().getMessage());
        }
    }

    @Override
    public Result delete(Shop shop) {
        try{
            dao.delete(shop);
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
    public Result getById(String shopId) {
        Shop shop=new Shop();
        shop.setShopId(shopId);
        List<Shop> shops = dao.selectShops(shop);
        if(shops.isEmpty()){
            return Result.ok();
        }
        return Result.ok(shops.get(0));
    }
}
