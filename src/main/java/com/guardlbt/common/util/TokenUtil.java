package com.guardlbt.common.util;

import com.guardlbt.common.constant.Constants;
import com.guardlbt.entity.User;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Service
public class TokenUtil {

    @Autowired
    private RedisTemplate redisTemplate;
    @Value("${token_time}")
    private int tokenTime;

    public static String getToken(HttpServletRequest request) {
        String token = request.getHeader("token");
        //swagger可用
//        if (null == token || StringUtils.isBlank(token)) {
//            Cookie[] cookies = request.getCookies();
//            if(cookies==null ||cookies.length==0){
//                return null;
//            }
//            for (Cookie c : cookies) {
//                if (c.getName().equals("session")) {
//                    token = c.getValue();
//                }
//            }
//        }
        return token;
    }

    public User getUserByToken(String token) {
        if(token==null){
            return null;
        }
        User user;
        Object o = redisTemplate.opsForValue().get(Constants.TOKEN_U_PREFIX + token);
        if (null == o) {
            return null;
        }
        user = (User) o;
        return user;
    }

    public String[] getOauthByToken(String token) {
        Object o = redisTemplate.opsForValue().get(Constants.TOKEN_P_PREFIX + token);
        if (null != o) {
            List<String> oauth = (ArrayList)o;
            String[] arr = new String[oauth.size()];
            oauth.toArray(arr);
            return arr;
        }
//        String[] arr = o.toString().split(";");
        return null;
    }
}
