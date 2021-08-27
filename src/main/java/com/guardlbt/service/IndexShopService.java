package com.guardlbt.service;

import com.guardlbt.entity.IndexShop;
import com.guardlbt.dto.*;
import com.guardlbt.common.util.*;

import java.util.*;

/**
* 首页促销店铺方法类接口
* Created by 代码自动生成.
* 时间:2021-08-27 13:42:56
*/
public interface IndexShopService {
    /**
    * 分页查询
    * @param dto 条件参数
    * @return easyui结果集
    */
    Result findPageIndexShop( IndexShopPageDto dto);

    /**
    * 获取所有商圈
    * @return
    */
    Result getAll();

    /**
    * 条件查询全部数据
    * @param indexShop 条件参数
    * @return 国全部数据
    */
    Result findAllByIndexShop(IndexShop indexShop);

    /**
    * 根据条件,只查询唯一一个值,如果存在多个只返回第一个
    * @param indexShop 条件参数
    * @return IndexShop对象
    */
    IndexShop findIndexShop(IndexShop indexShop);

    /**
    * 添加首页促销店铺
    * @param dto 条件参数
    * @return 结果集
    */
    Result insert(IndexShopSaveDto dto);
    /**
    * 修改首页促销店铺
    * @param dto 条件参数
    * @return 结果集
    */
    Result update(IndexShopUpdateDto dto);
    /**
    * 删除首页促销店铺
    * @param indexShop 条件参数
    * @return 结果集
    */
    Result delete(IndexShop indexShop);
    /**
    * 批量删除首页促销店铺
    * @param ids 以逗号隔开的主键字符串,对于单个id也适用
    * @return 结果集
    */
    Result deleteAll(String ids);
    /**
    * 根据id查询首页促销店铺
    * @param sorting
    * @return
    */
    Result getById(Integer sorting);
}
