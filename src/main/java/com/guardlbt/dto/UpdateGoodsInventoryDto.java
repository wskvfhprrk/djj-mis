package com.guardlbt.dto;

import lombok.Data;

import java.util.Date;

/**
 * @author hejz
 * @version 1.0
 * @date 2021/5/28 8:42
 */
@Data
public class UpdateGoodsInventoryDto {
    private Integer goodsId;
    private Integer quantity;
    private Integer frozenQuantity;
    private Date createTime;
    private Date updateTime;
}
