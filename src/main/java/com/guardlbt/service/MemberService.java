package com.guardlbt.service;

import com.guardlbt.entity.Member;
import com.guardlbt.dto.*;
import com.guardlbt.common.util.*;

import java.util.*;

/**
* 会员方法类接口
* Created by 代码自动生成.
* 时间:2021-08-28 11:42:17
*/
public interface MemberService {
    /**
    * 分页查询
    * @param dto 条件参数
    * @return easyui结果集
    */
    Result findPageMember( MemberPageDto dto);

    /**
    * 获取所有商圈
    * @return
    */
    Result getAll();

    /**
    * 条件查询全部数据
    * @param member 条件参数
    * @return 国全部数据
    */
    Result findAllByMember(Member member);

    /**
    * 根据条件,只查询唯一一个值,如果存在多个只返回第一个
    * @param member 条件参数
    * @return Member对象
    */
    Member findMember(Member member);

    /**
    * 添加会员
    * @param dto 条件参数
    * @return 结果集
    */
    Result insert(MemberSaveDto dto);
    /**
    * 修改会员
    * @param dto 条件参数
    * @return 结果集
    */
    Result update(MemberUpdateDto dto);
    /**
    * 删除会员
    * @param member 条件参数
    * @return 结果集
    */
    Result delete(Member member);
    /**
    * 批量删除会员
    * @param ids 以逗号隔开的主键字符串,对于单个id也适用
    * @return 结果集
    */
    Result deleteAll(String ids);
    /**
    * 根据id查询会员
    * @param memberId
    * @return
    */
    Result getById(String memberId);
}
