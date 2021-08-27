package com.guardlbt.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.guardlbt.dao.PictureDao;
import com.guardlbt.entity.Picture;
import com.guardlbt.service.PictureService;
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
* 图片管理方法实现类
* Created by 代码自动生成.
* 时间:2021-08-26 16:20:27
*/
@Service
@Transactional
public class PictureServiceImpl implements PictureService {

    @Autowired
    private PictureDao dao;

    @Override
    public Result findPagePicture(PicturePageDto dto) {
        PageResult pageResult=new PageResult();
        PageHelper.startPage(dto.getPageNumber(),dto.getPageSize());
        Picture picture=new Picture();
        BeanUtils.copyProperties(dto,picture);
        List<Picture> list = dao.selectPictures(picture);
        PageInfo<Picture> info=new PageInfo<>(list);
        pageResult.setTotle(info.getTotal());
        pageResult.setPageSize(dto.getPageSize());
        pageResult.setPageNumber(dto.getPageNumber());
        //转换vo出去
        List<PicturePageVo> vos = info.getList().stream().map(l -> {
            PicturePageVo vo = new PicturePageVo();
            BeanUtils.copyProperties(l, vo);
            return vo;
        }).collect(Collectors.toList());
        pageResult.setPages(vos);
        return Result.ok(pageResult);
    }

    @Override
    public Result getAll() {
        List<Picture> pictures = dao.selectPictures(null);
        return Result.ok(pictures);
    }
        
    @Override
    public Result findAllByPicture(Picture picture) {
        List<Picture> pictures = dao.selectPictures(picture);
        //转换vo出去
        List<PicturePageVo> vos = pictures.stream().map(l -> {
        PicturePageVo vo = new PicturePageVo();
        BeanUtils.copyProperties(l, vo);
        return vo;
        }).collect(Collectors.toList());
        return Result.ok(vos);
    }

    @Override
    public Picture findPicture(Picture picture) {
        List<Picture> list = dao.selectPictures(picture);
        if(!list.isEmpty()){
            return list.get(0);
        }
        return null;
    }

    @Override
    public Result insert(PictureSaveDto dto) {
        Picture picture=new Picture();
        BeanUtils.copyProperties(dto,picture);
        picture.setId(UuidUtild.getUUID());
        try{
            dao.insert(picture);
            return Result.ok();
        }catch (Exception e){
            e.printStackTrace();
            return Result.error(500,e.getCause().getMessage());
        }
    }

    @Override
    public Result update(PictureUpdateDto dto) {
        Picture picture=new Picture();
        BeanUtils.copyProperties(dto,picture);
        try{
            dao.update(picture);
            return Result.ok();
        }catch (Exception e){
            e.printStackTrace();
            return Result.error(500,e.getCause().getMessage());
        }
    }

    @Override
    public Result delete(Picture picture) {
        try{
            dao.delete(picture);
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
    public Result getById(String id) {
        Picture picture=new Picture();
        picture.setId(id);
        List<Picture> pictures = dao.selectPictures(picture);
        if(pictures.isEmpty()){
            return Result.ok();
        }
        return Result.ok(pictures.get(0));
    }
}
