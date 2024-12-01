package com.java.strukdat.searchengine.model;

public class Node {
    String key;
    String value;
    Node left, right, parent;
    boolean isRed; // true if red, false if black

    public Node(String key, String value) {
        this.key = key;
        this.value = value;
        this.left = null;
        this.right = null;
        this.parent = null;
        this.isRed = true; // New nodes are red by default
    }

    public String getKey() {
        return key;
    }


    public String getValue() {
        return value;
    }
 }