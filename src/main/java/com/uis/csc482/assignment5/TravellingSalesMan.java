package com.uis.csc482.assignment5;

import com.uis.csc482.module4.Edge;
import com.uis.csc482.module4.GraphLanguage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class TravellingSalesMan {

    private static Map<String, List<Edge>> stringListMap = new LinkedHashMap<>();

    private static int min = Integer.MAX_VALUE;


    private static List<String> visitedPathList = new ArrayList<>();

    public static void main(String args[]) throws IOException {

        String inputFileName = "/src/main/java/com/uis/csc482/assignment5/t4.gl";

        GraphLanguage graphLanguage = new GraphLanguage();

        stringListMap = graphLanguage.processFile(inputFileName);

        findMinimum(stringListMap);

        System.out.println(min);

        sendOutputToFile(min, "/Users/harshitkapoor/IdeaProjects/Java/src/main/java/com/uis/csc482/assignment5/minimumWeight.txt");

        visitedPathList.remove(0);

        sendVertexPathOutputToFile(visitedPathList);

    }

    /**
     * This method finds the minimum weight, and the path for a given cycle
     * @param stringListMap - The map of different connected vertices
     */
    public static void findMinimum(Map<String, List<Edge>> stringListMap) {

        int counter = 0;

        int sum = 0;

        List<String> visitedNodeList = new ArrayList<>();

        for (String v : stringListMap.keySet()) {
            for (int i = 0; i < stringListMap.get(v).size(); i++) {

                visitedPathList.remove(stringListMap.entrySet().stream().findFirst().get().getKey() + stringListMap.get(v).get(i).getDestination());

                visitedPathList.remove(stringListMap.get(v).get(i).getDestination() + stringListMap.entrySet().stream().findFirst().get().getKey());

                if (i != 1) {

                    visitedPathList.remove(stringListMap.get(v).get(i).getDestination() + v);

                    visitedPathList.remove(v + stringListMap.get(v).get(i).getDestination());

                }
            }

        }

        String v = stringListMap.entrySet().stream().findFirst().get().getKey();

        for (int i = 0; i < stringListMap.size(); i++) {
            for (int j = 0; j < stringListMap.size(); j++) {

                if (counter == stringListMap.size() - 1) {

                    visitedNodeList.remove(stringListMap.entrySet().stream().findFirst().get().getKey());

                }

                if ((!visitedPathList.contains(v + stringListMap.get(v).get(j).getDestination()) && !visitedPathList.contains(stringListMap.get(v).get(j).getDestination() + v)) && !visitedNodeList.contains(v) && !visitedNodeList.contains(stringListMap.get(v).get(j).getDestination())) {
                    sum = sum + (int) stringListMap.get(v).get(j).getWeight();
                    visitedPathList.add(v + stringListMap.get(v).get(j).getDestination());
                    visitedNodeList.add(v);
                    counter++;
                    v = stringListMap.get(v).get(j).getDestination();
                    break;

                }
            }
        }

        if (sum < min) {
            min = sum;
            findMinimum(stringListMap);
        }
    }

    private static void sendOutputToFile(int message, String fileName) throws IOException{

        File file = new File(fileName);

        FileWriter fileWriter = new FileWriter(file);

        //BufferedWriter writer = new BufferedWriter(fileWriter);

        fileWriter.write(String.valueOf(message));

        fileWriter.close();

    }

    private static void sendVertexPathOutputToFile(List<String> visitedPathList) throws IOException{

        File file = new File("/Users/harshitkapoor/IdeaProjects/Java/src/main/java/com/uis/csc482/assignment5/vertexPath.txt");

        FileWriter fileWriter = new FileWriter(file);

        for (int i=0;i<visitedPathList.size();i++) {
            String str = visitedPathList.get(i).toString();
            fileWriter.write(str);
            if(i < visitedPathList.size()-1)
                fileWriter.write("\n");
        }

        fileWriter.close();

    }
}
