package com.guardlbt.service;

import com.guardlbt.entity.IndexImages;
import com.guardlbt.dto.*;
import com.guardlbt.common.util.*;

import java.util.*;

/**
* 轮播图方法类接口
* Created by 代码自动生成.
* 时间:2021-08-28 11:42:16
*/
public interface IndexImagesService {
    /**
    * 分页查询
    * @param dto 条件参数
    * @return easyui结果集
    */
    Result findPageIndexImages( IndexImagesPageDto dto);

    /**
    * 获取所有商圈
    * @return
    */
    Result getAll();

    /**
    * 条件查询全部数据
    * @param indexImages 条件参数
    * @return 国全部数据
    */
    Result findAllByIndexImages(IndexImages indexImages);

    /**
    * 根据条件,只查询唯一一个值,如果存在多个只返回第一个
    * @param indexImages 条件参数
    * @return IndexImages对象
    */
    IndexImages findIndexImages(IndexImages indexImages);

    /**
    * 添加轮播图
    * @param dto 条件参数
    * @return 结果集
    */
    Result insert(IndexImagesSaveDto dto);
    /**
    * 修改轮播图
    * @param dto 条件参数
    * @return 结果集
    */
    Result update(IndexImagesUpdateDto dto);
    /**
    * 删除轮播图
    * @param indexImages 条件参数
    * @return 结果集
    */
    Result delete(IndexImages indexImages);
    /**
    * 批量删除轮播图
    * @param ids 以逗号隔开的主键字符串,对于单个id也适用
    * @return 结果集
    */
    Result deleteAll(String ids);
    /**
    * 根据id查询轮播图
    * @param id
    * @return
    */
    Result getById(Integer id);
}
