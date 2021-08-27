package com.guardlbt.service;

import com.guardlbt.entity.IndexCoupon;
import com.guardlbt.dto.*;
import com.guardlbt.common.util.*;

import java.util.*;

/**
* 首页促销代金券方法类接口
* Created by 代码自动生成.
* 时间:2021-08-27 13:42:55
*/
public interface IndexCouponService {
    /**
    * 分页查询
    * @param dto 条件参数
    * @return easyui结果集
    */
    Result findPageIndexCoupon( IndexCouponPageDto dto);

    /**
    * 获取所有商圈
    * @return
    */
    Result getAll();

    /**
    * 条件查询全部数据
    * @param indexCoupon 条件参数
    * @return 国全部数据
    */
    Result findAllByIndexCoupon(IndexCoupon indexCoupon);

    /**
    * 根据条件,只查询唯一一个值,如果存在多个只返回第一个
    * @param indexCoupon 条件参数
    * @return IndexCoupon对象
    */
    IndexCoupon findIndexCoupon(IndexCoupon indexCoupon);

    /**
    * 添加首页促销代金券
    * @param dto 条件参数
    * @return 结果集
    */
    Result insert(IndexCouponSaveDto dto);
    /**
    * 修改首页促销代金券
    * @param dto 条件参数
    * @return 结果集
    */
    Result update(IndexCouponUpdateDto dto);
    /**
    * 删除首页促销代金券
    * @param indexCoupon 条件参数
    * @return 结果集
    */
    Result delete(IndexCoupon indexCoupon);
    /**
    * 批量删除首页促销代金券
    * @param ids 以逗号隔开的主键字符串,对于单个id也适用
    * @return 结果集
    */
    Result deleteAll(String ids);
    /**
    * 根据id查询首页促销代金券
    * @param sorting
    * @return
    */
    Result getById(Integer sorting);
}
