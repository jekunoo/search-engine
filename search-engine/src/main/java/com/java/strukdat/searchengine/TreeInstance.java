package com.java.strukdat.searchengine;

import com.java.strukdat.searchengine.model.RedBlackTree;

public class TreeInstance {
    private static TreeInstance instance;
    private final RedBlackTree tree;

    private TreeInstance() {
        tree = new RedBlackTree();
    }

    public static TreeInstance getInstance() {
        if (instance == null) {
            instance = new TreeInstance();
        }
        return instance;
    }

    public RedBlackTree getTree() {
        return tree;
    }
}


