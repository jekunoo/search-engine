package com.java.strukdat.searchengine.model;

public class Node {
    String key;
    String value;
    String content;
    Node left, right, parent;
    boolean isRed; // true if red, false if black

    public Node(String key, String value, String content) {
        this.key = key;
        this.value = value;
        this.content = content;
        this.left = null;
        this.right = null;
        this.parent = null;
        this.isRed = true; // New nodes are red by default
    }

    public String getKey() {
        return key;
    }

    public String getContent() {
        return content;
    }

    public String getValue() {
        return value;
    }
}