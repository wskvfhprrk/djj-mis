package guardlbt.service;

import guardlbt.common.util.Result;
import guardlbt.dto.LoginDto;
import guardlbt.dto.SaveResetPasswordDto;
import guardlbt.dto.SaveSetPasswordDto;
import guardlbt.vo.CheckPictureVo;
import guardlbt.vo.LoginVo;
import guardlbt.vo.SaveLoginVo;

import javax.servlet.http.HttpServletResponse;

/**
 * 基础管理方法类接口
 * <p>
 * Created by 代码自动生成.
 * 时间:2019-03-25 16:49:43
 */
public interface BaseService {

    /**
     * 登陆——登陆页需要验证码图片：base64字符串（记录到redis中5分钟失效）
     */
    Result<CheckPictureVo> checkPicture(String token);

    /**
     * 登陆——登陆：成功后返回前端token值和对应权限菜单，另外还需要缓存token对应的菜单权限、用户基本信息
     */
    Result<LoginVo> login(LoginDto loginDto, HttpServletResponse response);

    /**
     * 登陆——登出直接删除token和用户信息和菜单信息
     */
    Result logout(String token);

    /**
     * 修改密码——修改密码后让其重新登陆
     */
    Result saveSetPassword(String token, SaveSetPasswordDto saveSetPasswordDto);

    /**
     * 重置密码——管理员有权重置密码(在用户查询页面上),页面提示密码是：888888
     */
    Result saveResetPassword(String token, SaveResetPasswordDto saveResetPasswordDto);

    Result<SaveLoginVo> menus(String token);

}
