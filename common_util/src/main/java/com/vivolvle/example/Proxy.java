package com.vivolvle.example;

import org.apache.commons.lang3.builder.CompareToBuilder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @author liangzheng.wei
 * @version 1.0
 * @date 2019/7/15 11:59
 */
public class Proxy {
    private static final long serialVersionUID = 6545464766494902366L;

    private final String ip;

    private final int port;

    private final float weight;

    private float curWeight = 0;

    public Proxy(String ip, int port) {
        this(ip, port, 1);
    }

    public Proxy(String ip, int port, float weight) {
        super();
        this.ip = ip;
        this.port = port;
        if(weight < 0) {
            weight = 0;
        }
        this.weight = weight;
    }

    public String getIp() {
        return ip;
    }

    public int getPort() {
        return port;
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
            toString = new ToStringBuilder(this).append("ip", ip).append("port", port).append("weight", weight)
                    .toString();
        }
        return toString;
    }

    public int compareTo(final Proxy other) {
        return new CompareToBuilder().append(ip, other.ip).append(port, other.port).append(weight, other.weight)
                .toComparison();
    }

    @Override
    public boolean equals(final Object other) {
        if (!(other instanceof Proxy))
            return false;
        Proxy castOther = (Proxy) other;
        return new EqualsBuilder().append(ip, castOther.ip).append(port, castOther.port)
                .append(weight, castOther.weight).isEquals();
    }

    private transient int hashCode;

    @Override
    public int hashCode() {
        if (hashCode == 0) {
            hashCode = new HashCodeBuilder().append(ip).append(port).append(weight).toHashCode();
        }
        return hashCode;
    }
}
