package com.keyin;

/*
 * Project: Final Sprint Project 2 - BST/AVL Tree
 * Course Name: Software Development
 * Written by: David Turner
 * Due Date: April 21, 2023
 */

import com.keyin.bst_avl_trees.Node;
import org.junit.jupiter.api.Assertions;
import org.junit.Test;

import java.sql.SQLOutput;

public class Test_Node {
    // This will test all the constructors of the Node class
    @Test
    public void testNoArgConstructors() {
        // this will test the constructor that takes in no arguments
        Node node = new Node();
        Assertions.assertEquals(0, node.getKey());
        Assertions.assertNull(node.getLeft());
        Assertions.assertNull(node.getRight());
        System.out.println("Test 1 Constructor: No Arguments");
        // this will have a statement that says what was expected and what it actually got
        System.out.println("\tExpected: 0" + "; Actual: " + node.getKey());
    }
    @Test
    public void testOneArgConstructor() {
        // this will test the constructor that takes in only the key
        // and sets the left and right children to null
        Node node = new Node(55);
        Assertions.assertEquals(55, node.getKey());
        Assertions.assertNull(node.getLeft());
        Assertions.assertNull(node.getRight());
        System.out.println("Test 2 Constructor: Only Key Argument");
        // this will have a statement that says what was expected and what it actually got
        System.out.println("\tExpected: 55" + "; Actual: " + node.getKey());
        System.out.println("\tExpected: null" + "; Actual: " + node.getLeft());
        System.out.println("\tExpected: null" + "; Actual: " + node.getRight());
    }
    @Test
    public void testAllArgConstructor(){
        // this will test the constructor that takes in all arguments
        Node node = new Node(55, new Node(56), new Node(57), 12);
        Assertions.assertEquals(55, node.getKey());
        Assertions.assertEquals(56, node.getLeft().getKey());
        Assertions.assertEquals(57, node.getRight().getKey());
        System.out.println("Test 3 Constructor: All Arguments");
        // this will have a statement that says what was expected and what it actually got
        System.out.println("\tExpected: 55" + "; Actual: " + node.getKey());
        System.out.println("\tExpected: 56" + "; Actual: " + node.getLeft().getKey());
        System.out.println("\tExpected: 57" + "; Actual: " + node.getRight().getKey());
    }
}
