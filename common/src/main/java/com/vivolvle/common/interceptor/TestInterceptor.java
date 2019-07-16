package com.vivolvle.common.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @author liangzheng.wei
 * @version 1.0
 * @date 2019/7/16 19:28
 */
@Configuration
public class TestInterceptor extends WebMvcConfigurationSupport {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AfterInspector());
    }

}
