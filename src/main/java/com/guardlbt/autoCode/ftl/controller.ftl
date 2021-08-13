package ${controllerPackage};

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import ${basePackage}.common.util.*;
import ${entityPackage}.${className?cap_first};
import ${servicePackage}.${className?cap_first}Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;
import javax.validation.constraints.*;
import com.guardlbt.dto.*;

import java.util.*;
import javax.validation.*;

/**
* Created by 代码自动生成.
* 时间:${.now?string("yyyy-MM-dd HH:mm:ss")}
*/
@Api("${moduleName}控制器")
@RestController
@RequestMapping("${className}")
public class ${className?cap_first}Controller {

    @Autowired
    public ${className?cap_first}Service service;

    @GetMapping
	@ApiOperation("分页条件查询${moduleName}")
    public Result getPage(@Validated ${className?cap_first}PageDto dto){
        return service.findPage${className?cap_first}(dto);
    }

    @PostMapping
	@ApiOperation("添加${moduleName}")
    public Result add(@Validated @RequestBody ${className?cap_first}SaveDto dto){
        return service.insert(dto);
    }

    @PutMapping
	@ApiOperation("修改${moduleName}")
    public Result update(@Validated @RequestBody ${className?cap_first}UpdateDto dto){
        return service.update(dto);
    }
    
    @DeleteMapping("/{id}")
	@ApiOperation("根据ID删除")
    public Result deleteAll(@PathVariable String id){
        return service.deleteAll(id);
    }

    @GetMapping("/{id}")
    @ApiOperation("根据ID查询")
    public Result getById(@PathVariable String id){
        return service.getById(id);
    }
}
