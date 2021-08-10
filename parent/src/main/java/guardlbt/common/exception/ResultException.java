package guardlbt.common.exception;

import guardlbt.common.util.ResultErrorCode;
import lombok.Data;

/**
 * @author 何建哲
 * @date 2019/3/2 9:01
 */
@Data
public class ResultException extends RuntimeException {

    private String msg;
    private int ret;

    public ResultException(ResultErrorCode resultErrorCode) {
        this.msg = resultErrorCode.getMsg();
        this.ret = resultErrorCode.getRet();
    }

    public ResultException(int ret, String msg) {
        this.msg = msg;
        this.ret = ret;
    }

    public ResultException(ResultErrorCode resultErrorCode, String str) {
        this.msg = String.format(resultErrorCode.getMsg(), str);
        this.ret = resultErrorCode.getRet();
    }

}
