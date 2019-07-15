package com.vivolvle.policy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liangzheng.wei
 * @version 1.0
 * @date 2019/7/15 14:38
 */
public class TestService {
    public static void main(String[] args) {
        List<PolicyBO> subPolicies = new ArrayList<>();
        PolicyBO policyBO1 = new PolicyBO(1L, 0.2f);
        PolicyBO policyBO2 = new PolicyBO(2L, 0.1f);
        PolicyBO policyBO3 = new PolicyBO(3L, 0.1f);
        PolicyBO policyBO4 = new PolicyBO(4L, 0.1f);
        PolicyBO policyBO5 = new PolicyBO(5L, 0.1f);
        subPolicies.add(policyBO1);
        subPolicies.add(policyBO2);
        subPolicies.add(policyBO3);
        subPolicies.add(policyBO4);
        subPolicies.add(policyBO5);
        PolicyBO policyBO = ProxyGroup.createPolicyBO(subPolicies);
        System.out.println(policyBO.toString());
    }
}
