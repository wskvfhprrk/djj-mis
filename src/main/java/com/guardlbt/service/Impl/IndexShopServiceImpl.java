package com.guardlbt.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.guardlbt.dao.IndexShopDao;
import com.guardlbt.entity.IndexShop;
import com.guardlbt.service.IndexShopService;
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
* 首页促销店铺方法实现类
* Created by 代码自动生成.
* 时间:2021-08-27 13:42:56
*/
@Service
@Transactional
public class IndexShopServiceImpl implements IndexShopService {

    @Autowired
    private IndexShopDao dao;

    @Override
    public Result findPageIndexShop(IndexShopPageDto dto) {
        PageResult pageResult=new PageResult();
        PageHelper.startPage(dto.getPageNumber(),dto.getPageSize());
        IndexShop indexShop=new IndexShop();
        BeanUtils.copyProperties(dto,indexShop);
        List<IndexShop> list = dao.selectIndexShops(indexShop);
        PageInfo<IndexShop> info=new PageInfo<>(list);
        pageResult.setTotle(info.getTotal());
        pageResult.setPageSize(dto.getPageSize());
        pageResult.setPageNumber(dto.getPageNumber());
        //转换vo出去
        List<IndexShopPageVo> vos = info.getList().stream().map(l -> {
            IndexShopPageVo vo = new IndexShopPageVo();
            BeanUtils.copyProperties(l, vo);
            return vo;
        }).collect(Collectors.toList());
        pageResult.setPages(vos);
        return Result.ok(pageResult);
    }

    @Override
    public Result getAll() {
        List<IndexShop> indexShops = dao.selectIndexShops(null);
        return Result.ok(indexShops);
    }
        
    @Override
    public Result findAllByIndexShop(IndexShop indexShop) {
        List<IndexShop> indexShops = dao.selectIndexShops(indexShop);
        //转换vo出去
        List<IndexShopPageVo> vos = indexShops.stream().map(l -> {
        IndexShopPageVo vo = new IndexShopPageVo();
        BeanUtils.copyProperties(l, vo);
        return vo;
        }).collect(Collectors.toList());
        return Result.ok(vos);
    }

    @Override
    public IndexShop findIndexShop(IndexShop indexShop) {
        List<IndexShop> list = dao.selectIndexShops(indexShop);
        if(!list.isEmpty()){
            return list.get(0);
        }
        return null;
    }

    @Override
    public Result insert(IndexShopSaveDto dto) {
        IndexShop indexShop=new IndexShop();
        BeanUtils.copyProperties(dto,indexShop);
        //todo 此处报错的原因是数据库设计不合理，主键是数据类型，但不是自增的，请修改数据结构为自增类型，如果确实需要数据不自增，请修错误代码！
        //indexShop.setSorting(UuidUtild.getUUID());
        try{
            dao.insert(indexShop);
            return Result.ok();
        }catch (Exception e){
            e.printStackTrace();
            return Result.error(500,e.getCause().getMessage());
        }
    }

    @Override
    public Result update(IndexShopUpdateDto dto) {
        IndexShop indexShop=new IndexShop();
        BeanUtils.copyProperties(dto,indexShop);
        try{
            dao.update(indexShop);
            return Result.ok();
        }catch (Exception e){
            e.printStackTrace();
            return Result.error(500,e.getCause().getMessage());
        }
    }

    @Override
    public Result delete(IndexShop indexShop) {
        try{
            dao.delete(indexShop);
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
    public Result getById(Integer sorting) {
        IndexShop indexShop=new IndexShop();
        indexShop.setSorting(sorting);
        List<IndexShop> indexShops = dao.selectIndexShops(indexShop);
        if(indexShops.isEmpty()){
            return Result.ok();
        }
        return Result.ok(indexShops.get(0));
    }
}
