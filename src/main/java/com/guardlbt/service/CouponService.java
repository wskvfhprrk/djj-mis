package com.guardlbt.service;

import com.guardlbt.entity.Coupon;
import com.guardlbt.dto.*;
import com.guardlbt.common.util.*;

import java.util.*;

/**
* 代金券方法类接口
* Created by 代码自动生成.
* 时间:2021-08-28 11:42:14
*/
public interface CouponService {
    /**
    * 分页查询
    * @param dto 条件参数
    * @return easyui结果集
    */
    Result findPageCoupon( CouponPageDto dto);

    /**
    * 获取所有商圈
    * @return
    */
    Result getAll();

    /**
    * 条件查询全部数据
    * @param coupon 条件参数
    * @return 国全部数据
    */
    Result findAllByCoupon(Coupon coupon);

    /**
    * 根据条件,只查询唯一一个值,如果存在多个只返回第一个
    * @param coupon 条件参数
    * @return Coupon对象
    */
    Coupon findCoupon(Coupon coupon);

    /**
    * 添加代金券
    * @param dto 条件参数
    * @return 结果集
    */
    Result insert(CouponSaveDto dto);
    /**
    * 修改代金券
    * @param dto 条件参数
    * @return 结果集
    */
    Result update(CouponUpdateDto dto);
    /**
    * 删除代金券
    * @param coupon 条件参数
    * @return 结果集
    */
    Result delete(Coupon coupon);
    /**
    * 批量删除代金券
    * @param ids 以逗号隔开的主键字符串,对于单个id也适用
    * @return 结果集
    */
    Result deleteAll(String ids);
    /**
    * 根据id查询代金券
    * @param couponId
    * @return
    */
    Result getById(String couponId);
}
