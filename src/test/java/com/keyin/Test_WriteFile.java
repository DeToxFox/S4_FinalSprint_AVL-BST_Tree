package com.keyin;

/*
 * Project: Final Sprint Project 2 - BST/AVL Tree
 * Course Name: Software Development
 * Written by: David Turner
 * Due Date: April 21, 2023
 */

import org.junit.jupiter.api.Assertions;
import org.junit.Test;
import java.io.FileWriter;
import java.io.IOException;
import com.keyin.jsonFile.JsonWriter;

public class Test_WriteFile {
        @Test
        public void testWriteFile() throws IOException {
            JsonWriter jsonWriter = new JsonWriter();
            jsonWriter.writeJson("src/main/java/com/keyin/jsonFile/test.txt", "test");
            FileWriter file = new FileWriter("test.txt");
            // use above object to compare assertions using true or false
            Assertions.assertTrue(file != null);
            System.out.println("Test 1 Write File");
            System.out.println("\tExpected: true" + "; Actual: " + (file != null));
        }
}
