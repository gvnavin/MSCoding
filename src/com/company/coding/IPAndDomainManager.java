package com.company.coding;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class IPAndDomainManager {

    /**
     Reverse DNS look up is using an internet IP address to find a domain name.
     For example, if you give 74.125.255.100 in browser,
     you will return the URL say www.microsoft.com

     Following are the operations needed from DNS look up cache:
        a. Add an IP address to URL Mapping in cache. put(IP, Domain)
        b. Find URL for a given IP address. findUrlByIp(String ip)
        c. Given a prefix/part of an IP address find all URLs in the cache
        getAllUrlsByIPPrefix(String ipPrefix)

     In Memory Coding
     Check in all conditions
     */

    private TrieNode root = new TrieNode('/');

    public void constructTrie(List<IPAndDomain> ipAndDomainList) {
        //since we have put, not implemented
        //TODO
    }

    public void put(IPAndDomain ipAndDomain) {
        final String ip = ipAndDomain.getIp();
        TrieNode tempNode = root;
        for (int i = 0; i < ip.length(); i++) {
            char c = ip.charAt(i);
            final TrieNode childNode = tempNode.addChild(c);
            tempNode = childNode;
        }
        tempNode.setDomain(ipAndDomain.getDomain());
    }

    public List<String> findDomainByIp(String ip) {
        try {
            return findInternal(ip);
        } catch (Throwable e) {
//            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    private List<String> findInternal(String ip) {
        TrieNode tempNode = root;
        for (int i = 0; i < ip.length(); i++) {
            char c = ip.charAt(i);
            final TrieNode childNode = tempNode.getChild(c);
            tempNode = childNode;
        }

        if (!tempNode.hasChildren()) {
            return List.of(tempNode.getDomain());
        } else {
            List<String> retList = new ArrayList<>();
            recursiveTraverse(tempNode, retList);
            return retList;
        }
    }

    private void recursiveTraverse(TrieNode tempNode, List<String> retList) {

        if (tempNode == null) {
            return;
        } else if (!tempNode.hasChildren()) {
            retList.add(tempNode.getDomain());
            return;
        }

        final Collection<TrieNode> children = tempNode.getChildren();
        for (TrieNode child : children) {
            recursiveTraverse(child, retList);
        }
    }

}
