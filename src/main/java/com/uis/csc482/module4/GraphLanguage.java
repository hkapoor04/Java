package com.uis.csc482.module4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraphLanguage {

    /**
     * This method reads the file and processes it
     * @param fileName - The name of the file
     * @throws IOException
     */
    public void  processFile(String fileName) throws IOException {

        String filePath = new File("").getAbsolutePath();

        BufferedReader reader;

        List<String> vertices = new ArrayList<>();

        Map<Integer, String[]> nodeValueMap = new HashMap<>();

        String[] pair = null;

        int index = 0;

        try {
            reader = new BufferedReader(new FileReader(filePath + fileName));
            String header = reader.readLine();
            String line = reader.readLine();

            while (line != null) {
                pair = line.split("="); //-- splitting the values with '='
                vertices.add(pair[0]);
                nodeValueMap.put(index, pair);
                line = reader.readLine();
                index++;
            }

            Graph graph = new Graph(vertices);

            //-- For each entry of the map, calling method to populate the graph
            for (Map.Entry<Integer, String[]> entry : nodeValueMap.entrySet()) {
                if (header != null && header.equalsIgnoreCase("directed weighted")) {
                    graph.addEdge(entry.getValue()[0], entry.getValue()[1], Integer.parseInt(entry.getValue()[2]));
                } else if (header != null && header.equalsIgnoreCase("directed unweighted")){
                    graph.addEdge(entry.getValue()[0], entry.getValue()[1]);
                } else{
                    System.out.println("Invalid File");
                    break;
                }
            }

            graph.printGraph();

            reader.close();
        } catch (IOException e) {
            System.out.println("Error while processing file" + e.getMessage());
        }

    }


}
