package com.vivolvle.group;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author liangzheng.wei
 * @Description:
 * @date 2019/7/24 16:09
 * @Copyright: 2019 dingxiang-inc.com Inc. All rights reserved.
 */
public class GroupMap {
    public static void main(String[] args) {
        Map<Integer, Policy> map = new HashMap<>();
        map.put(1, new Policy("a70afc18-c465-45b1-b611-d9cb8b4ce8a4",null,"code8960690503"));
        map.put(2, new Policy("code8960690503", "a70afc18-c465-45b1-b611-d9cb8b4ce8a4", "code8960690503-1"));
        map.put(3, new Policy("code8960690503-1", "code8960690503", ""));
        map.put(4, new Policy("code8960690503-2", "code8960690503", ""));
        map.put(5, new Policy("code15639485859708560226571", "code8960690503", ""));
        Map<String, List<Policy>> result = map.values().stream().filter(p-> StringUtils.isNoneBlank(p.getParentCode()))
                .collect(Collectors.groupingBy(p->{return p.getParentCode();}));
        System.out.println(result.size());
    }
}
