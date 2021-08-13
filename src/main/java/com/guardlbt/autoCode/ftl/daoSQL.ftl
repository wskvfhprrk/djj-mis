package ${daoPackage};

import ${entityPackage}.${className?cap_first};
import org.apache.ibatis.jdbc.SQL;
import org.apache.commons.lang3.StringUtils;

/**
* ${moduleName}SQL语句
* Created by 代码自动生成.
* 时间:${.now?string("yyyy-MM-dd HH:mm:ss")}
*/
public class ${className?cap_first}DaoSQL {

    public static String select${className?cap_first}s(final ${className?cap_first} ${className}){
        return new SQL(){{
            SELECT("<#list data as d><#if d_index==0>a.${d.columnName}<#else> ,a.${d.columnName}</#if></#list>");
            FROM("${tableName} a");
            <#list data as d><#if d.type=='String'>
            if(StringUtils.isNotBlank(${className}.get${d.columnName?cap_first}())){
                WHERE("a.${d.columnName?cap_first} = ${r"#{"}${d.columnName}}");
            }</#if><#if d.type!='String'>
            if(${className}.get${d.columnName?cap_first}()!=null && ${className}.get${d.columnName?cap_first}().toString().length()>0){
                WHERE("a.${d.columnName?cap_first} = ${r"#{"}${d.columnName}}");
            }</#if></#list>
        }}.toString();
    }

    public static String insert(final ${className?cap_first} ${className}){
        return new SQL(){{
            INSERT_INTO("${tableName}");
            <#list data as d>

            if(${className}.get${d.columnName?cap_first}()!=null && ${className}.get${d.columnName?cap_first}().toString().length()>0){
                <#assign str = "#\{"/>
                VALUES("${d.columnName}", "${str}${d.columnName}}");
            }
            </#list>
    }}.toString();
    }

    public static String update(final ${className?cap_first} ${className}){
        return new SQL(){{
            UPDATE("${tableName}");
            <#list data as d>
            if(${className}.get${d.columnName?cap_first}()!=null && ${className}.get${d.columnName?cap_first}().toString().length()>0){
                <#assign str = "#\{"/>
                SET("${d.columnName} = ${str}${d.columnName}}");
            }
            </#list>
            <#list data as d><#if d.id=true>
            if(${className}.get${d.columnName?cap_first}()!=null && ${className}.get${d.columnName?cap_first}().toString().length()>0){
                <#assign str = "#\{"/>
                WHERE("${d.columnName} = ${str}${d.columnName}}");
            }
            </#if></#list>
        }}.toString();
    }

    public static String delete(final ${className?cap_first} ${className}){
        return new SQL(){{
            DELETE_FROM("${tableName}");
            <#list data as d>
            if(${className}.get${d.columnName?cap_first}()!=null && ${className}.get${d.columnName?cap_first}().toString().length()>0){
                <#assign str = "#\{"/>
                WHERE("${d.columnName} = ${str}${d.columnName}}");
            }
            </#list>
        }}.toString();
    }
   <#-- public static String deleteAll(String[] ids){
        return new SQL(){{
            DELETE_FROM("${tableName}");
            <#list data as d><#if d.id=true><#assign str = "#\{ids}"/>
            WHERE("${d.columnName} = ${str}");
            </#if></#list>
        }}.toString();
    }-->
}
