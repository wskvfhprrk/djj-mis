package com.guardlbt;

import com.guardlbt.autoCode.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/7/7 0007.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class StartFreemarker {

    @Autowired
    private CreateCodeService createCodeService;
    @Autowired
    private CreateEntity createEntity;

    @Test
    public void createCode() {
        List<Entity> entities=new ArrayList<>();
//        entities.add(new Entity("business_district", "商圈"));
//        entities.add(new Entity("shop", "商店"));
//        entities.add(new Entity("shop_user", "商店管理员"));
//        entities.add(new Entity("sys_dept", "商店部门管理"));
//        entities.add(new Entity("coupon","代金券"));
//        entities.add(new Entity("coupon_history","代金券历史"));
//        entities.add(new Entity("coupon_stock","代金券明细"));
//        entities.add(new Entity("goods","商品"));
//        entities.add(new Entity("index_coupon","首页促销代金券"));
//        entities.add(new Entity("index_images","轮播图"));
//        entities.add(new Entity("index_shop","首页促销店铺"));
//        entities.add(new Entity("member","会员"));
//        entities.add(new Entity("member_operation_history","会员操作记录历史"));
//        entities.add(new Entity("operation_type","操作类型"));
//        entities.add(new Entity("report_site","定位信息上报"));
//        entities.add(new Entity("schedule_job","定时任务"));
//        entities.add(new Entity("schedule_job_log","定时任务日志"));
        entities.add(new Entity("picture","图片管理"));
        //生成实体类
        //生成代码
        for (Entity entity : entities) {
            createEntity.createEntity(entity);
            createCodeService.creatCode(entity);
        }
        //生成菜单数据
        createSql(entities);
        //生成fullpath追加路径
        createFullpath(entities);

    }

    private void createFullpath(List<Entity> tableNames) {
        String path = AutoCodeConstant.fullpath;
        File file = new File(path);
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            StringBuffer sb=new StringBuffer();
            //1、添加模块值
            for (Entity tableName : tableNames) {
                sb.append(",{\n" +
                        "    path: '/"+tableName.getClassName()+"',\n" +
                        "    name: '"+tableName.getModuleName()+"',                     //"+tableName.getModuleName()+"\n" +
                        "    meta: {\n" +
                        "      name: '"+tableName.getModuleName()+"'\n" +
                        "    },\n" +
                        "    component: (resolve) => require(['@/views/"+tableName.getClassName()+"/index.vue'], resolve)}\n");
            }
            for (String s : sb.toString().split("\n")) {
                bw.write(s + "\n");
            }
            bw.newLine();
            bw.flush();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void createSql(List<Entity> tableNames) {
        String path = AutoCodeConstant.sqlPath;
        File file = new File(path);
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            //menu数据库自增最后值
            int num = 86;
            //初始化数据库
            StringBuffer sb = new StringBuffer(
                    "-- 初始化数据库\n" +
                            "-- 清除usre中除超级管理员外\n" +
                            "DELETE FROM t_user WHERE user_id!=1;\n" +
                            "-- 清除role中除超级管理员外\n" +
                            "DELETE FROM t_role WHERE role_id!=1;\n" +
                            "-- 清除中间表中menu_id大的值\n" +
                            "DELETE FROM m_role_menu WHERE menu_id>" + num + ";\n" +
                            "-- 清除菜单表中menu_id大的值\n" +
                            "DELETE FROM t_menu WHERE menu_id>" + num + ";\n" +
                            "-- 设置自增值\n" +
                            "alter table t_menu AUTO_INCREMENT=" + (num + 1) + ";\n" +
                            "alter table t_user AUTO_INCREMENT=2;\n" +
                            "alter table t_role AUTO_INCREMENT=2;\n");
            //自增menu_id用了一个了

            //1、添加模块值
            for (Entity tableName : tableNames) {
                num++;
                int id = num;
                sb.append("-- 添加菜单识别\n");
                sb.append("INSERT INTO `coupon`.`t_menu` (`menu_id`, `menu_name`, `url`, `m_pid`, `menu_code`, `permission_ui`, `permission`, `menu_describe`, `order_by`, `menu_type`) " +
                        "VALUES (" + id + ", '" + tableName.getModuleName() + "', '', 0, NULL, NULL, NULL, NULL, " + id + ", 0);\n");
                num++;
                int id2 = num;
                sb.append("-- 添加菜单带名称\n");
                sb.append("INSERT INTO `coupon`.`t_menu` (`menu_id`, `menu_name`, `url`, `m_pid`, `menu_code`, `permission_ui`, `permission`, `menu_describe`, `order_by`, `menu_type`) " +
                        "VALUES (" + id2 + ", '" +tableName.getModuleName()+"', '" + AutoCodeUtil.getBeanName(tableName.getTableName())  + "', " + id + ", NULL, NULL, NULL, NULL, " + id2 + ", 0);\n");
                num++;
                sb.append("-- 添加分页查询权限\n");
                sb.append("INSERT INTO `coupon`.`t_menu` (`menu_id`, `menu_name`, `url`, `m_pid`, `menu_code`, `permission_ui`, `permission`, `menu_describe`, `order_by`, `menu_type`) " +
                        "VALUES (" + num + ", '" + tableName.getModuleName()+"分页查询', NULL, " + id2 + ", NULL, '"+AutoCodeUtil.getBeanName(tableName.getTableName())+"_get', '/" +AutoCodeUtil.getBeanName(tableName.getTableName()) +"@get', NULL, " + 1 + ", 1);\n");
                num++;
                sb.append("-- 添加添加权限\n");
                sb.append("INSERT INTO `coupon`.`t_menu` (`menu_id`, `menu_name`, `url`, `m_pid`, `menu_code`, `permission_ui`, `permission`, `menu_describe`, `order_by`, `menu_type`) " +
                        "VALUES (" + num + ", '" +tableName.getModuleName()+"添加', NULL, " + id2 + ", NULL, '"+AutoCodeUtil.getBeanName(tableName.getTableName())+"_save', '/" +AutoCodeUtil.getBeanName(tableName.getTableName())  +"@post', NULL, " + 2 + ", 1);\n");
                num++;
                sb.append("-- 添加修改权限\n");
                sb.append("INSERT INTO `coupon`.`t_menu` (`menu_id`, `menu_name`, `url`, `m_pid`, `menu_code`, `permission_ui`, `permission`, `menu_describe`, `order_by`, `menu_type`) " +
                        "VALUES (" + num + ", '" +tableName.getModuleName()+"修改', NULL, " + id2 + ", NULL, '"+AutoCodeUtil.getBeanName(tableName.getTableName())+"_update', '/" +AutoCodeUtil.getBeanName(tableName.getTableName())  +"@put', NULL, " + 3 + ", 1);\n");
                num++;
                sb.append("-- 添加根据id查询权限\n");
                sb.append("INSERT INTO `coupon`.`t_menu` (`menu_id`, `menu_name`, `url`, `m_pid`, `menu_code`, `permission_ui`, `permission`, `menu_describe`, `order_by`, `menu_type`) " +
                        "VALUES (" + num + ", '" +tableName.getModuleName() +"根据id查询', NULL, " + id2 + ", NULL, '"+AutoCodeUtil.getBeanName(tableName.getTableName())+"_*_get', '/" +AutoCodeUtil.getBeanName(tableName.getTableName())  +"/*@get', NULL, " + 4 + ", 1);\n");
                num++;
                sb.append("-- 添加根据id删除权限\n");
                sb.append("INSERT INTO `coupon`.`t_menu` (`menu_id`, `menu_name`, `url`, `m_pid`, `menu_code`, `permission_ui`, `permission`, `menu_describe`, `order_by`, `menu_type`) " +
                        "VALUES (" + num + ", '" +tableName.getModuleName() +"根据id删除', NULL, " + id2 + ", NULL, '"+AutoCodeUtil.getBeanName(tableName.getTableName())+"_*_delete','/" +AutoCodeUtil.getBeanName(tableName.getTableName())  +"/*@delete', NULL, " + 5 + ", 1);\n"); num++;

                sb.append("-- 查询所有\n");
                sb.append("INSERT INTO `coupon`.`t_menu` (`menu_id`, `menu_name`, `url`, `m_pid`, `menu_code`, `permission_ui`, `permission`, `menu_describe`, `order_by`, `menu_type`) " +
                        "VALUES (" + num + ", '查询所有" +tableName.getModuleName() +"', NULL, " + id2 + ", NULL, '"+AutoCodeUtil.getBeanName(tableName.getTableName())+"_all_get','/" +AutoCodeUtil.getBeanName(tableName.getTableName())  +"/all@get', NULL, " + 6 + ", 1);\n");
            }
            for (String s : sb.toString().split("\n")) {
                bw.write(s + "\n");
            }
            bw.newLine();
            bw.flush();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
