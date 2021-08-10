package guardlbt.vo;

import lombok.Data;

import java.util.Date;

/**
 * @author hejz
 * @version 1.0
 * @date 2021/5/28 8:48
 */
@Data
public class GoodsInventoryVo {
    private Integer goodsId;
    private String goodsName;
    private Integer quantity;

    private Integer frozenQuantity;

    private Date createTime;

    private Date updateTime;
}
