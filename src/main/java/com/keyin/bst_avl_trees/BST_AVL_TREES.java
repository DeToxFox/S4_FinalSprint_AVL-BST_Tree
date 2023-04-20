//package com.keyin.bst_avl_trees;
//
//import java.util.Comparator;
//import java.util.function.Consumer;
//
//public class BST_AVL_TREES {
//    // public Node root is needed because the instance variable root is private in the Node class
//    public Node root;
//
//    // this is the constructor for the BST_AVL_TREES class
//    public BST_AVL_TREES() {
//        root = null;
//    }
//
//    // myComparator is a variable that will be used to compare the tree to the avl tree
//    Comparator<Integer> myComparator = Integer::compareTo;
//
//    // this function will insert a new node in the tree
//    public void insert(int key) {
//
//        root = insertNode(root, key, myComparator);
//    }
//
//    // this function will insert a new node in the
//    // tree the other part of this function is to
//    // check if the tree is balanced or not and
//    // could be considered a way to compare the tree to the avl tree
//    // equivalent to a compare function in javascript
//    //  public Node insertNode(Node node, int key, Comparator<Integer> comparator) ORGIGINAL CODE {2}
//    public Node insertNode(Node node, int key, Comparator<Integer> comparator) {
//        if (node == null) {
//            node = new Node(key);
//            return node;
//        }
//
//        int comparisonResult = comparator.compare(key, node.getKey());
//        if (comparisonResult < 0)
//            node.setLeft(insertNode(node.getLeft(), key, comparator));
//        else if (comparisonResult > 0)
//            node.setRight(insertNode(node.getRight(), key, comparator));
//
//        return node;
//    }
//
//    // inOrderTraverse is used to traverse the tree in order from left to right
//    // Consumer<Integer> callback is a function that will be called on each node
//    public void inOrderTraverse(Consumer<Integer> callback) {
//        inOrderTraverse(root, callback);
//    }
//    public void inOrderTraverse(Node node, Consumer<Integer> callback) {
//        if (node != null) {
//            inOrderTraverse(node.getLeft(), callback);
//            callback.accept(node.getKey());
//            inOrderTraverse(node.getRight(), callback);
//        }
//    }
//
//    // preOrderTraverse is used to traverse the tree in pre-order from root to left to right
//    public void preOrderTraverse(Consumer<Integer> callback) {
//        preOrderTraverse(root, callback);
//    }
//    private void preOrderTraverse(Node node, Consumer<Integer> callback) {
//        if (node != null) {
//            callback.accept(node.getKey());
//            preOrderTraverse(node.getLeft(), callback);
//            preOrderTraverse(node.getRight(), callback);
//        }
//    }
//
//    // postOrderTraverse is used to traverse the tree in post-order from left to right to root
//    public void postOrderTraverse(Consumer<Integer> callback) {
//        postOrderTraverse(root, callback);
//    }
//    private void postOrderTraverse(Node node, Consumer<Integer> callback) {
//        if (node != null) {
//            postOrderTraverse(node.getLeft(), callback);
//            postOrderTraverse(node.getRight(), callback);
//            callback.accept(node.getKey());
//        }
//    }
//
//    // min is used to find the minimum value in the tree
//    public Node min() {
//        return minNode(root);
//    }
//    private Node minNode(Node node) {
//        Node current = node;
//        while (current != null && current.getLeft() != null) {
//            current = current.getLeft();
//        }
//        return current;
//    }
//
//    // max is used to find the maximum value in the tree
//    public Node max() {
//        return maxNode(root);
//    }
//    private Node maxNode(Node node) {
//        Node current = node;
//        while (current != null && current.getRight() != null) {
//            current = current.getRight();
//        }
//        return current;
//    }
//
//    // search is used to search for a value in the tree
//    // the reason for the boolean is to return true or false
//    // without the boolean the function would return the node which will happen in the next function
//    public boolean search(int key) {
//        return searchNode(root, key);
//    }
//    // the function below is the actual search function and will return the node value.
//    // if 1 2 3 4 5 is inputted into the tree and if you search for 3 it will return 3,
//    // if you search for 8 it will return null
//    private boolean searchNode(Node node, int key) {
//        if (node == null) {
//            return false;
//        }
//        if (myComparator.compare(key, node.getKey()) < 0) {
//            return searchNode(node.getLeft(), key);
//        } else if (myComparator.compare(key, node.getKey()) > 0) {
//            return searchNode(node.getRight(), key);
//        } else {
//            return true;
//        }
//    }
//
//    // this function will delete a node from the tree
//    public void remove(int key){
//        root = removeNode(root, key);
//    }
//    public Node removeNode(Node node, int key){
//        if (node ==  null){
//            return null;
//        }
//        if (myComparator.compare(key, node.getKey()) < 0) {
//            node.setLeft(removeNode(node.getLeft(), key));
//            return node;
//        } else if (myComparator.compare(key, node.getKey()) > 0) {
//            node.setRight(removeNode(node.getRight(), key));
//            return node;
//        } else {
//            if (node.getLeft() == null && node.getRight() == null) {
//                node = null;
//                return node;
//            }
//            if (node.getLeft() == null) {
//                node = node.getRight();
//                return node;
//            } else if (node.getRight() == null) {
//                node = node.getLeft();
//                return node;
//            }
//           Node temp = minNode(node.getRight());
//              node.setKey(temp.getKey());
//                node.setRight(removeNode(node.getRight(), temp.getKey()));
//                return node;
//        }
//    }
//    // ---------------------------------------------------- AVL TREE ----------------------------------------------------
//    // this next section will be the AVL tree, it should not need extends BST as it is in the same file
//    // ---------------------------------------------------- AVL TREE ----------------------------------------------------
//
//    // these constants will be use to determine balance and rotation
//    private static final int unbalancedRight = 1;
//    private static final int slightlyUnbalancedRight = 2;
//    private static final int balanced = 3;
//    private static final int slightlyUnbalancedLeft = 4;
//    private static final int unbalancedLeft = 5;
//
//    // constructor for AVL tree
//    public AVLTree(){
//        root = null;
//    }
//
//    // need to compare the height of the left and right side of the tree
//    // if the height of the left side is greater than the right side then it is unbalanced to the left
//    // if the height of the right side is greater than the left side then it is unbalanced to the right
//    // if the height of the left and right side are equal then it is balanced
//    // if the height of the left side is greater than the right side by 1 then it is slightly unbalanced to the left
//    // if the height of the right side is greater than the left side by 1 then it is slightly unbalanced to the right
//    private int balance(Node node){
//        if (node == null){
//            return 0;
//        }
//        int leftHeight = height(node.getLeft());
//        int rightHeight = height(node.getRight());
//        if (leftHeight > rightHeight + 1){
//            return unbalancedLeft;
//        }
//        if (leftHeight + 1 < rightHeight){
//            return unbalancedRight;
//        }
//        if (leftHeight > rightHeight){
//            return slightlyUnbalancedLeft;
//        }
//        if (leftHeight < rightHeight){
//            return slightlyUnbalancedRight;
//        }
//        return balanced;
//    }
//
//    // need a height function to determine the height of the tree
//    private int height(Node node){
//        if (node == null){
//            return 0;
//        }
//        return 1 + Math.max(height(node.getLeft()), height(node.getRight()));
//    }
//
//    // this is a getBalanceFactor function that will return the balance factor of the tree
//    public int getBalanceFactor(){
//        return balance(root);
//    }
//
//    // rotationLL is used to rotate a node to the left
//    private Node rotationLL(Node node){
//        Node temp = node.getLeft();
//        node.setLeft(temp.getRight());
//        temp.setRight(node);
//        return temp;
//    }
//    // rotationRR is used to rotate a node to the right
//    private Node rotationRR(Node node){
//        Node temp = node.getRight();
//        node.setRight(temp.getLeft());
//        temp.setLeft(node);
//        return temp;
//    }
//    // rotationLR is used to rotate a node to the left then to the right
//    private Node rotationLR(Node node){
//        Node temp = node.getLeft();
//        node.setLeft(rotationRR(temp));
//        return rotationLL(node);
//    }
//
//    // rotationRL is used to rotate a node to the right then to the left
//    private Node rotationRL(Node node){
//        Node temp = node.getRight();
//        node.setRight(rotationLL(temp));
//        return rotationRR(node);
//    }
//
//    //Inserting a node in an AVL tree works the same way as in BST.
//    // The only difference is that after inserting a node, we need to
//    // check if the tree is balanced. If it is not, we need to balance it.
//    // this function will insert a node into the AVL tree
//
////    public void insert(int key){ // MAY NOT NEED AS IT IS IN LINE 8
////        root = insertNode(root, key); // note expecting 3 but got 2 so in line reference ORGIGINAL CODE {2}
////    }
//
//    // insertNode for an AVL tree use the existing insert function from the BST
//    // then check the balance of the tree and rotate if needed
//    private Node insertNodeAVL(Node node, int key){
//        if (node == null){
//            return new Node(key);
//        }
//        if (myComparator.compare(key, node.getKey()) < 0){
//            node.setLeft(insertNodeAVL(node.getLeft(), key));
//        } else if (myComparator.compare(key, node.getKey()) > 0){
//            node.setRight(insertNodeAVL(node.getRight(), key));
//        } else {
//            return node;
//        }
//        int balance = balance(node);
//        if (balance == unbalancedLeft){
//            if (myComparator.compare(key, node.getLeft().getKey()) < 0){
//                node = rotationLL(node);
//            } else {
//                node = rotationLR(node);
//            }
//        }
//        if (balance == unbalancedRight){
//            if (myComparator.compare(key, node.getRight().getKey()) > 0){
//                node = rotationRR(node);
//            } else {
//                node = rotationRL(node);
//            }
//        }
//        return node;
//    }
//
//    // this function will remove a node from the AVL tree use the existing remove function from the BST
//    // making sure all possible cases are covered unbalanced left, unbalanced right, slightly unbalanced left, slightly unbalanced right, balanced
//    // then check the balance of the tree and rotate if needed
//    private Node removeNodeAVL(Node node, int key){
//        // node = removeNode(node, key); is the original code from the BST
//        node = removeNode(node, key);
//        if (node == null){
//            return null;
//        }
//        if (myComparator.compare(key, node.getKey()) < 0){
//            node.setLeft(removeNodeAVL(node.getLeft(), key));
//        } else if (myComparator.compare(key, node.getKey()) > 0){
//            node.setRight(removeNodeAVL(node.getRight(), key));
//        } else {
//            if (node.getLeft() == null || node.getRight() == null){
//                Node temp = null;
//                if (temp == node.getLeft()){
//                    temp = node.getRight();
//                } else {
//                    temp = node.getLeft();
//                }
//                if (temp == null){
//                    temp = node;
//                    node = null;
//                } else {
//                    node = temp;
//                }
//            } else {
//                Node temp = minNode(node.getRight());
//                node.setKey(temp.getKey());
//                node.setRight(removeNodeAVL(node.getRight(), temp.getKey()));
//            }
//        }
//        if (node == null){
//            return node;
//        }
//        int balance = balance(node);
//        if (balance == unbalancedLeft){
//            if (balance(node.getLeft()) == balanced || balance(node.getLeft()) == slightlyUnbalancedLeft){
//                return rotationLL(node);
//            }
//            if (balance(node.getLeft()) == slightlyUnbalancedRight){
//                return rotationLR(node);
//            }
//        }
//        if (balance == unbalancedRight){
//            if (balance(node.getRight()) == balanced || balance(node.getRight()) == slightlyUnbalancedRight){
//                return rotationRR(node);
//            }
//            if (balance(node.getRight()) == slightlyUnbalancedLeft){
//                return rotationRL(node);
//            }
//        }
//        return node;
//    }
//
//
//
//    public String toString(){
//        return "Original BST: " + toStringBST(root) + "\n" + "BST: " + toStringBST(root) + "\n" + "AVL: " + toStringAVL(root);
//    }
////    private String toString(Node node) {
////        if (node == null) {
////            return "";
////        }
////        return toString(node.getLeft()) + node.getKey() + " " + toString(node.getRight());
////    }
//
//    private String toStringBST(Node node) {
//        if (node == null) {
//            return "";
//        }
//        return toStringBST(node.getLeft()) + node.getKey() + " " + toStringBST(node.getRight());
//    }
//
//    private String toStringAVL(Node node) {
//        if (node == null) {
//            return "";
//        }
//        return toStringAVL(node.getLeft()) + node.getKey() + " " + toStringAVL(node.getRight());
//    }
//}
