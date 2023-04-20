package com.keyin.cli;

import com.keyin.bst_avl_trees.AVL;
import java.util.Scanner;
import com.keyin.bst_avl_trees.BST;
import com.keyin.jsonFile.JsonWriter;
import org.json.JSONObject;


public class CLI {
    public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      AVL avl_trees = new AVL();
      BST bst_trees = new BST();

      // input the number of nodes
        System.out.print("Enter the number of nodes separated by spaces (minimum of 5 total numbers): ");
        String input = scanner.nextLine();

        // split the input into an array of strings
        String[] inputArray = input.split(" ");
        // for loop to take inputArray and run it through the AVL class
        for (int i = 0; i < inputArray.length; i++) {
            avl_trees.insert(Integer.parseInt(inputArray[i]));
        }

        // for loop to take inputArray and run it through the BST.java class
        for (int i = 0; i < inputArray.length; i++) {
            bst_trees.insert(Integer.parseInt(inputArray[i]));
        }

        String json1 = avl_trees.getJSONRepresentation();
        System.out.println("AVL " + json1);
        String json2 = bst_trees.getJSONRepresentation();
        System.out.println("BST " + json2);

        // write the json to a file by calling the jsonWriter.java class
        JsonWriter jsonWriter = new JsonWriter();
        jsonWriter.writeJson("src/main/java/com/keyin/jsonFile/input.json", input);
        jsonWriter.writeJson("src/main/java/com/keyin/jsonFile/avl.json", json1);
        jsonWriter.writeJson("src/main/java/com/keyin/jsonFile/bst.json", json2);

    }
}