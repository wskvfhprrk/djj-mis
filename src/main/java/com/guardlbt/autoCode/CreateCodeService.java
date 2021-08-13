package com.guardlbt.autoCode;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * 代码实现类
 *
 * @author 何建哲
 * @date 2018/6/20
 */
@Service
public class CreateCodeService {

    @Autowired
    private AutoCodeMapper autoCodeMapper;

    @Value("${database-name}")
    private String databaseName;

    public void start(Entity entity) {
        List<Map<String, Object>> columnNameList = autoCodeMapper.selectTable(
                databaseName, entity.getTableName());
        if (columnNameList.isEmpty()) {
            System.out.println("查询无此表，请检查表名是否正确");
            return;
        }
        // 原来表名
        entity.setTableName(entity.getTableName());
        // 模块名称---解释使用
        entity.setModuleName(entity.getModuleName());
        // java类名称(首字母小写)
        entity.setClassName(AutoCodeUtil.getBeanName(entity.getTableName()));
        // 基础包
        entity.setBasePackage(AutoCode.basePackage);
        // 实体类包名
        entity.setEntityPackage(AutoCode.basePackage + "." + AutoCode.entity);
        entity.setDtoPackage(AutoCode.basePackage + "." + AutoCode.dto);
        entity.setVoPackage(AutoCode.basePackage + "." + AutoCode.vo);
        // dao类包名
        entity.setDaoPackage(AutoCode.basePackage + "." + AutoCode.dao);
        // service类包名
        entity.setServicePackage(AutoCode.basePackage + "." + AutoCode.service);
        // serviceImpl类包名
        entity.setServiceImplPackage(AutoCode.basePackage + "." + AutoCode.serviceImpl);
        // controller类包名
        entity.setControllerPackage(AutoCode.basePackage + "." + AutoCode.controller);
        List<Entity.data> data = searchEntity(columnNameList);
        entity.setData(data);
        //计算主键个数
        long count = data.stream().filter(Entity.data::getId).count();
        entity.setIdNumber((int) count);
        creatFtl(entity);
    }

