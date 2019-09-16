package com.vivolvle.fundation.controller;

import com.vivolvle.fundation.command.CodeCell;
import com.vivolvle.fundation.command.IndexCommand;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author liangzheng.wei
 * @Description:
 * @date 2019/8/29 10:24
 * @Copyright: 2019 dingxiang-inc.com Inc. All rights reserved.
 */
@RestController
public class IndexController {

    @PostMapping("/index/test")
    public void test(@RequestBody IndexCommand indexCommand){
        String name = indexCommand.getName();
        List<CodeCell> list = indexCommand.getList();
    }
}
