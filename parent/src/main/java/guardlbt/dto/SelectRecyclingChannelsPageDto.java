package guardlbt.dto;

import javax.validation.constraints.*;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by 代码自动生成. 时间:2019-03-27 11:23:20
 */
@Data
public class SelectRecyclingChannelsPageDto {
	//@NotBlank(message = "recyclingChannelsName不能为空")
	@ApiModelProperty("回收渠道名称")
	private String recyclingChannelsName;
	//@NotNull(message = "recyclingChannelsStatus不能为空")
	@ApiModelProperty("回收渠道状态:0为正常1为锁定")
	private Integer recyclingChannelsStatus;
	@NotNull(message = "pageNumber不能为空")
	@ApiModelProperty("查询页码")
	private Integer pageNumber;
	@NotNull(message = "pageSize不能为空")
	@ApiModelProperty("每页多少条")
	private Integer pageSize;
}
