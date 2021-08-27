package com.guardlbt.service;

import com.guardlbt.entity.Goods;
import com.guardlbt.dto.*;
import com.guardlbt.common.util.*;

import java.util.*;

/**
* 商品方法类接口
* Created by 代码自动生成.
* 时间:2021-08-27 13:42:55
*/
public interface GoodsService {
    /**
    * 分页查询
    * @param dto 条件参数
    * @return easyui结果集
    */
    Result findPageGoods( GoodsPageDto dto);

    /**
    * 获取所有商圈
    * @return
    */
    Result getAll();

    /**
    * 条件查询全部数据
    * @param goods 条件参数
    * @return 国全部数据
    */
    Result findAllByGoods(Goods goods);

    /**
    * 根据条件,只查询唯一一个值,如果存在多个只返回第一个
    * @param goods 条件参数
    * @return Goods对象
    */
    Goods findGoods(Goods goods);

    /**
    * 添加商品
    * @param dto 条件参数
    * @return 结果集
    */
    Result insert(GoodsSaveDto dto);
    /**
    * 修改商品
    * @param dto 条件参数
    * @return 结果集
    */
    Result update(GoodsUpdateDto dto);
    /**
    * 删除商品
    * @param goods 条件参数
    * @return 结果集
    */
    Result delete(Goods goods);
    /**
    * 批量删除商品
    * @param ids 以逗号隔开的主键字符串,对于单个id也适用
    * @return 结果集
    */
    Result deleteAll(String ids);
    /**
    * 根据id查询商品
    * @param goodsId
    * @return
    */
    Result getById(String goodsId);
}
