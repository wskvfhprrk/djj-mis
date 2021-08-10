package guardlbt.dto;

import lombok.Data;

import java.util.Date;

/**
 * @author hejz
 * @version 1.0
 * @date 2021/5/31 13:52
 */
@Data
public class DownloadExcelDto {
    private Integer goodsId;
    private Integer status;
    private String date;
}
