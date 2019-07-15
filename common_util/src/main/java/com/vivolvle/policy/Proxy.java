package com.vivolvle.policy;

import org.apache.commons.lang3.builder.CompareToBuilder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @author liangzheng.wei
 * @version 1.0
 * @date 2019/7/15 13:56
 */
public class Proxy {
    private final PolicyBO policyBO;

    private final float weight;

    private float curWeight = 0;

    public Proxy(PolicyBO policyBO) {
        this(policyBO,policyBO.getGrayScale());
    }

    public Proxy(PolicyBO policyBO, float weight) {
        super();
        this.policyBO = policyBO;
        if(weight < 0) {
            weight = 0;
        }
        this.weight = weight;
    }

    public PolicyBO getPolicyBO() {
        return policyBO;
    }

    public float getWeight() {
        return weight;
    }

    public float getCurWeight() {
        return curWeight;
    }

    public void setCurWeight(float curWeight) {
        this.curWeight = curWeight;
    }

    private transient String toString;

    @Override
    public String toString() {
        if (toString == null) {
            toString = new ToStringBuilder(this).append("policyBO", policyBO).append("weight", weight)
                    .toString();
        }
        return toString;
    }

    public int compareTo(final Proxy other) {
        return new CompareToBuilder().append(policyBO, other.policyBO).append(weight, other.weight)
                .toComparison();
    }

    @Override
    public boolean equals(final Object other) {
        if (!(other instanceof Proxy))
            return false;
        Proxy castOther = (Proxy) other;
        return new EqualsBuilder().append(policyBO, castOther.policyBO)
                .append(weight, castOther.weight).isEquals();
    }

    private transient int hashCode;

    @Override
    public int hashCode() {
        if (hashCode == 0) {
            hashCode = new HashCodeBuilder().append(policyBO).append(weight).toHashCode();
        }
        return hashCode;
    }
}
