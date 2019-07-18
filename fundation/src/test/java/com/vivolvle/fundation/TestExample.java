package com.vivolvle.fundation;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

/**
 * @author liangzheng.wei
 * @Description:
 * @date 2019/7/18 11:26
 * @Copyright: 2019 dingxiang-inc.com Inc. All rights reserved.
 */
@SpringBootTest
public class TestExample {

    @Test
    public void testOptional(){
//        String value = null;
//        System.out.println(Optional.ofNullable(value).map(String::toUpperCase).orElse("None"));
        String value = "someThing";
        System.out.println(Optional.ofNullable(value).map(String::toUpperCase).orElse("None"));
    }

}
