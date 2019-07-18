package com.vivolvle.service.impl;

import com.vivolvle.service.ReviewService;

/**
 * @author liangzheng.wei
 * @Description:
 * @date 2019/7/18 14:34
 * @Copyright: 2019 dingxiang-inc.com Inc. All rights reserved.
 */
public class ReviewServiceImpl implements ReviewService {

    @Override
    public String getName() {
        return "child name";
    }

    @Override
    public String getValue(){
        return "overWriteValue";
    }

    public static void main(String[] args) {
        ReviewService reviewService = new ReviewServiceImpl();
        System.out.println(reviewService.getName());
        System.out.println(reviewService.getValue());
    }

}
