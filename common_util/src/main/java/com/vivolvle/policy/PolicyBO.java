package com.vivolvle.policy;

import lombok.Data;

/**
 * @author liangzheng.wei
 * @version 1.0
 * @date 2019/7/15 13:54
 */
@Data
public class PolicyBO {
    public PolicyBO(Long appId, Float grayScale) {
        this.appId = appId;
        this.grayScale = grayScale;
    }

    private Long appId;
    //冠军挑战模式下的流量比率
    private Float grayScale;
}
