package com.guardlbt.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.guardlbt.dao.GoodsDao;
import com.guardlbt.entity.Goods;
import com.guardlbt.service.GoodsService;
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
* 商品方法实现类
* Created by 代码自动生成.
* 时间:2021-08-26 16:20:27
*/
@Service
@Transactional
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsDao dao;

    @Override
    public Result findPageGoods(GoodsPageDto dto) {
        PageResult pageResult=new PageResult();
        PageHelper.startPage(dto.getPageNumber(),dto.getPageSize());
        Goods goods=new Goods();
        BeanUtils.copyProperties(dto,goods);
        List<Goods> list = dao.selectGoodss(goods);
        PageInfo<Goods> info=new PageInfo<>(list);
        pageResult.setTotle(info.getTotal());
        pageResult.setPageSize(dto.getPageSize());
        pageResult.setPageNumber(dto.getPageNumber());
        //转换vo出去
        List<GoodsPageVo> vos = info.getList().stream().map(l -> {
            GoodsPageVo vo = new GoodsPageVo();
            BeanUtils.copyProperties(l, vo);
            return vo;
        }).collect(Collectors.toList());
        pageResult.setPages(vos);
        return Result.ok(pageResult);
    }

    @Override
    public Result getAll() {
        List<Goods> goodss = dao.selectGoodss(null);
        return Result.ok(goodss);
    }
        
    @Override
    public Result findAllByGoods(Goods goods) {
        List<Goods> goodss = dao.selectGoodss(goods);
        //转换vo出去
        List<GoodsPageVo> vos = goodss.stream().map(l -> {
        GoodsPageVo vo = new GoodsPageVo();
        BeanUtils.copyProperties(l, vo);
        return vo;
        }).collect(Collectors.toList());
        return Result.ok(vos);
    }

    @Override
    public Goods findGoods(Goods goods) {
        List<Goods> list = dao.selectGoodss(goods);
        if(!list.isEmpty()){
            return list.get(0);
        }
        return null;
    }

    @Override
    public Result insert(GoodsSaveDto dto) {
        Goods goods=new Goods();
        BeanUtils.copyProperties(dto,goods);
        goods.setGoodsId(UuidUtild.getUUID());
        try{
            dao.insert(goods);
            return Result.ok();
        }catch (Exception e){
            e.printStackTrace();
            return Result.error(500,e.getCause().getMessage());
        }
    }

    @Override
    public Result update(GoodsUpdateDto dto) {
        Goods goods=new Goods();
        BeanUtils.copyProperties(dto,goods);
        try{
            dao.update(goods);
            return Result.ok();
        }catch (Exception e){
            e.printStackTrace();
            return Result.error(500,e.getCause().getMessage());
        }
    }

    @Override
    public Result delete(Goods goods) {
        try{
            dao.delete(goods);
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
    public Result getById(String goodsId) {
        Goods goods=new Goods();
        goods.setGoodsId(goodsId);
        List<Goods> goodss = dao.selectGoodss(goods);
        if(goodss.isEmpty()){
            return Result.ok();
        }
        return Result.ok(goodss.get(0));
    }
}
