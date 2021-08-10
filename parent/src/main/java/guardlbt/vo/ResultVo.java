package guardlbt.vo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class ResultVo {
    //是否中奖
    private Integer iswinning;
    //第一次查询时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date firstSearchTime;
    //共查询的次数
    private Integer searchNumber;
    //卡片编号
    private String code;
    //手工中奖号码
    private String winningCode;
}
