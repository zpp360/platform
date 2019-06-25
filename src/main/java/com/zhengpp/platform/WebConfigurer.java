package com.zhengpp.platform;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 过滤器配置
 */
@Configuration
public class WebConfigurer implements WebMvcConfigurer {

    /*@Autowired
    private TokenInterceptor tokenInterceptor;*/


    /**
     * 注册拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //excludePathPatterns  除了获取token都需要拦截
        //registry.addInterceptor(tokenInterceptor).addPathPatterns("/**").excludePathPatterns("/token");
    }

}

