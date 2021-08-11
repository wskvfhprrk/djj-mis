package com.guardlbt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class InterceptorConfig  implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //多个拦截器组成一个拦截器链
        // addPathPatterns用于添加拦截规则
        // excludePathPatterns用户排除拦截
        registry.addInterceptor(signFilter()).addPathPatterns("/admin/login");
        registry.addInterceptor(signFilter()).addPathPatterns("/admin/valiteCode");
        registry.addInterceptor(loginInterceptor()).addPathPatterns("/**");
        registry.addInterceptor(loginInterceptor()).excludePathPatterns("/admin/login");
        registry.addInterceptor(loginInterceptor()).excludePathPatterns("/admin/valiteCode");
    }

    @Bean //将自定义拦截器注册到spring bean中
    public  TokenHandler loginInterceptor(){
        return new TokenHandler();
    }

    @Bean
    public SignFilter signFilter(){
        return new SignFilter();
    }

}