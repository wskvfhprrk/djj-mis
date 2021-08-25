package com.guardlbt.autoCode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class CreateEntity {
    @Autowired
    private AutoCodeMapper autoCodeMapper;

    @Value("${database-name}")
    private String databaseName;

    public Entity createEntity(Entity entity) {
        List<Map<String, Object>> columnNameList = autoCodeMapper.selectTable(
                databaseName, entity.getTableName());
        if (columnNameList.isEmpty()) {
            System.out.println("查询无此表，请检查表名是否正确");
            return null;
        }
        // 原来表名
        entity.setTableName(entity.getTableName());
        // 模块名称---解释使用
        entity.setModuleName(entity.getModuleName());
        // java类名称(首字母小写)
        entity.setClassName(AutoCodeUtil.getBeanName(entity.getTableName()));
        // 基础包
        entity.setBasePackage(AutoCodeConstant.basePackage);
        // 实体类包名
        entity.setEntityPackage(AutoCodeConstant.basePackage + "." + AutoCodeConstant.entity);
        entity.setDtoPackage(AutoCodeConstant.basePackage + "." + AutoCodeConstant.dto);
        entity.setVoPackage(AutoCodeConstant.basePackage + "." + AutoCodeConstant.vo);
        // dao类包名
        entity.setDaoPackage(AutoCodeConstant.basePackage + "." + AutoCodeConstant.dao);
        // service类包名
        entity.setServicePackage(AutoCodeConstant.basePackage + "." + AutoCodeConstant.service);
        // serviceImpl类包名
        entity.setServiceImplPackage(AutoCodeConstant.basePackage + "." + AutoCodeConstant.serviceImpl);
        // controller类包名
        entity.setControllerPackage(AutoCodeConstant.basePackage + "." + AutoCodeConstant.controller);
        List<Entity.data> data = searchEntity(columnNameList);
        entity.setData(data);
        //计算主键个数
        long count = data.stream().filter(Entity.data::getId).count();
        entity.setIdNumber((int) count);
        return entity;
    }

    private List<Entity.data> searchEntity(List<Map<String, Object>> list) {
        List<Entity.data> l = new ArrayList<>();
        for (Map<String, Object> aList : list) {
            Entity.data data = new Entity.data();
            // 原来数据库字段名
            data.setCommentName(aList.get("COLUMN_COMMENT").toString());
            //数据库字体
            data.setColumnName(aList.get("COLUMN_NAME").toString());
            // javaBean字段是否为空
            if (aList.get("IS_NULLABLE") != null
                    && aList.get("IS_NULLABLE").toString().equals("NO")) {
                data.setIsNull(false);
            } else {
                data.setIsNull(true);
            }
            //最多字符数_CHARACTER_MAXIMUM_LENGTH
            data.setMaximumLength(aList.get("CHARACTER_MAXIMUM_LENGTH") == null ? "0" :
                    aList.get("CHARACTER_MAXIMUM_LENGTH").toString());
            // javaBean字段名
            data.setBeanName(AutoCodeUtil.getBeanName(aList.get("COLUMN_NAME").toString()));
            // 是否为KEY
            data.setId(aList.get("COLUMN_KEY") != null
                    && aList.get("COLUMN_KEY").toString().equals("PRI") ? true : false);
            // 是否为自增
            data.setExtpa(aList.get("EXTRA") != null
                    && aList.get("EXTRA").toString().length() > 0 ? true : false);
            // 由数据库类型转JAVA类型
            String s = AutoCodeUtil.ColumnTypeEnum.getColumnTypeEnumByDBType(aList.get("DATA_TYPE").toString().toUpperCase());
            int i1 = s.lastIndexOf(".");
            data.setType(s.substring(i1 + 1));
            // 备注,仅用于实体类,是可无的对象
            data.setCommentName(aList.get("COLUMN_COMMENT") == null ? "" : aList.get("COLUMN_COMMENT")
                    .toString());
            l.add(data);
        }
        return l;
    }
}
