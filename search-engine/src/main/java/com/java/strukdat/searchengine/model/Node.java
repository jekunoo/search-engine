package com.java.strukdat.searchengine.model;

public class Node {
    String key;
    String value;
    String imgPath;
    Node left, right, parent;
    boolean isRed; // true if red, false if black

    public Node(String key, String value, String imgPath) {
        this.key = key;
        this.value = value;
        this.imgPath = imgPath;
        this.left = null;
        this.right = null;
        this.parent = null;
        this.isRed = true; // New nodes are red by default
    }

    public String getKey() {
        return key;
    }

    public String getContent() {
        return imgPath;
    }

    public String getValue() {
        return value;
    }
}