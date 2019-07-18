package com.vivolvle.service.impl;

import com.vivolvle.service.ReviewService;

/**
 * @author liangzheng.wei
 * @Description:
 * @date 2019/7/18 14:34
 * @Copyright: 2019 dingxiang-inc.com Inc. All rights reserved.
 */
public class ReviewServiceImpl implements ReviewService {

    //private String version = "201409010900_99";

    private String version;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public void setVersionNO(String versionNo){
        setVersion(versionNo);
    }

    public static void main(String[] args) {
        ReviewService reviewService = new ReviewServiceImpl();
        reviewService.newVersion();
        System.out.println(((ReviewServiceImpl) reviewService).getVersion());
    }
}
