package com.guardlbt.autoCode;

import lombok.Data;

import java.util.List;

/**
 * 有用的数据库字段名称
 */
@Data
public class Entity {

    private String tableName;
    private String moduleName;
    private String className;
    private String basePackage;
    private String entityPackage;
    private String dtoPackage;
    private String voPackage;
    private String daoPackage;
    private String servicePackage;
    private String serviceImplPackage;
    private String controllerPackage;
    private List<data> dataList;
    /**
     * 主键数量值
     */
    private Integer idNumber;


    @Data
    public static class data {
        /**
         * 行名称
         */
        private String data;
        /**
         * 数据库备注——中文
         */
        private String commentName;
        /**
         * javaBean字段名
         */
        private String beanName;
        /**
         * 类型
         */
        private String type;
        /**
         * 数据允许的最大值
         */
        private Integer maximumLength;

        /**
         * 是否充许为空值
         */
        private Boolean isNull;
        /**
         * 是否为主键
         */
        private Boolean id;
        /**
         * 是否有外链接——此字段没有太多用处
         */
        private Boolean mul;
        /**
         * 是否为主键数据自增
         */
        private Boolean extpa;

    }

}
