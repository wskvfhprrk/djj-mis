package com.guardlbt.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class OrdersElcelVo {
    private String id;

    private String storeId;

    private String goodsId;

    private Integer quantity;

    private BigDecimal amount;

    private BigDecimal price;

    private BigDecimal discountPrice;

    private String status;

    private String address;

    private String recipient;

    private String phone;

    private String deliveryId;

    private String remark;

    private Date createTime;

    private Date updateTime;

}