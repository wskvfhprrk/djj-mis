package guardlbt.dto;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author hejz
 * @version 1.0
 * @date 2021/5/27 16:14
 */
@Data
public class AddGoodsDto {

    private String name;

    private BigDecimal price;

    private BigDecimal discountPrice;

}
