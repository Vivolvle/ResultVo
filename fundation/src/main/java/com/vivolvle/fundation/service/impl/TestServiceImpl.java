package com.vivolvle.fundation.service.impl;

import com.vivolvle.fundation.service.TestService;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author liangzheng.wei
 * @version 1.0
 * @date 2019/7/11 20:05
 */
@Service
public class TestServiceImpl implements TestService {
    private Map<String, Integer> target = new ConcurrentHashMap<>();

    @Override
    public void insert(Integer value) {
        target.put("name", value);
    }

    @Override
    public Integer getValue() {
        return target.get("name");
    }
}
