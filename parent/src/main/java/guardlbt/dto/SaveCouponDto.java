package guardlbt.dto;

import javax.validation.constraints.*;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


/**
 * Created by 代码自动生成.
 * 时间:2019-03-25 16:52:00
 */
@Data
public class SaveCouponDto {
@NotNull(message = "couponBatchId不能为空") @ApiModelProperty("电子券批次id:省码+3位序号（5位数字）")
    private Integer couponBatchId;
@NotBlank(message = "secretKey不能为空") @ApiModelProperty("生成压缩包的密码")
    private String secretKey;
    @NotNull(message = "encrypt不能为空") @ApiModelProperty("电子券是否加密1:加密，0:不加密")
    private Integer encrypt;
}
