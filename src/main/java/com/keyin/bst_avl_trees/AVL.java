package com.keyin.bst_avl_trees;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.simple.JSONObject;
import java.sql.SQLOutput;

public class AVL extends BST {
    private static final int unbalancedRight = -2;
    private static final int slightlyUnbalancedRight = -1;
    private static final int balanced = 2;
    private static final int slightlyUnbalancedLeft = 1;
    private static final int unbalancedLeft = 0;

    // constructor for AVL tree
    public AVL(){
        super();
    }

    // get the root from the BST
    public Node getRoot(){
        return root;
    }

    // need to compare the height of the left and right side of the tree
    // if the height of the left side is greater than the right side then it is unbalanced to the left
    // if the height of the right side is greater than the left side then it is unbalanced to the right
    // if the height of the left and right side are equal then it is balanced
    // if the height of the left side is greater than the right side by 1 then it is slightly unbalanced to the left
    // if the height of the right side is greater than the left side by 1 then it is slightly unbalanced to the right
    private int balance(Node node){
        if (node == null){
            return 0;
        }
        int leftHeight = height(node.getLeft());
        int rightHeight = height(node.getRight());
        if (leftHeight > rightHeight + 1){
            return unbalancedLeft;
        }
        if (leftHeight + 1 < rightHeight){
            return unbalancedRight;
        }
        if (leftHeight > rightHeight){
            return slightlyUnbalancedLeft;
        }
        if (leftHeight < rightHeight){
            return slightlyUnbalancedRight;
        }
        return balanced;
    }

    // need a height function to determine the height of the tree and return the height in the console
    private int height(Node node){
        if (node == null){
            return 0;
        }
        int leftHeight = height(node.getLeft());
        int rightHeight = height(node.getRight());
        if (leftHeight > rightHeight){
            return leftHeight + 1;
        }
        return rightHeight + 1;
    }

    // this is a getBalanceFactor function that will return the balance factor of the tree
    public int getBalanceFactor(){
        return balance(root);
    }

    // rotationLL is used to rotate a node to the left
    private Node rotationLL(Node node){
        Node temp = node.getLeft();
        node.setLeft(temp.getRight());
        temp.setRight(node);
        return temp;
    }
    // rotationRR is used to rotate a node to the right
    private Node rotationRR(Node node){
        Node temp = node.getRight();
        node.setRight(temp.getLeft());
        temp.setLeft(node);
        return temp;
    }
    // rotationLR is used to rotate a node to the left then to the right
    private Node rotationLR(Node node){
        Node temp = node.getLeft();
        node.setLeft(rotationRR(temp));
        return rotationLL(node);
    }

    // rotationRL is used to rotate a node to the right then to the left
    private Node rotationRL(Node node){
        Node temp = node.getRight();
        node.setRight(rotationLL(temp));
        return rotationRR(node);
    }

    //Inserting a node in an AVL tree works the same way as in BST.
    // The only difference is that after inserting a node, we need to
    // check if the tree is balanced. If it is not, we need to balance it.
    // this function will insert a node into the AVL tree

    // insertNode for an AVL tree use the existing insert function from the BST
    // then check the balance of the tree and rotate if needed
    private Node insertNodeAVL(Node node, int key){
        if (node == null){
            return new Node(key);
        }
        if (myComparator.compare(key, node.getKey()) < 0){
            node.setLeft(insertNodeAVL(node.getLeft(), key));
        } else if (myComparator.compare(key, node.getKey()) > 0){
            node.setRight(insertNodeAVL(node.getRight(), key));
        } else {
            return node;
        }
        int balance = balance(node);
        if (balance == unbalancedLeft){
            if (myComparator.compare(key, node.getLeft().getKey()) < 0){
                node = rotationLL(node);
            } else {
                node = rotationLR(node);
            }
        }
        if (balance == unbalancedRight){
            if (myComparator.compare(key, node.getRight().getKey()) > 0){
                node = rotationRR(node);
            } else {
                node = rotationRL(node);
            }
        }
        return node;
    }

    // ADDED ON April 14, 2023 @ 11pm, possibly not needed???
    public void insert(int key){
        root = insertNodeAVL(root, key);
    }

    // this function will remove a node from the AVL tree use the existing remove function from the BST
    // making sure all possible cases are covered unbalanced left, unbalanced right, slightly unbalanced left, slightly unbalanced right, balanced
    // then check the balance of the tree and rotate if needed
    private Node removeNodeAVL(Node node, int key){
        node = removeNode(node, key);
        if (node == null){
            return null;
        }
        if (myComparator.compare(key, node.getKey()) < 0){
            node.setLeft(removeNodeAVL(node.getLeft(), key));
        } else if (myComparator.compare(key, node.getKey()) > 0){
            node.setRight(removeNodeAVL(node.getRight(), key));
        } else {
            if (node.getLeft() == null || node.getRight() == null){
                Node temp = null;
                if (temp == node.getLeft()){
                    temp = node.getRight();
                } else {
                    temp = node.getLeft();
                }
                if (temp == null){
                    temp = node;
                    node = null;
                } else {
                    node = temp;
                }
            } else {
                Node temp = minNode(node.getRight());
                node.setKey(temp.getKey());
                node.setRight(removeNodeAVL(node.getRight(), temp.getKey()));
            }
        }
        if (node == null){
            return node;
        }
        int balance = balance(node);
        if (balance == unbalancedLeft){
            if (balance(node.getLeft()) == balanced || balance(node.getLeft()) == slightlyUnbalancedLeft){
                return rotationLL(node);
            }
            if (balance(node.getLeft()) == slightlyUnbalancedRight){
                return rotationLR(node);
            }
        }
        if (balance == unbalancedRight){
            if (balance(node.getRight()) == balanced || balance(node.getRight()) == slightlyUnbalancedRight){
                return rotationRR(node);
            }
            if (balance(node.getRight()) == slightlyUnbalancedLeft){
                return rotationRL(node);
            }
        }
        return node;
    }

    public String getJSONRepresentation() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        Gson gson = gsonBuilder.create();
        return gson.toJson(this.root);
    }
}
