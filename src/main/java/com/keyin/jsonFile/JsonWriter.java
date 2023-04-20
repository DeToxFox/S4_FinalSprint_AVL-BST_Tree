package com.keyin.jsonFile;

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
