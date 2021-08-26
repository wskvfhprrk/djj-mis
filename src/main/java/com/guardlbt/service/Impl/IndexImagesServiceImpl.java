package com.guardlbt.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.guardlbt.dao.IndexImagesDao;
import com.guardlbt.entity.IndexImages;
import com.guardlbt.service.IndexImagesService;
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
* 轮播图方法实现类
* Created by 代码自动生成.
* 时间:2021-08-25 18:06:23
*/
@Service
@Transactional
public class IndexImagesServiceImpl implements IndexImagesService {

    @Autowired
    private IndexImagesDao dao;

    @Override
    public Result findPageIndexImages(IndexImagesPageDto dto) {
        PageResult pageResult=new PageResult();
        PageHelper.startPage(dto.getPageNumber(),dto.getPageSize());
        IndexImages indexImages=new IndexImages();
        BeanUtils.copyProperties(dto,indexImages);
        List<IndexImages> list = dao.selectIndexImagess(indexImages);
        PageInfo<IndexImages> info=new PageInfo<>(list);
        pageResult.setTotle(info.getTotal());
        pageResult.setPageSize(dto.getPageSize());
        pageResult.setPageNumber(dto.getPageNumber());
        //转换vo出去
        List<IndexImagesPageVo> vos = info.getList().stream().map(l -> {
            IndexImagesPageVo vo = new IndexImagesPageVo();
            BeanUtils.copyProperties(l, vo);
            return vo;
        }).collect(Collectors.toList());
        pageResult.setPages(vos);
        return Result.ok(pageResult);
    }

    @Override
    public Result getAll() {
        List<IndexImages> indexImagess = dao.selectIndexImagess(null);
        return Result.ok(indexImagess);
    }
        
    @Override
    public Result findAllByIndexImages(IndexImages indexImages) {
        List<IndexImages> indexImagess = dao.selectIndexImagess(indexImages);
        //转换vo出去
        List<IndexImagesPageVo> vos = indexImagess.stream().map(l -> {
        IndexImagesPageVo vo = new IndexImagesPageVo();
        BeanUtils.copyProperties(l, vo);
        return vo;
        }).collect(Collectors.toList());
        return Result.ok(vos);
    }

    @Override
    public IndexImages findIndexImages(IndexImages indexImages) {
        List<IndexImages> list = dao.selectIndexImagess(indexImages);
        if(!list.isEmpty()){
            return list.get(0);
        }
        return null;
    }

    @Override
    public Result insert(IndexImagesSaveDto dto) {
        IndexImages indexImages=new IndexImages();
        BeanUtils.copyProperties(dto,indexImages);
        
        try{
            dao.insert(indexImages);
            return Result.ok();
        }catch (Exception e){
            e.printStackTrace();
            return Result.error(500,e.getCause().getMessage());
        }
    }

    @Override
    public Result update(IndexImagesUpdateDto dto) {
        IndexImages indexImages=new IndexImages();
        BeanUtils.copyProperties(dto,indexImages);
        try{
            dao.update(indexImages);
            return Result.ok();
        }catch (Exception e){
            e.printStackTrace();
            return Result.error(500,e.getCause().getMessage());
        }
    }

    @Override
    public Result delete(IndexImages indexImages) {
        try{
            dao.delete(indexImages);
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
    public Result getById(Integer id) {
        IndexImages indexImages=new IndexImages();
        indexImages.setId(id);
        List<IndexImages> indexImagess = dao.selectIndexImagess(indexImages);
        if(indexImagess.isEmpty()){
            return Result.ok();
        }
        return Result.ok(indexImagess.get(0));
    }
}
