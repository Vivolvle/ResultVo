package com.vivolvle.common.interceptor;

import com.vivolvle.common.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author liangzheng.wei
 * @version 1.0
 * @date 2019/7/16 19:58
 */
public class AfterInspector extends HandlerInterceptorAdapter {
    @Autowired
    private LogService logService;

    /**
     * 如果不把AfterInspector作为Bean写入到配置中，调用service都会报空指针，可以从bean工厂取
     * 当然最简单的就是AfterInspector作为bean，写入到配置里面去
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
                                @Nullable Exception ex) throws Exception {
//        if (logService == null) {//解决service为null无法注入问题
//            System.out.println("logService is null!!!");
//            BeanFactory factory = WebApplicationContextUtils
//                    .getRequiredWebApplicationContext(request.getServletContext());
//            logService = factory
//                    .getBean(LogService.class);
//        }
//        logService.printRequest();
    }

}
