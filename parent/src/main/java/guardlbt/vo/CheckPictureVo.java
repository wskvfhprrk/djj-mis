package guardlbt.vo;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;



/**
 * Created by 代码自动生成.
 * 时间:2019-03-25 16:49:43
 */
@Data
public class CheckPictureVo {
    
    @ApiModelProperty("验证码图案Base64位")
    private String picStr;
//    @ApiModelProperty("token")
//    private String token;
}
