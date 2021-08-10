package guardlbt.vo;

import lombok.Data;

import java.util.Date;

/**
 * @author: hejz
 * @Description:
 * @Date: 2020/1/7 12:54
 */
@Data
public class CouponCheckVo {
    private String checkDate;
    private Integer allCount;
    private Integer errorCount;
    private Integer okCount;
}
