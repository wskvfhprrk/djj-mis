package guardlbt.dto;

import lombok.Data;

import java.util.Date;

/**
 * @author hejz
 * @version 1.0
 * @date 2021/5/28 10:33
 */
@Data
public class AddStroeDto {
    private String id;
    private String clerkId;
    private String pwd;
    private String name;
    private String address;
}