    private List<Entity.data> searchEntity(List<Map<String, Object>> list) {
        List<Entity.data> l = new ArrayList<>();
        for (Map<String, Object> aList : list) {
            Entity.data data = new Entity.data();
            // 原来数据库字段名
            data.setCommentName(aList.get("COLUMN_NAME").toString());
            // javaBean字段是否为空
            if (aList.get("IS_NULLABLE") != null
                    && aList.get("IS_NULLABLE").toString().equals("NO")) {
                data.setIsNull(false);
            } else {
                data.setIsNull(true);
            }
            //最多字符数_CHARACTER_MAXIMUM_LENGTH
            data.setMaximumLength(aList.get("CHARACTER_MAXIMUM_LENGTH") == null ? 0 :
                    Integer.valueOf(aList.get("CHARACTER_MAXIMUM_LENGTH").toString()));
            // javaBean字段名
            data.setColumnName(AutoCodeUtil.getBeanName(aList.get("COLUMN_NAME").toString()));
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

    public void creatFtl(Entity entity) {
        // 生成实体类
        creatEntity(entity);
        //生成分页查询dto
        creatPageDto(entity);
        //生成添加dto
        creatSaveDto(entity);
        //生成修改dto
        creatUpdateDto(entity);
        //生成分页查询Vo
        creatPageVo(entity);
        //生成单条查询Vo
        creatVo(entity);
        //生成修改在
        // 生成修改dto——没有主键
        createDao(entity);
        // 生成daoSQL类
        createDaoSQL(entity);
        // 生成service接口类
        createService(entity);
        // 生成serviceImpl实现类
        createServiceImpl(entity);
        // 生成controller实现类
        createController(entity);
        // 生成list页面
//        createListPage(entity);
        // 生成add页面
//        createAddPage(entity);
        //生成vue页面
        createVueAddPage(entity);
        //生成vue的index页面
        createVueIndexPage(entity);
        //生成vue js页面
        createVueJs(entity);

    }

    private void createVueJs(Entity entity) {
        StringBuffer addPathAndName = AutoCodeUtil.getPathByCom(AutoCode.basePackage);
        addPathAndName.append("autoCode/ftl/vue-js.ftl");
        // 输出路径+名称
        StringBuffer addOutFile = new StringBuffer(AutoCode.VuePagePath);
        // 先看是否存在路径没有先创建
        AutoCodeUtil.getPath(addOutFile.toString());
        addOutFile.append("api/");
        // 先看是否存在路径没有先创建
        AutoCodeUtil.getPath(addOutFile.toString());
        addOutFile.append(AutoCodeUtil.getBeanName(entity.getTableName() + ".js"));
        AutoCodeUtil.getNewFile(addPathAndName.toString(), entity, addOutFile.toString());
        System.out.println("-------------------------------------"
                + AutoCodeUtil.getBeanName(entity.getTableName())
                + "vue-js页面生成完毕------------------------------------");
    }

    private void createVueIndexPage(Entity entity) {
        StringBuffer addPathAndName = AutoCodeUtil.getPathByCom(AutoCode.basePackage);
        addPathAndName.append("autoCode/ftl/vue-index.ftl");
        // 输出路径+名称
        StringBuffer addOutFile = new StringBuffer(AutoCode.VuePagePath);
        // 先看是否存在路径没有先创建
        AutoCodeUtil.getPath(addOutFile.toString());
        addOutFile.append(AutoCodeUtil.getBeanName(entity.getTableName()));
        addOutFile.append("/");
        // 先看是否存在路径没有先创建
        AutoCodeUtil.getPath(addOutFile.toString());
        addOutFile.append(AutoCodeUtil.getBeanName("index.vue"));
        AutoCodeUtil.getNewFile(addPathAndName.toString(), entity, addOutFile.toString());
        System.out.println("-------------------------------------"
                + AutoCodeUtil.getBeanName(entity.getTableName())
                + "vue-index页面生成完毕------------------------------------");
    }

    private void createVueAddPage(Entity entity) {
        StringBuffer addPathAndName = AutoCodeUtil.getPathByCom(AutoCode.basePackage);
        addPathAndName.append("autoCode/ftl/vue-view.ftl");
        // 输出路径+名称
        StringBuffer addOutFile = new StringBuffer(AutoCode.pagePath);
        // 先看是否存在路径没有先创建
        AutoCodeUtil.getPath(addOutFile.toString());
        addOutFile.append(AutoCodeUtil.getBeanName(entity.getTableName()));
        addOutFile.append("/");
        // 先看是否存在路径没有先创建
        AutoCodeUtil.getPath(addOutFile.toString());
        addOutFile.append(AutoCodeUtil.getBeanName("view.vue"));
        AutoCodeUtil.getNewFile(addPathAndName.toString(), entity, addOutFile.toString());
        System.out.println("-------------------------------------"
                + AutoCodeUtil.getBeanName(entity.getTableName())
                + "vue-add页面生成完毕------------------------------------");
    }

    private void createAddPage(Entity entity) {
        StringBuffer addPathAndName = AutoCodeUtil.getPathByCom(AutoCode.basePackage);
        addPathAndName.append("autoCode/ftl/html-add.ftl");
        // 输出路径+名称
        StringBuffer addOutFile = new StringBuffer(AutoCode.pagePath);
        // 先看是否存在路径没有先创建
        AutoCodeUtil.getPath(addOutFile.toString());
        addOutFile.append(AutoCodeUtil.getBeanName(entity.getTableName())
                + "-add.html");
        AutoCodeUtil.getNewFile(addPathAndName.toString(), entity, addOutFile.toString());
        System.out.println("-------------------------------------"
                + AutoCodeUtil.getBeanName(entity.getTableName())
                + "-add页面生成完毕------------------------------------");
    }

    private void createListPage(Entity entity) {
        StringBuffer pagePathAndName = AutoCodeUtil.getPathByCom(AutoCode.basePackage);
        pagePathAndName.append("autoCode/ftl/html-list.ftl");
        // 输出路径+名称
        StringBuffer listOutFile = new StringBuffer(AutoCode.pagePath);
        // 先看是否存在路径没有先创建
        AutoCodeUtil.getPath(listOutFile.toString());
        listOutFile.append(AutoCodeUtil.getBeanName(entity.getTableName())
                + "-list.html");
        AutoCodeUtil.getNewFile(pagePathAndName.toString(), entity, listOutFile.toString());
        System.out.println("-------------------------------------"
                + AutoCodeUtil.getBeanName(entity.getTableName())
                + "-list页面生成完毕------------------------------------");
    }

    private void createController(Entity entity) {
        StringBuffer controllerPathAndName = AutoCodeUtil.getPathByCom(AutoCode.basePackage);
        controllerPathAndName.append("autoCode/ftl/controller.ftl");
        // 输出路径+名称
        StringBuffer controllerOutFile = AutoCodeUtil.getPathByCom(AutoCode.basePackage + "." + AutoCode.controller);
        // 先看是否存在路径没有先创建
        AutoCodeUtil.getPath(controllerOutFile.toString());
        controllerOutFile.append(AutoCodeUtil.captureName(entity.getClassName()) + "Controller.java");
        AutoCodeUtil.getNewFile(controllerPathAndName.toString(), entity, controllerOutFile.toString());
        System.out.println("-------------------------------------"
                + AutoCodeUtil.getBeanName(entity.getTableName())
                + "Controller实现类生成完毕----------------------------");
    }

    private void createServiceImpl(Entity entity) {
        StringBuffer serviceImplPathAndName = AutoCodeUtil.getPathByCom(AutoCode.basePackage);
        serviceImplPathAndName.append("autoCode/ftl/serviceImpl.ftl");
        // 输出路径+名称
        StringBuffer serviceImplOutFile = AutoCodeUtil.getPathByCom(AutoCode.basePackage + "." + AutoCode.serviceImpl);
        // 先看是否存在路径没有先创建
        AutoCodeUtil.getPath(serviceImplOutFile.toString());
        serviceImplOutFile.append(AutoCodeUtil.captureName(entity.getClassName()) + "ServiceImpl.java");
        AutoCodeUtil.getNewFile(serviceImplPathAndName.toString(), entity, serviceImplOutFile.toString());
        System.out.println("-------------------------------------"
                + AutoCodeUtil.getBeanName(entity.getTableName())
                + "ServiceImpl实现类生成完毕--------------------------");
    }

    private void createService(Entity entity) {
        StringBuffer servicePathAndName = AutoCodeUtil.getPathByCom(AutoCode.basePackage);
        servicePathAndName.append("autoCode/ftl/service.ftl");
        // 输出路径+名称
        StringBuffer serviceOutFile = AutoCodeUtil.getPathByCom(AutoCode.basePackage + "." + AutoCode.service);
        // 先看是否存在路径没有先创建
        AutoCodeUtil.getPath(serviceOutFile.toString());
        serviceOutFile.append(AutoCodeUtil.captureName(entity.getClassName()) + "Service.java");
        AutoCodeUtil.getNewFile(servicePathAndName.toString(), entity, serviceOutFile.toString());
        System.out.println("-------------------------------------"
                + AutoCodeUtil.getBeanName(entity.getTableName())
                + "Service接口类生成完毕-----------------------------");
    }

    private void createDaoSQL(Entity entity) {
        StringBuffer daoSQLPathAndName = AutoCodeUtil.getPathByCom(AutoCode.basePackage);
        daoSQLPathAndName.append("autoCode/ftl/daoSQL.ftl");
        // 输出路径+名称
        StringBuffer daoSQLOutFile = AutoCodeUtil.getPathByCom(AutoCode.basePackage + "." + AutoCode.dao);
        // 先看是否存在路径没有先创建
        AutoCodeUtil.getPath(daoSQLOutFile.toString());
        daoSQLOutFile.append(AutoCodeUtil.captureName(entity.getClassName()) + "DaoSQL.java");
        AutoCodeUtil.getNewFile(daoSQLPathAndName.toString(), entity, daoSQLOutFile.toString());
        System.out.println("-------------------------------------"
                + AutoCodeUtil.getBeanName(entity.getTableName())
                + "DaoSQL类生成完毕---------------------------------");
    }

    private void createDao(Entity entity) {
        StringBuffer daoPathAndName = AutoCodeUtil.getPathByCom(AutoCode.basePackage);
        daoPathAndName.append("autoCode/ftl/dao.ftl");
        // 输出路径+名称
        StringBuffer daoOutFile = AutoCodeUtil.getPathByCom(AutoCode.basePackage
                + "." + AutoCode.dao);
        // 先看是否存在路径没有先创建
        AutoCodeUtil.getPath(daoOutFile.toString());
        daoOutFile.append(AutoCodeUtil.captureName(entity.getClassName()) + "Dao.java");
        AutoCodeUtil.getNewFile(daoPathAndName.toString(), entity, daoOutFile.toString());
        System.out.println("-------------------------------------"
                + AutoCodeUtil.getBeanName(entity.getTableName())
                + "Dao类生成完毕------------------------------------");
    }

    private void creatPageDto(Entity entity) {
        StringBuffer entityPathAndName = AutoCodeUtil.getPathByCom(AutoCode.basePackage);
        entityPathAndName.append("autoCode/ftl/entityPageDto.ftl");
        // 输出路径+名称
        StringBuffer dtoOutFile = AutoCodeUtil.getPathByCom(AutoCode.basePackage + "." + AutoCode.dto);
        // 先看是否存在路径没有先创建
        AutoCodeUtil.getPath(dtoOutFile.toString());
        dtoOutFile.append(AutoCodeUtil.captureName(entity.getClassName()) + "PageDto.java");
        AutoCodeUtil.getNewFile(entityPathAndName.toString(), entity, dtoOutFile.toString());
        System.out.println("-------------------------------------"
                + AutoCodeUtil.getBeanName(entity.getTableName())
                + "PageDto生成完毕------------------------------------");
    }

    private void creatSaveDto(Entity entity) {
        StringBuffer entityPathAndName = AutoCodeUtil.getPathByCom(AutoCode.basePackage);
        entityPathAndName.append("autoCode/ftl/entitySaveDto.ftl");
        // 输出路径+名称
        StringBuffer entityOutFile = AutoCodeUtil.getPathByCom(AutoCode.basePackage + "." + AutoCode.dto);
        // 先看是否存在路径没有先创建
        AutoCodeUtil.getPath(entityOutFile.toString());
        entityOutFile.append(AutoCodeUtil.captureName(entity.getClassName()) + "SaveDto.java");
        AutoCodeUtil.getNewFile(entityPathAndName.toString(), entity, entityOutFile.toString());
        System.out.println("-------------------------------------"
                + AutoCodeUtil.getBeanName(entity.getTableName())
                + "SaveDto生成完毕------------------------------------");
    }

    private void creatUpdateDto(Entity entity) {
        StringBuffer entityPathAndName = AutoCodeUtil.getPathByCom(AutoCode.basePackage);
        entityPathAndName.append("autoCode/ftl/entityUpdateDto.ftl");
        // 输出路径+名称
        StringBuffer entityOutFile = AutoCodeUtil.getPathByCom(AutoCode.basePackage + "." + AutoCode.dto);
        // 先看是否存在路径没有先创建
        AutoCodeUtil.getPath(entityOutFile.toString());
        entityOutFile.append(AutoCodeUtil.captureName(entity.getClassName())  + "UpdateDto.java");
        AutoCodeUtil.getNewFile(entityPathAndName.toString(), entity, entityOutFile.toString());
        System.out.println("-------------------------------------"
                + AutoCodeUtil.getBeanName(entity.getTableName())
                + "UpdateDto生成完毕------------------------------------");
    }

    private void creatEntity(Entity entity) {
        StringBuffer entityPathAndName = AutoCodeUtil.getPathByCom(AutoCode.basePackage);
        entityPathAndName.append("autoCode/ftl/entity.ftl");
        // 输出路径+名称
        StringBuffer entityOutFile = AutoCodeUtil.getPathByCom(AutoCode.basePackage + "." + AutoCode.entity);
        // 先看是否存在路径没有先创建
        AutoCodeUtil.getPath(entityOutFile.toString());
        entityOutFile.append(AutoCodeUtil.captureName(entity.getClassName())  + ".java");
        AutoCodeUtil.getNewFile(entityPathAndName.toString(), entity, entityOutFile.toString());
        System.out.println("-------------------------------------"
                + AutoCodeUtil.getBeanName(entity.getTableName())
                + "实体类生成完毕------------------------------------");
    }

    private void creatPageVo(Entity entity) {
        StringBuffer entityPathAndName = AutoCodeUtil.getPathByCom(AutoCode.basePackage);
        entityPathAndName.append("autoCode/ftl/entityPageVo.ftl");
        // 输出路径+名称
        StringBuffer entityOutFile = AutoCodeUtil.getPathByCom(AutoCode.basePackage + "." + AutoCode.vo);
        // 先看是否存在路径没有先创建
        AutoCodeUtil.getPath(entityOutFile.toString());
        entityOutFile.append(AutoCodeUtil.captureName(entity.getClassName()) + "PageVo.java");
        AutoCodeUtil.getNewFile(entityPathAndName.toString(), entity, entityOutFile.toString());
        System.out.println("-------------------------------------"
                + AutoCodeUtil.getBeanName(entity.getTableName())
                + "PageVo生成完毕------------------------------------");
    }

    private void creatVo(Entity entity) {
        StringBuffer entityPathAndName = AutoCodeUtil.getPathByCom(AutoCode.basePackage);
        entityPathAndName.append("autoCode/ftl/entityVo.ftl");
        // 输出路径+名称
        StringBuffer entityOutFile = AutoCodeUtil.getPathByCom(AutoCode.basePackage + "." + AutoCode.vo);
        // 先看是否存在路径没有先创建
        AutoCodeUtil.getPath(entityOutFile.toString());
        entityOutFile.append(AutoCodeUtil.captureName(entity.getClassName())  + "Vo.java");
        AutoCodeUtil.getNewFile(entityPathAndName.toString(), entity, entityOutFile.toString());
        System.out.println("-------------------------------------"
                + AutoCodeUtil.getBeanName(entity.getTableName())
                + "vo生成完毕------------------------------------");
    }



}
