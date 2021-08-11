package com.guardlbt.config;

import com.guardlbt.common.exception.ResultException;
import com.guardlbt.common.util.ResultErrorCode;
import com.guardlbt.sign.SignUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class SignFilter implements HandlerInterceptor {

    private AntPathMatcher antPathMatcher = new AntPathMatcher();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String uri = request.getRequestURI();
        //访问路径需要签名的进行签名验证，其它的直接走后面程序即可
        if (antPathMatcher.match(uri, "/AlipayAward/admin/login") || antPathMatcher.match(uri, "/AlipayAward/admin/valiteCode")) {
            //先判断时间为半小时之内
            Map<String, String[]> map = request.getParameterMap();
            if (map.get("time") == null) {
                throw new ResultException(ResultErrorCode.TIME_NONE);
            }
            if (map.get("sign") == null) {
                throw new ResultException(ResultErrorCode.SIGN_NONE);
            }
            String[] timpstamp = map.get("time");
            Long time = Long.parseLong(timpstamp[0]);
            long abs = Math.abs(time - System.currentTimeMillis());
            if (abs > 1800000) {
                log.info("time:{}",System.currentTimeMillis());
                throw new ResultException(ResultErrorCode.TIME_OUT);
            }

            Map<String, String> map1 = new HashMap<>();
            map.forEach((k, v) -> {
                String[] value = v;
                map1.put(k, v[0]);
            });
            boolean b = SignUtil.verifySign2(map1);
            if (!b) {
                throw new ResultException(ResultErrorCode.SIGN_ERROR);
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView
            modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception
            ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }

}
