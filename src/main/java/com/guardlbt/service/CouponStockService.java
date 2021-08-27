package com.guardlbt.service;

import com.guardlbt.entity.CouponStock;
import com.guardlbt.dto.*;
import com.guardlbt.common.util.*;

import java.util.*;

/**
* 代金券明细方法类接口
* Created by 代码自动生成.
* 时间:2021-08-27 13:42:55
*/
public interface CouponStockService {
    /**
    * 分页查询
    * @param dto 条件参数
    * @return easyui结果集
    */
    Result findPageCouponStock( CouponStockPageDto dto);

    /**
    * 获取所有商圈
    * @return
    */
    Result getAll();

    /**
    * 条件查询全部数据
    * @param couponStock 条件参数
    * @return 国全部数据
    */
    Result findAllByCouponStock(CouponStock couponStock);

    /**
    * 根据条件,只查询唯一一个值,如果存在多个只返回第一个
    * @param couponStock 条件参数
    * @return CouponStock对象
    */
    CouponStock findCouponStock(CouponStock couponStock);

    /**
    * 添加代金券明细
    * @param dto 条件参数
    * @return 结果集
    */
    Result insert(CouponStockSaveDto dto);
    /**
    * 修改代金券明细
    * @param dto 条件参数
    * @return 结果集
    */
    Result update(CouponStockUpdateDto dto);
    /**
    * 删除代金券明细
    * @param couponStock 条件参数
    * @return 结果集
    */
    Result delete(CouponStock couponStock);
    /**
    * 批量删除代金券明细
    * @param ids 以逗号隔开的主键字符串,对于单个id也适用
    * @return 结果集
    */
    Result deleteAll(String ids);
    /**
    * 根据id查询代金券明细
    * @param couponNo
    * @return
    */
    Result getById(String couponNo);
}
