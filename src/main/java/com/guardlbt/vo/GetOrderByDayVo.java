package com.guardlbt.vo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author hejz
 * @version 1.0
 * @date 2021/6/1 17:55
 */
@Data
public class GetOrderByDayVo {
    private String createTime;
    private Integer quantity;
    private BigDecimal amount;
}
