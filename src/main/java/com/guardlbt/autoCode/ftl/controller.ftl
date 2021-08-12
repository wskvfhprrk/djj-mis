package ${controllerPackage};

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import ${basePackage}.common.util.*;
import ${entityPackage}.${className?cap_first};
import ${servicePackage}.${className?cap_first}Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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

    @RequestMapping(value = "getPage", method = RequestMethod.GET)
	@ApiOperation("分页条件查询${moduleName}")
    public Result getPage(@Valid ${className?cap_first}PageDto dto){
        return service.findPage${className?cap_first}(dto);
    }

    @RequestMapping(method = RequestMethod.GET)
	@ApiOperation("根据实体类查询全部${moduleName}")
    public Result getAll(${className?cap_first} ${className}){
        return service.findAllBy${className?cap_first}(${className});
    }

    @RequestMapping(method = RequestMethod.POST)
	@ApiOperation("添加${moduleName}")
    public Result add(${className?cap_first} ${className}){
        return service.insert(${className});
    }

    @RequestMapping(method = RequestMethod.PUT)
	@ApiOperation("修改${moduleName}")
    public Result update(${className?cap_first} ${className}){
        return service.update(${className});
    }
    
    @RequestMapping(method = RequestMethod.DELETE)
	@ApiOperation("批量或单个删除${moduleName}")
    public Result deleteAll(String ids){
        return service.deleteAll(ids);
    }
}
