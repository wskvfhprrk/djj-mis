package ${servicePackage};

import ${entityPackage}.${className?cap_first};
import com.guardlbt.dto.*;
import ${basePackage}.common.util.*;

import java.util.*;

/**
* ${moduleName}方法类接口
* Created by 代码自动生成.
* 时间:${.now?string("yyyy-MM-dd HH:mm:ss")}
*/
public interface ${className?cap_first}Service {
    /**
    * 分页查询
    * @param dto 条件参数
    * @return easyui结果集
    */
    Result findPage${className?cap_first}( ${className?cap_first}PageDto dto);

    /**
    * 获取所有商圈
    * @return
    */
    Result getAll();

<#if idNumber!=0>
    /**
    * 条件查询全部数据
    * @param ${className} 条件参数
    * @return 国全部数据
    */
    Result findAllBy${className?cap_first}(${className?cap_first} ${className});

    /**
    * 根据条件,只查询唯一一个值,如果存在多个只返回第一个
    * @param ${className} 条件参数
    * @return ${className?cap_first}对象
    */
    ${className?cap_first} find${className?cap_first}(${className?cap_first} ${className});

    /**
    * 添加${moduleName}
    * @param dto 条件参数
    * @return 结果集
    */
    Result insert(${className?cap_first}SaveDto dto);
    /**
    * 修改${moduleName}
    * @param dto 条件参数
    * @return 结果集
    */
    Result update(${className?cap_first}UpdateDto dto);
    /**
    * 删除${moduleName}
    * @param ${className} 条件参数
    * @return 结果集
    */
    Result delete(${className?cap_first} ${className});
    /**
    * 批量删除${moduleName}
    * @param ids 以逗号隔开的主键字符串,对于单个id也适用
    * @return 结果集
    */
    Result deleteAll(String ids);
    /**
    * 根据id查询${moduleName}
    * @param <#list data as d><#if d.id==true>${d.beanName}</#if></#list>
    * @return
    */
    Result getById(<#list data as d><#if d.id==true>${d.type} ${d.beanName}</#if></#list>);</#if>
}
