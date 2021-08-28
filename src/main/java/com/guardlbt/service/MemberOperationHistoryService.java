package com.guardlbt.service;

import com.guardlbt.entity.MemberOperationHistory;
import com.guardlbt.dto.*;
import com.guardlbt.common.util.*;

import java.util.*;

/**
* 会员操作记录历史方法类接口
* Created by 代码自动生成.
* 时间:2021-08-28 11:42:17
*/
public interface MemberOperationHistoryService {
    /**
    * 分页查询
    * @param dto 条件参数
    * @return easyui结果集
    */
    Result findPageMemberOperationHistory( MemberOperationHistoryPageDto dto);

    /**
    * 获取所有商圈
    * @return
    */
    Result getAll();

    /**
    * 条件查询全部数据
    * @param memberOperationHistory 条件参数
    * @return 国全部数据
    */
    Result findAllByMemberOperationHistory(MemberOperationHistory memberOperationHistory);

    /**
    * 根据条件,只查询唯一一个值,如果存在多个只返回第一个
    * @param memberOperationHistory 条件参数
    * @return MemberOperationHistory对象
    */
    MemberOperationHistory findMemberOperationHistory(MemberOperationHistory memberOperationHistory);

    /**
    * 添加会员操作记录历史
    * @param dto 条件参数
    * @return 结果集
    */
    Result insert(MemberOperationHistorySaveDto dto);
    /**
    * 修改会员操作记录历史
    * @param dto 条件参数
    * @return 结果集
    */
    Result update(MemberOperationHistoryUpdateDto dto);
    /**
    * 删除会员操作记录历史
    * @param memberOperationHistory 条件参数
    * @return 结果集
    */
    Result delete(MemberOperationHistory memberOperationHistory);
    /**
    * 批量删除会员操作记录历史
    * @param ids 以逗号隔开的主键字符串,对于单个id也适用
    * @return 结果集
    */
    Result deleteAll(String ids);
    /**
    * 根据id查询会员操作记录历史
    * @param id
    * @return
    */
    Result getById(Long id);
}
