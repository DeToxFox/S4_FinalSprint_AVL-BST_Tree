package com.keyin.bst_avl_trees;

public class Node {
    private int key;
    private Node left;
    private Node right;

    // Constructors taking in no arguments
    public Node() {

    }
    // Constructor taking in all arguments
    public Node(int key, Node left, Node right, int height) {
        this.key = key;
        this.left = left;
        this.right = right;
    }

    // Constructor taking in only the key and
    // setting the left and right children to null
    public Node(int key) {
        this.key = key;
        this.left = null;
        this.right = null;
    }

    // Getter and setter methods for the private instance variables
    public int getKey() {
        return this.key;
    }
    public void setKey(int key) {
        this.key = key;
    }

    public Node getLeft() {
        return this.left;
    }
    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return this.right;
    }
    public void setRight(Node right) {
        this.right = right;
    }
}
