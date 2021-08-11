package com.guardlbt.config;

import com.guardlbt.common.constant.Constants;
import com.guardlbt.common.exception.ResultException;
import com.guardlbt.common.util.ResultErrorCode;
import com.guardlbt.common.util.TokenUtil;
import com.guardlbt.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Slf4j
public class TokenHandler implements HandlerInterceptor {

    @Autowired
    private RedisTemplate redisTemplate;

    //不需要认证的
    @Value("${noCertification}")
    private String noCertification;
    @Value("${token_time:30}")
    private int tokenTime;

    @Autowired
    private TokenUtil tokenUtil;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String method = request.getMethod();
        String servletPath = request.getServletPath();
        //无需认证的——以竖线隔开
        if (null != noCertification && StringUtils.isNotBlank(noCertification)) {
            String[] str = noCertification.split(";");
            boolean r = checkWhiteList(servletPath + "@" + method.toLowerCase(), str);
            if (r) {
                //如果无需要验证
                return true;
            }
        }
        String token = TokenUtil.getToken(request);

        if (token == null || StringUtils.isBlank(token)) {
            throw new ResultException(ResultErrorCode.TOKEN_ERROR);
        }
        String[] oauthByToken = tokenUtil.getOauthByToken(token);
        if (oauthByToken == null || oauthByToken.length == 0) {
            throw new ResultException(ResultErrorCode.TOKEN_ERROR);
        }
        //菜单无需要验证——配置
         if ("/menus@get".equals(servletPath + "@" + method.toLowerCase()) || "/setPassword@get".equals(servletPath + "@" + method.toLowerCase())) {
             return true;
         }
        boolean r1 = checkWhiteList(servletPath + "@" + method.toLowerCase(), oauthByToken);
        if (!r1) {
            log.error("无访问权限");
            throw new ResultException(ResultErrorCode.NO_OAUTH);
        }
        //查看是用户是否被锁定
        Object u = redisTemplate.opsForValue().get(Constants.TOKEN_U_PREFIX + token);
        if (u == null) {
            log.error("token过期");
            throw new ResultException(ResultErrorCode.TOKEN_ERROR);
        }
        User user = (User) u;
        if (user.getStatus() == 2) {
            log.error("用户账户被锁定");
            throw new ResultException(ResultErrorCode.USER_LOCK);
        }
        //  设置三时分钟token有效期
        redisTemplate.expire(Constants.TOKEN_U_PREFIX + token, tokenTime, TimeUnit.MINUTES);
        redisTemplate.expire(Constants.TOKEN_P_PREFIX + token, tokenTime, TimeUnit.MINUTES);
        redisTemplate.expire(Constants.USER_TOKEN + user.getUserId(), tokenTime, TimeUnit.MINUTES);
        return true;
    }

    private static boolean checkWhiteList(String servletPath, String[] str) {
        List<String> strings = Arrays.asList(str);
        //使用spring中的AntPathMatcher类进行路径匹配
        AntPathMatcher antPathMatcher = new AntPathMatcher();
        Boolean flag = false;
        for (String s : strings) {
            if (antPathMatcher.match(s,servletPath)) {
                flag = true;
                break;
            }
        }
        return flag;
    }


}
