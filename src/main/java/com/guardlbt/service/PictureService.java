package com.guardlbt.service;

import com.guardlbt.entity.Picture;
import com.guardlbt.dto.*;
import com.guardlbt.common.util.*;

import java.util.*;

/**
* 图片管理方法类接口
* Created by 代码自动生成.
* 时间:2021-08-25 18:06:24
*/
public interface PictureService {
    /**
    * 分页查询
    * @param dto 条件参数
    * @return easyui结果集
    */
    Result findPagePicture( PicturePageDto dto);

    /**
    * 获取所有商圈
    * @return
    */
    Result getAll();

    /**
    * 条件查询全部数据
    * @param picture 条件参数
    * @return 国全部数据
    */
    Result findAllByPicture(Picture picture);

    /**
    * 根据条件,只查询唯一一个值,如果存在多个只返回第一个
    * @param picture 条件参数
    * @return Picture对象
    */
    Picture findPicture(Picture picture);

    /**
    * 添加图片管理
    * @param dto 条件参数
    * @return 结果集
    */
    Result insert(PictureSaveDto dto);
    /**
    * 修改图片管理
    * @param dto 条件参数
    * @return 结果集
    */
    Result update(PictureUpdateDto dto);
    /**
    * 删除图片管理
    * @param picture 条件参数
    * @return 结果集
    */
    Result delete(Picture picture);
    /**
    * 批量删除图片管理
    * @param ids 以逗号隔开的主键字符串,对于单个id也适用
    * @return 结果集
    */
    Result deleteAll(String ids);
    /**
    * 根据id查询图片管理
    * @param id
    * @return
    */
    Result getById(String id);
}
