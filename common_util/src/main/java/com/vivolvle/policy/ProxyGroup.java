package com.vivolvle.policy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liangzheng.wei
 * @version 1.0
 * @date 2019/7/15 14:06
 */
public class ProxyGroup {

    private List<Proxy> proxies;

    public ProxyGroup(List<PolicyBO> policyBOList) {
        List<Proxy> proxies = new ArrayList<>(policyBOList.size());

        for (PolicyBO policyBO : policyBOList) {
            try {
                Proxy proxy = null;
                proxy = new Proxy(policyBO);
                proxies.add(proxy);
            }catch (Exception e){
                continue;
            }

        }
        this.proxies = proxies;
    }

    public synchronized Proxy nextProxy() {
        int index = -1;
        float total = 0;
        for (int i = 0; i < proxies.size(); i++) {
            Proxy p = proxies.get(i);
            p.setCurWeight(p.getCurWeight() + p.getWeight());
            total += p.getWeight();
            if(index == -1 || proxies.get(index).getCurWeight() < p.getCurWeight()) {
                index = i;
            }
        }

        proxies.get(index).setCurWeight(proxies.get(index).getCurWeight() - total);
        return proxies.get(index);
    }

    public int getProxyNum() {
        return proxies.size();
    }

    public static PolicyBO createPolicyBO(List<PolicyBO> policyBOList) {
        ProxyGroup proxyGroup = new ProxyGroup(policyBOList);
        return proxyGroup.nextProxy().getPolicyBO();
    }

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

        ProxyGroup proxyGroup = new ProxyGroup(subPolicies);
        for(int i = 0; i < 20; i++) {
            System.out.println(proxyGroup.nextProxy().getPolicyBO().toString());
        }

    }
}
