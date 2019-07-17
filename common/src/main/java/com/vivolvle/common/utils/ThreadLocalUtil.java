package com.vivolvle.common.utils;

/**
 * @author liangzheng.wei
 * @date 2019/7/17 14:38
 * @Copyright: 2019 dingxiang-inc.com Inc. All rights reserved.
 */
public class ThreadLocalUtil {
    private static final ThreadLocal THREAD_LOCAL = new ThreadLocal();

    public static void setValue(Object value){
        THREAD_LOCAL.set(value);
    }

    public static Object getValue(){
        Object value = THREAD_LOCAL.get();
        THREAD_LOCAL.remove();
        return value;
    }

}
