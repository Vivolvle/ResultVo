package com.vivolvle.common.controller;

import com.vivolvle.common.command.TestCommand;
import com.vivolvle.common.error.BusinessException;
import com.vivolvle.common.error.EmBusinessError;
import com.vivolvle.common.response.ServerResponce;
import com.vivolvle.common.validator.ValidationResult;
import com.vivolvle.common.validator.ValidatorImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: weilz
 * @Date: 2019/5/22 9:55
 */
@RestController
public class TestController {

    @Autowired
    private ValidatorImpl validator;

    @GetMapping("/msg")
    public ServerResponce getMsg() {
        return ServerResponce.createBySuccessMessage("测试成功");
    }

    @PostMapping("/validate")
    public ServerResponce validate(@RequestBody TestCommand testCommand) {
        ValidationResult result = validator.validate(testCommand);
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
            ValidationResult result = validator.validate(testCommand);
            if (result.isHasErrors()) {
                throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR, result.getErrMsg());
            }
        }
        return ServerResponce.createBySuccessMessage("测试成功");
    }

}
