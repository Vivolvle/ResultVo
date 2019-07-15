package com.vivolvle.example;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liangzheng.wei
 * @version 1.0
 * @date 2019/7/15 11:58
 */
public class ProxyGroup {
    private static final String PROXY_GAP = ",";
    private static final String IP_PORT_GAP = ":";

    private List<Proxy> proxies;

    public ProxyGroup(String proxiesStr) {
        String[] proxyStrList = proxiesStr.split(PROXY_GAP);
        List<Proxy> proxies = new ArrayList<>(proxyStrList.length);

        for (String proxyStr : proxyStrList) {
            String[] strs = proxyStr.split(IP_PORT_GAP);
            try{
                Proxy proxy = null;
                if(strs.length == 3) {
                    proxy = new Proxy(strs[0].trim(),
                            Integer.valueOf(strs[1].trim()),
                            Float.parseFloat(strs[2].trim()));
                } else {
                    proxy = new Proxy(strs[0].trim(),
                            Integer.valueOf(strs[1].trim()));
                }
                proxies.add(proxy);
            }catch (Exception e) {
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

    public static void main(String[] args) {
        String str = "A:2181:0.2,B:2181:0.1,C:2181:0.1,D:2181:0.1,E:2181:0.1";
        ProxyGroup pg = new ProxyGroup(str);
        for(int i = 0; i < 20; i++) {
            System.out.println(pg.nextProxy());
        }
        //System.out.println(pg.nextProxy());
    }
}
