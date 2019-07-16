package com.vivolvle.common.service.impl;

import com.vivolvle.common.service.TestService;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author liangzheng.wei
 * @version 1.0
 * @date 2019/7/16 19:25
 */
@Service
public class TestServiceImpl implements TestService {
    @Override
    public void writeIntoRequest(String value) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes()).getRequest();
        request.setAttribute("name", value);
    }
}
