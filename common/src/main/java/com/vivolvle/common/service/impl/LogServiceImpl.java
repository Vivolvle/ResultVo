package com.vivolvle.common.service.impl;

import com.vivolvle.common.service.LogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author liangzheng.wei
 * @version 1.0
 * @date 2019/7/17 9:36
 */
@Service
@Slf4j
public class LogServiceImpl implements LogService {
    @Override
    public void printRequest() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes()).getRequest();
        String value = String.valueOf(request.getAttribute("name"));
        log.info("the value from request: "+value);
    }
}
