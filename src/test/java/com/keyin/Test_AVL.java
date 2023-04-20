package com.keyin;

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
