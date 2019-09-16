package com.vivolvle.common.controller;

import com.vivolvle.common.command.TestCommand;
import com.vivolvle.common.error.BusinessException;
import com.vivolvle.common.error.EmBusinessError;
import com.vivolvle.common.response.ServerResponce;
import com.vivolvle.common.service.TestService;
import com.vivolvle.common.utils.ThreadLocalUtil;
import com.vivolvle.common.validator.ValidationResult;
import com.vivolvle.common.validator.ValidatorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: weilz
 * @Date: 2019/5/22 9:55
 */
@RestController
public class TestController {
    @Autowired
    private TestService testService;

    @GetMapping("/adapter/{value}")
    public ServerResponce getMsg(@PathVariable("value") String value) {
        testService.writeIntoRequest(value);
        return ServerResponce.createBySuccessMessage("测试成功");
    }

    @GetMapping("/thread/{value}")
    public ServerResponce testThreadLocal(@PathVariable("value") String value){
        testService.testThread(value);
        Object result = ThreadLocalUtil.getValue();
        System.out.println("name of currentThread is "
                +Thread.currentThread().getName()+" the value is: "+ result);
        return ServerResponce.createBySuccess(result);
    }

    @GetMapping("/asynchronous/{value}")
    public ServerResponce asynchronous(@PathVariable("value") String value){
        System.out.println("name of currentThread from controller is "
                +Thread.currentThread().getName());
        ThreadLocalUtil.setValue(value);
        testService.testExecutor();
        return ServerResponce.createBySuccessMessage("测试成功");
    }

    @PostMapping("/validate")
    public ServerResponce validate(@RequestBody TestCommand testCommand) {
        ValidationResult result = ValidatorUtil.validate(testCommand);
        if (result.isHasErrors()) {
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR, result.getErrMsg());
        }
        String name = "123";
        System.out.println(Long.valueOf(name).longValue());
        return ServerResponce.createBySuccessMessage("测试成功");
    }

    @PostMapping("/validateList")
    public ServerResponce validateList(@RequestBody List<TestCommand> testCommandList) {
        for (TestCommand testCommand : testCommandList) {
            ValidationResult result = ValidatorUtil.validate(testCommand);
            if (result.isHasErrors()) {
                throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR, result.getErrMsg());
            }
        }
        return ServerResponce.createBySuccessMessage("测试成功");
    }

}
