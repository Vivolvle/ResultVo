package com.vivolvle.service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author liangzheng.wei
 * @Description:
 * @date 2019/7/18 14:34
 * @Copyright: 2019 dingxiang-inc.com Inc. All rights reserved.
 */
public interface ReviewService {

    default void setVersionNO(String versionNo){

    }

    default String newVersion(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String newVersion = simpleDateFormat.format(new Date()).replaceAll("[[\\s-:punct:]]", "");
        setVersionNO(newVersion);
        return newVersion;
    }
}
