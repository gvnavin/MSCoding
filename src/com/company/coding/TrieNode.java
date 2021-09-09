package com.company.coding;

import java.util.Collection;
import java.util.HashMap;

public class TrieNode {
    private char ipChar;
    private HashMap<Character, TrieNode> children = new HashMap<>();

    private String domain;

    public TrieNode(char ipChar) {
        this.ipChar = ipChar;
    }

    public Collection<TrieNode> getChildren() {
        return children.values();
    }

    public TrieNode getChild(char ch) {
        if (children.containsKey(ch)) {
            return children.get(ch);
        }
        throw new RuntimeException("Not exist");
    }

    public boolean hasChildren() {
        return !children.isEmpty();
    }

    public TrieNode addChild(char ch) {
        if (!children.containsKey(ch)) {
            final TrieNode node = new TrieNode(ch);
            children.put(ch, node);
            return node;
        } else {
            return children.get(ch);
        }
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public char getIpChar() {
        return ipChar;
    }

    public void setIpChar(char ipChar) {
        this.ipChar = ipChar;
    }
}
