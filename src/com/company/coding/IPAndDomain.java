package com.company.coding;

public class IPAndDomain {
    private String ip;
    private String domain;

    public IPAndDomain(String ip, String domain) {
        this.ip = ip;
        this.domain = domain;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }
}
