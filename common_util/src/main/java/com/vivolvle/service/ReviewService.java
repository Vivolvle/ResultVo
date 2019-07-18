package com.vivolvle.service;

/**
 * @author liangzheng.wei
 * @Description:
 * @date 2019/7/18 14:34
 * @Copyright: 2019 dingxiang-inc.com Inc. All rights reserved.
 */
public interface ReviewService {
    String getName();

    default String getValue(){
        return "This is defaultValue";
    }
}
