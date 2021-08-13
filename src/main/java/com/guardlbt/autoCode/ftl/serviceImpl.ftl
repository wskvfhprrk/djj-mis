package ${serviceImplPackage};

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import ${daoPackage}.${className?cap_first}Dao;
import ${entityPackage}.${className?cap_first};
import ${servicePackage}.${className?cap_first}Service;
import ${basePackage}.util.*;
import ${basePackage}.common.util.*;
import com.guardlbt.dto.*;
import com.guardlbt.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;


/**
* ${moduleName}方法实现类
* Created by 代码自动生成.
* 时间:${.now?string("yyyy-MM-dd HH:mm:ss")}
*/
@Service
@Transactional
public class ${className?cap_first}ServiceImpl implements ${className?cap_first}Service {

    @Autowired
    private ${className?cap_first}Dao dao;

    @Override
    public Result findPage${className?cap_first}(${className?cap_first}PageDto dto) {
        PageResult pageResult=new PageResult();
        PageHelper.startPage(dto.getPageNumber(),dto.getPageSize());
        ${className?cap_first} ${className}=new ${className?cap_first}();
        BeanUtils.copyProperties(dto,${className});
        List<${className?cap_first}> list = dao.select${className?cap_first}s(${className});
        PageInfo<${className?cap_first}> info=new PageInfo<>(list);
        pageResult.setTotle(info.getTotal());
        pageResult.setPageSize(dto.getPageSize());
        pageResult.setPageNumber(dto.getPageNumber());
        //转换vo出去
        List<${className?cap_first}PageVo> vos = info.getList().stream().map(l -> {
            ${className?cap_first}PageVo vo = new ${className?cap_first}PageVo();
            BeanUtils.copyProperties(l, vo);
            return vo;
        }).collect(Collectors.toList());
        pageResult.setPages(vos);
        return Result.ok(pageResult);
    }
    <#if idNumber!=0>
    @Override
    public Result findAllBy${className?cap_first}(${className?cap_first} ${className}) {
        List<${className?cap_first}> ${className}s = dao.select${className?cap_first}s(${className});
        //转换vo出去
        List<${className?cap_first}PageVo> vos = ${className}s.stream().map(l -> {
        ${className?cap_first}PageVo vo = new ${className?cap_first}PageVo();
        BeanUtils.copyProperties(l, vo);
        return vo;
        }).collect(Collectors.toList());
        return Result.ok(vos);
    }

    @Override
    public ${className?cap_first} find${className?cap_first}(${className?cap_first} ${className}) {
        List<${className?cap_first}> list = dao.select${className?cap_first}s(${className});
        if(!list.isEmpty()){
            return list.get(0);
        }
        return null;
    }

    @Override
    public Result insert(${className?cap_first}SaveDto dto) {
        ${className?cap_first} ${className}=new ${className?cap_first}();
        BeanUtils.copyProperties(dto,${className});<#list data as d><#if d.id==true && d.extpa==false && d.type=="Long">
        //todo 此处报错的原因是数据库设计不合理，主键是数据类型，但不是自增的，请修改数据结构为自增类型，如果确实需要数据不自增，请修错误代码！</#if><#if d.id==true && d.extpa==false && d.type=="Integer">
        //todo 此处报错的原因是数据库设计不合理，主键是数据类型，但不是自增的，请修改数据结构为自增类型，如果确实需要数据不自增，请修错误代码！</#if></#list>
        <#list data as d><#if d.id==true && d.extpa==false >${className}.set${d.columnName?cap_first}(UuidUtild.getUUID());</#if></#list>
        try{
            dao.insert(${className});
            return Result.ok();
        }catch (Exception e){
            e.printStackTrace();
            return Result.error(500,e.getCause().getMessage());
        }
    }

    @Override
    public Result update(${className?cap_first}UpdateDto dto) {
        ${className?cap_first} ${className}=new ${className?cap_first}();
        BeanUtils.copyProperties(dto,${className});
        try{
            dao.update(${className});
            return Result.ok();
        }catch (Exception e){
            e.printStackTrace();
            return Result.error(500,e.getCause().getMessage());
        }
    }

    @Override
    public Result delete(${className?cap_first} ${className}) {
        try{
            dao.delete(${className});
            return Result.ok();
        }catch (Exception e){
            e.printStackTrace();
            return Result.error(500,e.getCause().getMessage());
        }
    }

    @Override
    public Result deleteAll(String ids) {
        try{
            String[] strings = ids.split(",");
            List<String> list=new ArrayList<>();
            for (int i = 0; i <strings.length ; i++) {
                list.add(strings[i]);
            }
            dao.deleteAll(list);
            return Result.ok();
        }catch (Exception e){
            e.printStackTrace();
            return Result.error(500,e.getCause().getMessage());
        }
    }

    @Override
    public Result getById(<#list data as d><#if d.id==true>${d.type} ${d.columnName}</#if></#list>) {
        ${className?cap_first} ${className}=new ${className?cap_first}();
        ${className}.set<#list data as d><#if d.id==true>${d.columnName?cap_first}</#if></#list>(<#list data as d><#if d.id==true>${d.columnName}</#if></#list>);
        List<${className?cap_first}> ${className}s = dao.select${className?cap_first}s(${className});
        if(${className}s.isEmpty()){
            return Result.ok();
        }
        return Result.ok(${className}s.get(0));
    }</#if>
}
