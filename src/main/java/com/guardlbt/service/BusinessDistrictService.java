package com.guardlbt.service;

import com.guardlbt.entity.BusinessDistrict;
import com.guardlbt.dto.*;
import com.guardlbt.common.util.*;
import com.guardlbt.entity.MemberOperationHistory;

/**
* 商圈方法类接口
* Created by 代码自动生成.
* 时间:2021-08-28 11:42:13
*/
public interface BusinessDistrictService {
    /**
    * 分页查询
    * @param dto 条件参数
    * @return easyui结果集
    */
    Result findPageBusinessDistrict( BusinessDistrictPageDto dto);

    /**
    * 获取所有商圈
    * @return
    */
    Result getAll();

    /**
    * 条件查询全部数据
    * @param businessDistrict 条件参数
    * @return 国全部数据
    */
    Result findAllByBusinessDistrict(BusinessDistrict businessDistrict);

    /**
    * 根据条件,只查询唯一一个值,如果存在多个只返回第一个
    * @param businessDistrict 条件参数
    * @return BusinessDistrict对象
    */
    BusinessDistrict findBusinessDistrict(BusinessDistrict businessDistrict);

    /**
    * 添加商圈
    * @param dto 条件参数
    * @return 结果集
    */
    Result insert(MemberOperationHistory dto);
    /**
    * 修改商圈
    * @param dto 条件参数
    * @return 结果集
    */
    Result update(BusinessDistrictUpdateDto dto);
    /**
    * 删除商圈
    * @param businessDistrict 条件参数
    * @return 结果集
    */
    Result delete(BusinessDistrict businessDistrict);
    /**
    * 批量删除商圈
    * @param ids 以逗号隔开的主键字符串,对于单个id也适用
    * @return 结果集
    */
    Result deleteAll(String ids);
    /**
    * 根据id查询商圈
    * @param businessDistrictId
    * @return
    */
    Result getById(String businessDistrictId);
}
