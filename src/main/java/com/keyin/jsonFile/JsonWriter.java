package com.keyin.jsonFile;

/*
 * Project: Final Sprint Project 2 - BST/AVL Tree
 * Course Name: Software Development
 * Written by: David Turner
 * Due Date: April 21, 2023
 */

import java.io.FileWriter;
import java.io.IOException;

public class JsonWriter {
    // this will be accessed from CLI.java
    public void writeJson (String fileName, String json) {
        try (FileWriter file = new FileWriter(fileName, true)) {
            file.write(json + "\n" + "-------------------" + "\n");
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
