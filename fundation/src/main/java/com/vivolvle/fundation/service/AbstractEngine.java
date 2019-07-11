package com.vivolvle.fundation.service;

/**
 * @author liangzheng.wei
 * @version 1.0
 * @date 2019/7/11 20:23
 */
public abstract class AbstractEngine {

    public String getString(){
        return "helloWorld";
    }

    abstract String getWorld();

}
