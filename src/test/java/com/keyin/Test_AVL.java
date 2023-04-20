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


}
