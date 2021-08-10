package com.guardlbt.controller;

import com.guardlbt.common.exception.ResultException;
import com.guardlbt.common.util.Result;
import com.guardlbt.common.util.ResultErrorCode;
import com.guardlbt.dto.AdminLoginDto;
import com.guardlbt.dto.ValiteCodedto;
import com.guardlbt.entity.Admin;
import com.guardlbt.entity.Blacklist;
import com.guardlbt.mapper.AdminMapper;
import com.guardlbt.mapper.BlacklistMapper;
import com.guardlbt.service.CouponService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import static com.guardlbt.common.constant.Constants.ERROR_USER;
import static com.guardlbt.common.constant.Constants.TOKEN_V_PREFIX;

/**
 * 上海电子券验证类
 */
@RestController
public class LoginController {

    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private BlacklistMapper blacklistMapper;
    @Autowired
    private CouponService couponService;

    @PostMapping("/admin/login")
    public Result login(@Validated AdminLoginDto dto) throws ResultException {
        String token = UUID.randomUUID().toString().replaceAll("-", "");
            //先验证验证码
            validateImagecode(dto);
            //从数据库中查出此条数据
            Admin admin = adminMapper.selectByPrimaryKey(dto.getPhone());
            //先判断用户是否存在
            if(admin==null) throw new ResultException(ResultErrorCode.USER_NONE);
            //是否此用户被锁定
            validateIsColk(admin);
            //用户名密码验证
            validateUsernamePassowrd(dto);
            //miei是否被锁定
            validateImei(dto, admin);
            //此手机号是否上了黑名单
            Blacklist blacklist = blacklistMapper.selectByPrimaryKey(dto.getPhone());
            if (blacklist != null) {
                throw new ResultException(ResultErrorCode.USSR_BLACK);
            }
            //验证通过后发放token值
            //绑定值user信息到redis中
            redisTemplate.opsForValue().set(TOKEN_V_PREFIX +  token, admin, 259200, TimeUnit.SECONDS);
            Map map=new HashMap<>();
            map.put("token",token);
        return Result.ok(map);
    }

    private void validateImagecode(AdminLoginDto dto) throws ResultException {
        String s = TOKEN_V_PREFIX+ dto.getImageCode();
        Object o = redisTemplate.opsForValue().get(s);
        if (o == null) {
            throw new ResultException(ResultErrorCode.VALIDATECODE_ERROR);
        }
        String code = (String) o;
        if (!StringUtils.equalsIgnoreCase(dto.getImageCode(), code)) {
            throw new ResultException(ResultErrorCode.VALIDATECODE_ERROR);
        }
        //删除session中的验证码
        redisTemplate.delete(s);
    }

    private void validateIsColk(Admin user) throws ResultException {
        if (user.getIslock() == 3) throw new ResultException(ResultErrorCode.USER_LOCK);
    }

    private void validateImei(AdminLoginDto dto, Admin user) throws ResultException {
        //用户第一次登陆绑定imei
        if (StringUtils.isBlank(user.getImei())) {
            user.setImei(dto.getImei());
            adminMapper.updateByPrimaryKey(user);
        }
        if (!StringUtils.equals(user.getImei(), dto.getImei())) throw new ResultException(ResultErrorCode.IMEI_ERROR);
    }

    private void validateUsernamePassowrd(AdminLoginDto dto) throws ResultException {
        Admin admin = adminMapper.selectByPrimaryKey(dto.getPhone());
        if (!StringUtils.equals(dto.getPassword(), admin.getPassword())) {
            String errorSession = ERROR_USER + dto.getPhone();
            Object attribute = redisTemplate.opsForValue().get(errorSession);
            if (attribute == null) {
                redisTemplate.opsForValue().set(errorSession, 1);
                throw new ResultException(ResultErrorCode.USER_PASSWORD_ERROR);
            }
            if (attribute != null) {
                Integer num = (Integer) attribute;
                //如果输入密码错误3次锁定
                if (num == 1) {
                    redisTemplate.opsForValue().set(errorSession, num + 1);
                    throw new ResultException(ResultErrorCode.USER_PASSWORD_ERROR);
                }
                if (num == 2) {
                    admin.setIslock(1);
                    adminMapper.updateByPrimaryKeySelective(admin);
                    throw new ResultException(ResultErrorCode.USER_PASSWORD_ERROR);
                }
            }
            //删除redis
            redisTemplate.delete(errorSession);
        }

    }
    @PostMapping("/admin/valiteCode")
    public Result valiteCode(@Validated ValiteCodedto dto){
        Result result= couponService.valiteCode(dto);
        return result;
    }

}
