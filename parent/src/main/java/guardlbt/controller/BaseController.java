package guardlbt.controller;

import guardlbt.common.util.Result;
import guardlbt.common.util.TokenUtil;
import guardlbt.dto.LoginDto;
import guardlbt.dto.SaveResetPasswordDto;
import guardlbt.dto.SaveSetPasswordDto;
import guardlbt.service.BaseService;
import guardlbt.vo.CheckPictureVo;
import guardlbt.vo.LoginVo;
import guardlbt.vo.SaveLoginVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by 代码自动生成.
 * 时间:2019-03-25 16:49:43
 */
@Api("基础管理控制器")
@RestController
@Slf4j
public class BaseController {

    @Autowired
    private BaseService service;

    @GetMapping("checkPicture")
    @ApiOperation("登陆——登陆页需要验证码图片：base64字符串（记录到redis中5分钟失效）")
    public Result<CheckPictureVo> checkPicture(HttpServletRequest request) {
        log.info("登陆：checkPicture");
        return service.checkPicture(TokenUtil.getToken(request));
    }

    @PostMapping("login")
    @ApiOperation("登陆——登陆：成功后返回前端用户基本信息和token")
    public Result<LoginVo> login(@Validated @RequestBody LoginDto loginDto, HttpServletResponse response) {
        log.info("登陆：login: {})", loginDto);
        return service.login(loginDto,response);
    }

    @GetMapping("menus")
    @ApiOperation("登陆成功后获取菜单")
    public Result<SaveLoginVo> menus(HttpServletRequest request) {
        log.info("登陆成功后获取菜单：menus)");
        return service.menus(TokenUtil.getToken(request));
    }

    @GetMapping("logout")
    @ApiOperation("登陆——登出直接删除token和用户信息和菜单信息")
    public Result logout(HttpServletRequest request) {
        log.info("登陆：logout)");
        return service.logout(TokenUtil.getToken(request));
    }

    @GetMapping("setPassword")
    @ApiOperation("修改密码——修改密码后让其重新登陆")
    public Result saveSetPassword(HttpServletRequest request, @Validated SaveSetPasswordDto saveSetPasswordDto) {
        log.info("修改密码：setPassword: {})", saveSetPasswordDto);
        return service.saveSetPassword(TokenUtil.getToken(request), saveSetPasswordDto);
    }

    @PostMapping("resetPassword")
    @ApiOperation("重置密码——管理员有权重置密码(在用户查询页面上),页面提示密码是：888888")
    public Result saveResetPassword(HttpServletRequest request, @Validated @RequestBody SaveResetPasswordDto saveResetPasswordDto) {
        log.info("重置密码：resetPassword: {})", saveResetPasswordDto);
        return service.saveResetPassword(TokenUtil.getToken(request), saveResetPasswordDto);
    }

}
