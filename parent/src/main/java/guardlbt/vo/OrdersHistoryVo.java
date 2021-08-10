package guardlbt.vo;

import lombok.Data;

import java.util.Date;

/**
 * @author hejz
 * @version 1.0
 * @date 2021/6/2 9:58
 */
@Data
public class OrdersHistoryVo {
    private String id;

    private Long orderId;

    private String user;

    private String info;

    private Date createTime;
}
