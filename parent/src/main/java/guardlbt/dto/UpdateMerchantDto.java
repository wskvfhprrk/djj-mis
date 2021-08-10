
package guardlbt.dto;

import javax.validation.constraints.*;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by 代码自动生成. 时间:2019-03-25 17:24:50
 */
@Data
public class UpdateMerchantDto {
	@NotBlank(message = "merchantId不能为空")
	@ApiModelProperty("商家id")
	private String merchantId;
	@NotBlank(message = "merchantName不能为空")
	@ApiModelProperty("商户名")
	private String merchantName;
//	@NotNull(message = "status不能为空")
	@ApiModelProperty("账户状态")
	private Integer status;
	@NotNull(message = "sendStatus不能为空")
	@ApiModelProperty("是否推送回收情况:1推送0不推送")
	private Integer sendStatus;
	@ApiModelProperty("推送地址：如果sendStatus==1时不能为空值")
	private String sendUrl;
}

