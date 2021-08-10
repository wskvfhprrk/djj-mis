package com.guardlbt.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author hejz
 * @version 1.0
 * @date 2021/6/2 6:05
 */
@Data
public class SelectOrdersPageVo {
    private String id;

    private String storeId;

    private String goodsName;

    private Integer goodsId;

    private Integer quantity;

    private BigDecimal amount;

    private BigDecimal price;

    private BigDecimal discountPrice;

    private Integer status;

    private String address;

    private String recipient;

    private String phone;

    private String deliveryId;

    private String remark;

    private Date createTime;

    private Date updateTime;
}
