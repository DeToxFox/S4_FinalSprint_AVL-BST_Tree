package com.keyin.bst_avl_trees;

/*
 * Project: Final Sprint Project 2 - BST/AVL Tree
 * Course Name: Software Development
 * Written by: David Turner
 * Due Date: April 21, 2023
 */

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.Comparator;
import java.util.function.Consumer;

public class BST {
        // public Node root is needed because the instance variable root is private in the Node class
        public Node root;

        // this is the constructor for the BST class
        public BST() {
            root = null;
        }

        // myComparator is a variable that will be used to compare the tree to the avl tree
        Comparator<Integer> myComparator = Integer::compareTo;

        // this function will insert a new node in the tree
        public void insert(int key) {

            root = insertNode(root, key, myComparator);
        }

        // this function will insert a new node in the
        // tree the other part of this function is to
        // check if the tree is balanced or not and
        // could be considered a way to compare the tree to the avl tree
        // equivalent to a compare function in javascript
        public Node insertNode(Node node, int key, Comparator<Integer> comparator) {
            if (node == null) {
                node = new Node(key);
                return node;
            }

            int comparisonResult = comparator.compare(key, node.getKey());
            if (comparisonResult < 0)
                node.setLeft(insertNode(node.getLeft(), key, comparator));
            else if (comparisonResult > 0)
                node.setRight(insertNode(node.getRight(), key, comparator));

            return node;
        }

        // inOrderTraverse is used to traverse the tree in order from left to right
        // Consumer<Integer> callback is a function that will be called on each node
        public void inOrderTraverse(Consumer<Integer> callback) {
            inOrderTraverse(root, callback);
        }

        public void inOrderTraverse(Node node, Consumer<Integer> callback) {
            if (node != null) {
                inOrderTraverse(node.getLeft(), callback);
                callback.accept(node.getKey());
                inOrderTraverse(node.getRight(), callback);
            }
        }

        // preOrderTraverse is used to traverse the tree in pre-order from root to left to right
        public void preOrderTraverse(Consumer<Integer> callback) {
            preOrderTraverse(root, callback);
        }

        private void preOrderTraverse(Node node, Consumer<Integer> callback) {
            if (node != null) {
                callback.accept(node.getKey());
                preOrderTraverse(node.getLeft(), callback);
                preOrderTraverse(node.getRight(), callback);
            }
        }

        // postOrderTraverse is used to traverse the tree in post-order from left to right to root
        public void postOrderTraverse(Consumer<Integer> callback) {
            postOrderTraverse(root, callback);
        }

        private void postOrderTraverse(Node node, Consumer<Integer> callback) {
            if (node != null) {
                postOrderTraverse(node.getLeft(), callback);
                postOrderTraverse(node.getRight(), callback);
                callback.accept(node.getKey());
            }
        }

        // min is used to find the minimum value in the tree
        public Node min() {
            return minNode(root);
        }

        public Node minNode(Node node) {
            Node current = node;
            while (current != null && current.getLeft() != null) {
                current = current.getLeft();
            }
            return current;
        }

        // max is used to find the maximum value in the tree
        public Node max() {
            return maxNode(root);
        }

        private Node maxNode(Node node) {
            Node current = node;
            while (current != null && current.getRight() != null) {
                current = current.getRight();
            }
            return current;
        }

        // search is used to search for a value in the tree
        // the reason for the boolean is to return true or false
        // without the boolean the function would return the node which will happen in the next function
        public boolean search(int key) {
            return searchNode(root, key);
        }

        // the function below is the actual search function and will return the node value.
        // if 1 2 3 4 5 is inputted into the tree and if you search for 3 it will return 3,
        // if you search for 8 it will return null
        private boolean searchNode(Node node, int key) {
            if (node == null) {
                return false;
            }
            if (myComparator.compare(key, node.getKey()) < 0) {
                return searchNode(node.getLeft(), key);
            } else if (myComparator.compare(key, node.getKey()) > 0) {
                return searchNode(node.getRight(), key);
            } else {
                return true;
            }
        }

        // this function will delete a node from the tree
        public void remove(int key) {
            root = removeNode(root, key);
        }

        public Node removeNode(Node node, int key) {
            if (node == null) {
                return null;
            }
            if (myComparator.compare(key, node.getKey()) < 0) {
                node.setLeft(removeNode(node.getLeft(), key));
                return node;
            } else if (myComparator.compare(key, node.getKey()) > 0) {
                node.setRight(removeNode(node.getRight(), key));
                return node;
            } else {
                if (node.getLeft() == null && node.getRight() == null) {
                    node = null;
                    return node;
                }
                if (node.getLeft() == null) {
                    node = node.getRight();
                    return node;
                } else if (node.getRight() == null) {
                    node = node.getLeft();
                    return node;
                }
                Node temp = minNode(node.getRight());
                node.setKey(temp.getKey());
                node.setRight(removeNode(node.getRight(), temp.getKey()));
                return node;
            }
        }
    public String getJSONRepresentation() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        Gson gson = gsonBuilder.create();
        return gson.toJson(this.root);
    }
}