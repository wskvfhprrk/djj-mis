package com.guardlbt.service;

import com.guardlbt.entity.ReportSite;
import com.guardlbt.dto.*;
import com.guardlbt.common.util.*;

import java.util.*;

/**
* 定位信息上报方法类接口
* Created by 代码自动生成.
* 时间:2021-08-25 18:06:24
*/
public interface ReportSiteService {
    /**
    * 分页查询
    * @param dto 条件参数
    * @return easyui结果集
    */
    Result findPageReportSite( ReportSitePageDto dto);

    /**
    * 获取所有商圈
    * @return
    */
    Result getAll();


}
