package com.guardlbt.service;

import com.guardlbt.entity.OperationType;
import com.guardlbt.dto.*;
import com.guardlbt.common.util.*;

import java.util.*;

/**
* 操作类型方法类接口
* Created by 代码自动生成.
* 时间:2021-08-26 16:20:27
*/
public interface OperationTypeService {
    /**
    * 分页查询
    * @param dto 条件参数
    * @return easyui结果集
    */
    Result findPageOperationType( OperationTypePageDto dto);

    /**
    * 获取所有商圈
    * @return
    */
    Result getAll();

    /**
    * 条件查询全部数据
    * @param operationType 条件参数
    * @return 国全部数据
    */
    Result findAllByOperationType(OperationType operationType);

    /**
    * 根据条件,只查询唯一一个值,如果存在多个只返回第一个
    * @param operationType 条件参数
    * @return OperationType对象
    */
    OperationType findOperationType(OperationType operationType);

    /**
    * 添加操作类型
    * @param dto 条件参数
    * @return 结果集
    */
    Result insert(OperationTypeSaveDto dto);
    /**
    * 修改操作类型
    * @param dto 条件参数
    * @return 结果集
    */
    Result update(OperationTypeUpdateDto dto);
    /**
    * 删除操作类型
    * @param operationType 条件参数
    * @return 结果集
    */
    Result delete(OperationType operationType);
    /**
    * 批量删除操作类型
    * @param ids 以逗号隔开的主键字符串,对于单个id也适用
    * @return 结果集
    */
    Result deleteAll(String ids);
    /**
    * 根据id查询操作类型
    * @param operationId
    * @return
    */
    Result getById(String operationId);
}
