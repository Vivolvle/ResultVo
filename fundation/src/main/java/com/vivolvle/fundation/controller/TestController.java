package com.vivolvle.fundation.controller;

import com.vivolvle.fundation.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liangzheng.wei
 * @version 1.0
 * @date 2019/7/11 20:00
 */
@RestController
public class TestController {
    @Autowired
    private TestService testService;

    @GetMapping("/insert/{value}")
    public void insert(@PathVariable("value") Integer value) {
        testService.insert(value);
    }

    @GetMapping("/get")
    public Integer get() {
        return testService.getValue();
    }

}
