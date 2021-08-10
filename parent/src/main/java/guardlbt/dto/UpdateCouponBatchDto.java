package guardlbt.dto;

import javax.validation.constraints.*;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.*;

import java.util.Date;

/**
 * Created by 代码自动生成.
 * 时间:2019-03-25 16:48:40
 */
@Data
public class UpdateCouponBatchDto {
    @NotNull(message = "couponBatchId不能为空")
    @ApiModelProperty("电子券批次id:省码+3位序号（5位数字）")
    private Integer couponBatchId;
    @NotNull(message = "merchantId不能为空")
    @ApiModelProperty("商家id")
    private Integer merchantId;
    @NotBlank(message = "couponName不能为空")
    @ApiModelProperty("名称")
    private String couponName;
    @NotNull(message = "beginTime不能为空")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty("开始时间(长时间字符串：yyyy-MM-dd HH:mm:ss)")
    private Date beginTime;
    @NotNull(message = "endTime不能为空")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty("截止时间(长时间字符串：yyyy-MM-dd HH:mm:ss)")
    private Date endTime;
    @ApiModelProperty("内容描述")
    private String description;
    @NotNull(message = "money不能为空")
    @ApiModelProperty("总金额（=面值*数量）")
    private Integer money;
    @NotNull(message = "price不能为空")
    @ApiModelProperty("电子券面值")
    private Integer price;
    @NotNull(message = "number不能为空")
    @ApiModelProperty("电子券数量")
    private Integer number;
    @NotNull(message = "isQr不能为空")
    @ApiModelProperty("是否生成二维码")
    private Integer isQr;
}
