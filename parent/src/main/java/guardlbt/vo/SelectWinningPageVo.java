package guardlbt.vo;

import lombok.Data;

import java.util.Date;

@Data
public class SelectWinningPageVo {
    private String id;

    private String codeId;

    private String winningCode;

    private Integer isWinning;

    private Date fistTime;

    private Integer searchNumber;

    private Date updateTime;
}
