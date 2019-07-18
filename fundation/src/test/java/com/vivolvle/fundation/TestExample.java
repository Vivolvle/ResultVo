package com.vivolvle.fundation;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Objects;
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

    /**
     * null的时候Objects.isNull()才为true
     * 但是lang3里面的方法就是都为null,不管是Blank还是Empty
     */
    @Test
    public void testObject(){
        String str = null;
        System.out.println(Objects.isNull(str));
        System.out.println(StringUtils.isBlank(str));
        System.out.println(StringUtils.isEmpty(str));
    }

}
