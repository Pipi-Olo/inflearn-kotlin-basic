package com.pipiolo.lec07;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class JavaFilePrinter {

    // try with resources
    public void readFile(String path) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            System.out.println(reader.readLine());
        }
    }

}
