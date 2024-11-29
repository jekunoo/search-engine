package com.java.strukdat.searchengine.model;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RedBlackTree {
    private Node root;
    private Node TNULL;

    public Node search(String key) {
        return searchHelper(this.root, key);
    }

    private Node searchHelper(Node node, String key) {
        if (node == TNULL || key.equalsIgnoreCase(node.key)) {
            return node;
        }

        if (key.compareToIgnoreCase(node.key) < 0) {
            return searchHelper(node.left, key);
        } else {
            return searchHelper(node.right, key);
        }
    }

    public List<Node> searchBySubstring(String substring) {
        List<Node> result = new ArrayList<>();
        searchBySubstringHelper(this.root, substring.toLowerCase(), result);
        return result;
    }

    // Helper method for searchBySubstring
    private void searchBySubstringHelper(Node node, String substring, List<Node> result) {
        if (node == TNULL) {
            return; // Base case: reached a leaf
        }

        // Check if the current node's key contains the substring
        if (node.key.toLowerCase().contains(substring)) {
            result.add(node);
        }

        // Recursively search in the left and right subtrees
        searchBySubstringHelper(node.left, substring, result);
        searchBySubstringHelper(node.right, substring, result);
    }

    public void visualize() {
        if (root == TNULL) {
            System.out.println("The tree is empty.");
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            System.out.print("Level " + level + ": ");
            for (int i = 0; i < levelSize; i++) {
                Node node = queue.poll();
                if (node == TNULL) {
                    System.out.print("TNULL ");
                } else {
                    System.out.print((node.isRed ? "R" : "B") + "(" + node.key + ") ");
                    queue.add(node.left);
                    queue.add(node.right);
                }
            }
            System.out.println();
            level++;
        }
    }

    // Preorder
    private void preOrderHelper(Node node) {
        if (node != TNULL) {
            System.out.print(node.key + " ");
            preOrderHelper(node.left);
            preOrderHelper(node.right);
        }
    }

    // Balance the tree after deletion of a node
    private void fixInsert(Node k) {
        Node u;
        while (k.parent != null && k.parent.isRed) { // Check if parent is not null
            if (k.parent == k.parent.parent.right) {
                u = k.parent.parent.left; // uncle
                if (u.isRed) {
                    // case 3.1
                    u.isRed = false;
                    k.parent.isRed = false;
                    k.parent.parent.isRed = true;
                    k = k.parent.parent;
                } else {
                    if (k == k.parent.left) {
                        // case 3.2.2
                        k = k.parent;
                        rightRotate(k);
                    }
                    // case 3.2.1
                    k.parent.isRed = false;
                    k.parent.parent.isRed = true;
                    leftRotate(k.parent.parent);
                }
            } else {
                u = k.parent.parent.right; // uncle

                if (u.isRed) {
                    // mirror case 3.1
                    u.isRed = false;
                    k.parent.isRed = false;
                    k.parent.parent.isRed = true;
                    k = k.parent.parent;
                } else {
                    if (k == k.parent.right) {
                        // mirror case 3.2.2
                        k = k.parent;
                        leftRotate(k);
                    }
                    // mirror case 3.2.1
                    k.parent.isRed = false;
                    k.parent.parent.isRed = true;
                    rightRotate(k.parent.parent);
                }
            }
            if (k == root) {
                break;
            }
        }
        root.isRed = false; // Ensure the root is black
    }

    private void leftRotate(Node x) {
        Node y = x.right;
        x.right = y.left;
        if (y.left != TNULL) {
            y.left.parent = x;
        }
        y.parent = x.parent;
        if (x.parent == null) {
            this.root = y;
        } else if (x == x.parent.left) {
            x.parent.left = y;
        } else {
            x.parent.right = y;
        }
        y.left = x;
        x.parent = y;
    }

    private void rightRotate(Node x) {
        Node y = x.left;
        x.left = y.right;
        if (y.right != TNULL) {
            y.right.parent = x;
        }
        y.parent = x.parent;
        if (x.parent == null) {
            this.root = y;
        } else if (x == x.parent.right) {
            x.parent.right = y;
        } else {
            x.parent.left = y;
        }
        y.right = x;
        x.parent = y;
    }

    public RedBlackTree() {
        TNULL = new Node("", "", ""); // Sentinel node
        TNULL.isRed = false;
        root = TNULL;
    }

    public void insert(String key, String value, String content) {
        Node node = new Node(key, value, content);
        node.parent = null;
        node.left = TNULL;
        node.right = TNULL;

        Node y = null;
        Node x = this.root;

        while (x != TNULL) {
            y = x;
            if (node.key.compareTo(x.key) < 0) {
                x = x.left;
            } else {
                x = x.right;
            }
        }

        node.parent = y;
        if (y == null) {
            root = node;
        } else if (node.key.compareTo(y.key) < 0) {
            y.left = node;
        } else {
            y.right = node;
        }

        // Fix the tree
        fixInsert(node);
    }

    // Preorder traversal
    public void preOrder() {
        preOrderHelper(this.root);
    }

    public void printTree() {
        printTreeHelper(this.root, 0);
    }

    private void printTreeHelper(Node node, int space) {
        if (node == TNULL) return;

        space += 10; // Increase distance between levels

        printTreeHelper(node.right, space); // Process right child first

        System.out.println();
        for (int i = 10; i < space; i++) System.out.print(" "); // Print spaces
        System.out.print(node.key + (node.isRed ? "R" : "B") + "\n"); // Print node key and color

        printTreeHelper(node.left, space); // Process left child
    }

}