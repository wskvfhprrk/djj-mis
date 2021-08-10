package guardlbt.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author hejz
 * @version 1.0
 * @date 2021/5/27 16:18
 */
@Data
public class UpdateGoodsDto {
    private Integer id;

    private String name;

    private BigDecimal price;

    private BigDecimal discountPrice;

    private Date createTime;
}
