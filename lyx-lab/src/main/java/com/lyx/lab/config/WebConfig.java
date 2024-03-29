package com.lyx.lab.config;

import com.lyx.lab.web.interceptor.SimpleHttpInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

@Configuration
public class WebConfig  implements WebMvcConfigurer {

    @Resource
    private SimpleHttpInterceptor simpleHttpInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 自定义拦截器，添加拦截路径和排除拦截路径
        registry.addInterceptor(simpleHttpInterceptor).addPathPatterns("/**");
    }
}
