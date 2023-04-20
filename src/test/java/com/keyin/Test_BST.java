package com.keyin;

/*
 * Project: Final Sprint Project 2 - BST/AVL Tree
 * Course Name: Software Development
 * Written by: David Turner
 * Due Date: April 21, 2023
 */

import com.keyin.bst_avl_trees.BST;
import org.junit.jupiter.api.Assertions;
import org.junit.Test;
public class Test_BST {

    // test the bst constructor first
    @Test
    public void testBSTConstructor() {
        BST bst = new BST();
        Assertions.assertEquals(null, bst.root);
        System.out.println("Test 1 Constructor: No Arguments");
        // this will have a statement that says what was expected and what it actually got
        System.out.println("\tExpected: null" + "; Actual: " + bst.root);
    }

    // test the insert function
    @Test
    public void testInsert() {
        BST bst = new BST();
        bst.insert(1);
        bst.insert(2);
        bst.insert(3);
        bst.insert(4);
        bst.insert(5);
        Assertions.assertEquals(1, bst.root.getKey());
        Assertions.assertEquals(2, bst.root.getRight().getKey());
        Assertions.assertEquals(3, bst.root.getRight().getRight().getKey());
        Assertions.assertEquals(4, bst.root.getRight().getRight().getRight().getKey());
        Assertions.assertEquals(5, bst.root.getRight().getRight().getRight().getRight().getKey());
        System.out.println("Test 2 Insert: Insert 5 nodes");
        System.out.println("\tExpected: 1, 2, 3, 4, 5" + "; Actual: " + bst.root.getKey() + ", " + bst.root.getRight().getKey() + ", " + bst.root.getRight().getRight().getKey() + ", " + bst.root.getRight().getRight().getRight().getKey() + ", " + bst.root.getRight().getRight().getRight().getRight().getKey());
    }

    @Test
    // test #2 using inserted values of 5 8 6 4 1
    public void testInsert2() {
        BST bst = new BST();
        bst.insert(5);
        bst.insert(8);
        bst.insert(6);
        bst.insert(4);
        bst.insert(1);
        Assertions.assertEquals(5, bst.root.getKey());
        Assertions.assertEquals(8, bst.root.getRight().getKey());
        Assertions.assertEquals(6, bst.root.getRight().getLeft().getKey());
        Assertions.assertEquals(4, bst.root.getLeft().getKey());
        Assertions.assertEquals(1, bst.root.getLeft().getLeft().getKey());
        System.out.println("Test 3 Insert: Insert 5 nodes");
        System.out.println("\tExpected: 5, 8, 6, 4, 1" + "; Actual: " + bst.root.getKey() + ", " + bst.root.getRight().getKey() + ", " + bst.root.getRight().getLeft().getKey() + ", " + bst.root.getLeft().getKey() + ", " + bst.root.getLeft().getLeft().getKey());
    }

    @Test
    // test #3 check max node value with values 1 2 3
    public void testMax() {
        BST bst = new BST();
        bst.insert(1);
        bst.insert(2);
        bst.insert(3);
        Assertions.assertEquals(3, bst.max().getKey());
        System.out.println("Test 4 Max: Insert 3 nodes");
        System.out.println("\tExpected: 3" + "; Actual: " + bst.max().getKey());
    }
}
