
package guardlbt.dto;

import javax.validation.constraints.*;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


/**
 * Created by 代码自动生成.
 * 时间:2019-03-25 17:24:50
 */
@Data
public class SaveMerchantDto {

    @NotBlank(message = "merchantName不能为空")
    @ApiModelProperty("商家名称")
    private String merchantName;
    @NotBlank(message = "userId不能为空")
    @ApiModelProperty("用户id(下拉框获取)")
    private String userId;
    @NotNull(message = "sendStatus不能为空")
    @ApiModelProperty("是否推送回收情况:1推送0不推送")
    private Integer sendStatus;
    @ApiModelProperty("推送地址：如果sendStatus==1时不能为空值")
    private String sendUrl;

}


