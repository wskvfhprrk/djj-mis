package com.guardlbt.service;

import com.guardlbt.entity.ShopUser;
import com.guardlbt.dto.*;
import com.guardlbt.common.util.*;

import java.util.*;

/**
* 商店管理员方法类接口
* Created by 代码自动生成.
* 时间:2021-08-27 14:44:53
*/
public interface ShopUserService {
    /**
    * 分页查询
    * @param dto 条件参数
    * @return easyui结果集
    */
    Result findPageShopUser( ShopUserPageDto dto);

    /**
    * 获取所有商圈
    * @return
    */
    Result getAll();

    /**
    * 条件查询全部数据
    * @param shopUser 条件参数
    * @return 国全部数据
    */
    Result findAllByShopUser(ShopUser shopUser);

    /**
    * 根据条件,只查询唯一一个值,如果存在多个只返回第一个
    * @param shopUser 条件参数
    * @return ShopUser对象
    */
    ShopUser findShopUser(ShopUser shopUser);

    /**
    * 添加商店管理员
    * @param dto 条件参数
    * @return 结果集
    */
    Result insert(ShopUserSaveDto dto);
    /**
    * 修改商店管理员
    * @param dto 条件参数
    * @return 结果集
    */
    Result update(ShopUserUpdateDto dto);
    /**
    * 删除商店管理员
    * @param shopUser 条件参数
    * @return 结果集
    */
    Result delete(ShopUser shopUser);
    /**
    * 批量删除商店管理员
    * @param ids 以逗号隔开的主键字符串,对于单个id也适用
    * @return 结果集
    */
    Result deleteAll(String ids);
    /**
    * 根据id查询商店管理员
    * @param userId
    * @return
    */
    Result getById(String userId);
}
