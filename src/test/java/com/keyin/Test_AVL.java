package com.keyin;

/*
 * Project: Final Sprint Project 2 - BST/AVL Tree
 * Course Name: Software Development
 * Written by: David Turner
 * Due Date: April 21, 2023
 */

import com.keyin.bst_avl_trees.AVL;
import org.junit.jupiter.api.Assertions;
import org.junit.Test;

public class Test_AVL {

    @Test
    public void testAVLConstructor() {
        AVL avl = new AVL();
        Assertions.assertEquals(null, avl.root);
        System.out.println("Test 1 Constructor: No Arguments");
        System.out.println("\tExpected: null" + "; Actual: " + avl.root);
    }

    @Test
    public void testInsert() {
        // insert 1 2 3 through avl
        AVL avl = new AVL();
        avl.insert(1);
        avl.insert(2);
        avl.insert(3);
        // this assertion is for insert() method
        Assertions.assertEquals(2, avl.root.getKey());
        Assertions.assertEquals(1, avl.root.getLeft().getKey());
        Assertions.assertEquals(3, avl.root.getRight().getKey());
        System.out.println("Test 2 Insert: Insert 3 nodes");
        System.out.println("\tExpected: 2, 1, 3" + "; Actual: " + avl.root.getKey() + ", " + avl.root.getLeft().getKey() + ", " + avl.root.getRight().getKey());
    }

    @Test
    // this will test getJsonRepresentation() method in AVL.java
    public void testGetJsonRepresentation() {
        AVL avl = new AVL();
        avl.insert(5);
        avl.insert(8);
        avl.insert(6);
        avl.insert(4);
        avl.insert(1);
        avl.getJSONRepresentation(avl.root);
        // this assertion is for getJSONRepresentation() method
        Assertions.assertEquals("{\n" +
                "  \"key\": 6,\n" +
                "  \"left\": {\n" +
                "    \"key\": 4,\n" +
                "    \"left\": {\n" +
                "      \"key\": 1\n" +
                "    },\n" +
                "    \"right\": {\n" +
                "      \"key\": 5\n" +
                "    }\n" +
                "  },\n" +
                "  \"right\": {\n" +
                "    \"key\": 8\n" +
                "  }\n" +
                "}", avl.getJSONRepresentation(avl.root));
        System.out.println("Test 3 getJSONRepresentation: Insert 5 nodes");
        System.out.println("\tExpected: {\"key\": 6,\"left\": {\"key\": 4,\"left\": " +
                "{\"key\": 1},\"right\": {\"key\": 5}},\"right\": {\"key\": 8}}" + "; Actual: " + avl.getJSONRepresentation(avl.root));
    }



}
