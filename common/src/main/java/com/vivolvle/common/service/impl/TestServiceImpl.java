package com.vivolvle.common.service.impl;

import com.vivolvle.common.service.TestService;
import com.vivolvle.common.utils.ThreadLocalUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author liangzheng.wei
 * @version 1.0
 * @date 2019/7/16 19:25
 */
@Service
public class TestServiceImpl implements TestService {
    private static ThreadPoolExecutor executor = new ThreadPoolExecutor(3, 8,
            30L, TimeUnit.SECONDS, new LinkedBlockingDeque<>(8000));

    @Override
    public void writeIntoRequest(String value) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes()).getRequest();
        request.setAttribute("name", value);
    }

    @Override
    public void testThread(String value) {
        ThreadLocalUtil.setValue(value);
    }

    @Override
    public void testExecutor() {
        executor.execute(()->printThreadLocalValue());
    }

    private void printThreadLocalValue(){
        Object result = ThreadLocalUtil.getValue();
        System.out.println("name of currentThread from executor is "
                +Thread.currentThread().getName()+" the value is: "+ result);
    }
}
