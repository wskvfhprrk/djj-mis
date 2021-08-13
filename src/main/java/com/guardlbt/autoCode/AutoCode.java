package com.guardlbt.autoCode;

import lombok.Data;

/**
 * Created by Administrator on 2017/7/6.
 */
@Data
public class  AutoCode {
    /**
     * 基础类包
     */
    public static String basePackage = "com.guardlbt";
    /**
     * 表名
     */
    public static String tableName = "tableName";
    /**
     * 模块名称
     */
    public static String moduleName = "moduleName";
    /**
     * 实体类包名
     */
    public static String entity = "entity";
    /**
     * dto包名
     */
    public static String dto = "dto";
    /**
     * vo包名
     */
    public static String vo = "vo";
    /**
     * dao包名
     */
    public static String dao = "dao";
    /**
     * service包名
     */
    public static String service = "service";
    /**
     * serviceImpl包名
     */
    public static String serviceImpl = "service.Impl";
    /**
     * controller包名
     */
    public static String controller = "controller";

    /**
     * html网页路径
     */
    public static String pagePath = "src/main/resources/templates/";
    /**
     * vue
     */
    public static String VuePagePath = "src/main/resources/vue/";

    /**
     * sql路径
     */
    public static String sqlPath="src/main/resources/sql/addMenu.sql";
}
