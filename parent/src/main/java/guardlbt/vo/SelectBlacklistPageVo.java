package guardlbt.vo;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import com.fasterxml.jackson.annotation.*;
import java.util.Date;    


/**
 * Created by 代码自动生成.
 * 时间:2019-03-27 11:19:30
 */
@Data
public class SelectBlacklistPageVo {
    
    @ApiModelProperty("黑名单id")
    private Integer blacklistId;
    
    @ApiModelProperty("站点id")
    private String siteId;
    
    @ApiModelProperty("违规查询总次数")
    private Integer searchAllNumber;
    
    @ApiModelProperty("当天超过10次")
    private Integer dayNumber;
    
    @ApiModelProperty("锁定1，未锁定0")
    private Integer islock;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @ApiModelProperty("创建时间")
    private Date createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @ApiModelProperty("更新时间")
    private Date updateTime;
}
