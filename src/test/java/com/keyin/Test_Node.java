package com.keyin;

import com.keyin.bst_avl_trees.Node;
import org.junit.jupiter.api.Assertions;
import org.junit.Test;

import java.sql.SQLOutput;

public class Test_Node {

    // This will test all the constructors of the Node class
    @Test
    public void testNodeConstructors() {
        // this will test the constructor that takes in no arguments
        Node node = new Node();
        Assertions.assertEquals(0, node.getKey());
        Assertions.assertEquals(null, node.getLeft());
        Assertions.assertEquals(null, node.getRight());
        System.out.println("Test 1 Constructor: No Arguments");
        // this will have a statement that says what was expected and what it actually got
        System.out.println("\tExpected: 0" + "; Actual: " + node.getKey());

        // this will test the constructor that takes in only the key
        // and sets the left and right children to null
        Node node2 = new Node(55);
        Assertions.assertEquals(55, node2.getKey());
        Assertions.assertEquals(null, node2.getLeft());
        Assertions.assertEquals(null, node2.getRight());
        System.out.println("Test 2 Constructor: Only Key Argument");
        // this will have a statement that says what was expected and what it actually got
        System.out.println("\tExpected: 55" + "; Actual: " + node2.getKey());
        System.out.println("\tExpected: null" + "; Actual: " + node2.getLeft());
        System.out.println("\tExpected: null" + "; Actual: " + node2.getRight());

        // this will test the constructor that takes in all arguments
        Node node3 = new Node(55, new Node(56), new Node(57), 12);
        Assertions.assertEquals(55, node3.getKey());
        Assertions.assertEquals(56, node3.getLeft().getKey());
        Assertions.assertEquals(57, node3.getRight().getKey());
        System.out.println("Test 3 Constructor: All Arguments");
        // this will have a statement that says what was expected and what it actually got
        System.out.println("\tExpected: 55" + "; Actual: " + node3.getKey());
        System.out.println("\tExpected: 56" + "; Actual: " + node3.getLeft().getKey());
        System.out.println("\tExpected: 57" + "; Actual: " + node3.getRight().getKey());
    }
}
