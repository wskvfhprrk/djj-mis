package com.guardlbt.service;

import com.guardlbt.entity.SysDept;
import com.guardlbt.dto.*;
import com.guardlbt.common.util.*;

import java.util.*;

/**
* 商店部门管理方法类接口
* Created by 代码自动生成.
* 时间:2021-08-25 18:06:23
*/
public interface SysDeptService {
    /**
    * 分页查询
    * @param dto 条件参数
    * @return easyui结果集
    */
    Result findPageSysDept( SysDeptPageDto dto);

    /**
    * 获取所有商圈
    * @return
    */
    Result getAll();

    /**
    * 条件查询全部数据
    * @param sysDept 条件参数
    * @return 国全部数据
    */
    Result findAllBySysDept(SysDept sysDept);

    /**
    * 根据条件,只查询唯一一个值,如果存在多个只返回第一个
    * @param sysDept 条件参数
    * @return SysDept对象
    */
    SysDept findSysDept(SysDept sysDept);

    /**
    * 添加商店部门管理
    * @param dto 条件参数
    * @return 结果集
    */
    Result insert(SysDeptSaveDto dto);
    /**
    * 修改商店部门管理
    * @param dto 条件参数
    * @return 结果集
    */
    Result update(SysDeptUpdateDto dto);
    /**
    * 删除商店部门管理
    * @param sysDept 条件参数
    * @return 结果集
    */
    Result delete(SysDept sysDept);
    /**
    * 批量删除商店部门管理
    * @param ids 以逗号隔开的主键字符串,对于单个id也适用
    * @return 结果集
    */
    Result deleteAll(String ids);
    /**
    * 根据id查询商店部门管理
    * @param deptId
    * @return
    */
    Result getById(Integer deptId);
}
