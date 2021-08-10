package com.guardlbt.dto;

import javax.validation.constraints.*;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by 代码自动生成. 时间:2019-03-25 16:48:40
 */
@Data
public class SelectCouponBatchPageDto {
	@NotNull(message = "pageNumber不能为空")
	@ApiModelProperty("查询页码")
	private Integer pageNumber;
	@NotNull(message = "pageSize不能为空")
	@ApiModelProperty("每页多少条")
	private Integer pageSize;
	//@NotNull(message = "merchantId不能为空")
	@ApiModelProperty("商家id")
	private Integer merchantId;
	//@NotBlank(message = "couponName不能为空")
	@ApiModelProperty("名称")
	private String couponName;
	//@NotNull(message = "isPastDue不能为空")
	@ApiModelProperty("是否过期（0过期，1不过期）")
	private Integer isPastDue;	
	//@NotNull(message = "couponbatchStatus不能为空")
	@ApiModelProperty("状态（1新建/2正在生产/3已生产）此是为1")
	private Integer couponbatchStatus;
}
