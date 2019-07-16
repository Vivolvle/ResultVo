package com.vivolvle.common.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author liangzheng.wei
 * @version 1.0
 * @date 2019/7/16 19:58
 */
@Slf4j
public class AfterInspector extends HandlerInterceptorAdapter {

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
                                @Nullable Exception ex) throws Exception {
        String value = String.valueOf(request.getAttribute("name"));
        log.info("the value from request: "+value);
    }
}
