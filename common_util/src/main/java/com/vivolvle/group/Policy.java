package com.vivolvle.group;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author liangzheng.wei
 * @Description:
 * @date 2019/7/24 16:09
 * @Copyright: 2019 dingxiang-inc.com Inc. All rights reserved.
 */
@Data
@AllArgsConstructor
public class Policy {
    private String code;
    private String parentCode;
    private String subCode;
}
