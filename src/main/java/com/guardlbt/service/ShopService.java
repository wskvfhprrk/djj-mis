package com.guardlbt.service;

import com.guardlbt.entity.Shop;
import com.guardlbt.dto.*;
import com.guardlbt.common.util.*;

import java.util.*;

/**
* 商店方法类接口
* Created by 代码自动生成.
* 时间:2021-08-26 16:20:26
*/
public interface ShopService {
    /**
    * 分页查询
    * @param dto 条件参数
    * @return easyui结果集
    */
    Result findPageShop( ShopPageDto dto);

    /**
    * 获取所有商圈
    * @return
    */
    Result getAll();

    /**
    * 条件查询全部数据
    * @param shop 条件参数
    * @return 国全部数据
    */
    Result findAllByShop(Shop shop);

    /**
    * 根据条件,只查询唯一一个值,如果存在多个只返回第一个
    * @param shop 条件参数
    * @return Shop对象
    */
    Shop findShop(Shop shop);

    /**
    * 添加商店
    * @param dto 条件参数
    * @return 结果集
    */
    Result insert(ShopSaveDto dto);
    /**
    * 修改商店
    * @param dto 条件参数
    * @return 结果集
    */
    Result update(ShopUpdateDto dto);
    /**
    * 删除商店
    * @param shop 条件参数
    * @return 结果集
    */
    Result delete(Shop shop);
    /**
    * 批量删除商店
    * @param ids 以逗号隔开的主键字符串,对于单个id也适用
    * @return 结果集
    */
    Result deleteAll(String ids);
    /**
    * 根据id查询商店
    * @param shopId
    * @return
    */
    Result getById(String shopId);
}
