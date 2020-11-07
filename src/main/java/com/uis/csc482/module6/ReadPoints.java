package com.uis.csc482.module6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadPoints {

    public List<Points> processFile() {

        String fileName = "/src/main/java/com/uis/csc482/module6/points.txt";

        String filePath = new File("").getAbsolutePath();

        BufferedReader reader;

        List<Points> points = new ArrayList<>();

        String[] pair = null;

        try {

            reader = new BufferedReader(new FileReader(filePath + fileName));
            String line = reader.readLine();

            while (line != null) {
                pair = line.split(" "); //-- splitting the values with '='
                points.add(new Points(Integer.parseInt(pair[0]), Integer.parseInt(pair[1])));
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Error while processing file" + e.getMessage());
        }
        return points;
    }
}
