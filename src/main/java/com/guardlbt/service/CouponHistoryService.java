package com.guardlbt.service;

import com.guardlbt.entity.CouponHistory;
import com.guardlbt.dto.*;
import com.guardlbt.common.util.*;

import java.util.*;

/**
* 代金券历史方法类接口
* Created by 代码自动生成.
* 时间:2021-08-28 11:42:14
*/
public interface CouponHistoryService {
    /**
    * 分页查询
    * @param dto 条件参数
    * @return easyui结果集
    */
    Result findPageCouponHistory( CouponHistoryPageDto dto);

    /**
    * 获取所有商圈
    * @return
    */
    Result getAll();

    /**
    * 条件查询全部数据
    * @param couponHistory 条件参数
    * @return 国全部数据
    */
    Result findAllByCouponHistory(CouponHistory couponHistory);

    /**
    * 根据条件,只查询唯一一个值,如果存在多个只返回第一个
    * @param couponHistory 条件参数
    * @return CouponHistory对象
    */
    CouponHistory findCouponHistory(CouponHistory couponHistory);

    /**
    * 添加代金券历史
    * @param dto 条件参数
    * @return 结果集
    */
    Result insert(CouponHistorySaveDto dto);
    /**
    * 修改代金券历史
    * @param dto 条件参数
    * @return 结果集
    */
    Result update(CouponHistoryUpdateDto dto);
    /**
    * 删除代金券历史
    * @param couponHistory 条件参数
    * @return 结果集
    */
    Result delete(CouponHistory couponHistory);
    /**
    * 批量删除代金券历史
    * @param ids 以逗号隔开的主键字符串,对于单个id也适用
    * @return 结果集
    */
    Result deleteAll(String ids);
    /**
    * 根据id查询代金券历史
    * @param id
    * @return
    */
    Result getById(Long id);
}
