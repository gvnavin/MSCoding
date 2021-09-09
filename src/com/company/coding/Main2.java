package com.company.coding;

import java.util.List;

public class Main2 {
    public static void main(String[] args) {
        final IPAndDomainManager ipAndDomainManager = new IPAndDomainManager();
        ipAndDomainManager.put(new IPAndDomain("74.125.255.100", "www.74.125.255.100.com"));
        ipAndDomainManager.put(new IPAndDomain("74.125.255.101", "www.74.125.255.101.com"));
        ipAndDomainManager.put(new IPAndDomain("74.225.255.101", "www.74.225.255.101.com"));

        testAndPrint(ipAndDomainManager,"74.125.255.100");
        testAndPrint(ipAndDomainManager,"74.125.255.101");
        testAndPrint(ipAndDomainManager,"74.225.255.101");

        testAndPrint(ipAndDomainManager,"74");
        testAndPrint(ipAndDomainManager,"74.");
        testAndPrint(ipAndDomainManager,"74.1");
        testAndPrint(ipAndDomainManager,"74.12");
        testAndPrint(ipAndDomainManager,"74.125");
        testAndPrint(ipAndDomainManager,"74.125.225.10");

        testAndPrint(ipAndDomainManager,"74.2");

//        notExist
        testAndPrint(ipAndDomainManager,"84.225.255.101");
    }

    static void testAndPrint(IPAndDomainManager ipAndDomainManager, String str) {
        final List<String> domainByIp = ipAndDomainManager.findDomainByIp(str);
        System.out.println(str + " = " + domainByIp);
    }
}
