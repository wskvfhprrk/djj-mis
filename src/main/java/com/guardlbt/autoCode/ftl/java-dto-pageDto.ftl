package ${dtoPackage};

import org.springframework.format.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import javax.validation.constraints.*;

<#list data as d> <#if d.type=='BigDecimal'>
import java.math.BigDecimal;<#break></#if></#list>
<#list data as d> <#if d.type=='Timestamp' ||d.type=='Date'>
import java.util.Date;<#break></#if></#list>

/**
* Created by 代码自动生成.
* 时间:${.now?string("yyyy-MM-dd HH:mm:ss")}
*/
@ApiModel("${moduleName}PageDto")
@Data
public class  ${className?cap_first}PageDto {

    @NotNull(message = "pageNumber不能为空")
    @ApiModelProperty(value = "查询页码（默认值为1）",example = "1")
    private Integer pageNumber;

    @NotNull(message = "pageSize不能为空")
    @ApiModelProperty(value = "每页多少条（默认值为30）",example = "1")
    private Integer pageSize;

<#list data as d><#if d.id==false><#if d.type=="Timestamp" || d.type=='Date'>
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")</#if>
    @ApiModelProperty(value ="${d.commentName}"<#if d.type=='Timestamp'>,example = "2000-12-12 10:10:10"</#if>)
    private <#if d.type=='Timestamp'>Date<#elseif d.type=='Time'>String<#else>${d.type}</#if> ${d.beanName};</#if>
</#list>
}
