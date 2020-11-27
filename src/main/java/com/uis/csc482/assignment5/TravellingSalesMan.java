package com.uis.csc482.assignment5;

import com.uis.csc482.module4.Edge;
import com.uis.csc482.module4.GraphLanguage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TravellingSalesMan {

    private static int [][] adjacencyMatrix;

    public static void main (String args[]) throws IOException {

        String inputFileName = "/src/main/java/com/uis/csc482/assignment5/t4.gl";

        GraphLanguage graphLanguage = new GraphLanguage();
        Map<String, List<Edge>> stringListMap =  graphLanguage.processFile(inputFileName);

        adjacencyMatrix = new int[stringListMap.size()][stringListMap.size()];

        for (String v : stringListMap.keySet()) {

            for (int i = 0; i < stringListMap.get(v).size(); i++) {

                populateAdjacencyMatrix(v, stringListMap.get(v).get(i).getDestination(), (int) stringListMap.get(v).get(i).getWeight());
            }
        }
        //findMinimumCycle();

        findMinimum(stringListMap);
    }

    public static void populateAdjacencyMatrix(String to, String from, int weight){
        try{
             int t = 0;
             int f = 0;

             if( to.equalsIgnoreCase("A")){
                 t = 0;
             } else if(to.equalsIgnoreCase("B")){
                 t = 1;
             } else if(to.equalsIgnoreCase("C")){
                 t = 2;
             }else if(to.equalsIgnoreCase("D")) {
                 t = 3;
             }else{
                 t = 4;
             }

            if( from.equalsIgnoreCase("A")){
                f = 0;
            } else if(from.equalsIgnoreCase("B")){
                f = 1;
            } else if(from.equalsIgnoreCase("C")){
                f = 2;
            } else if(from.equalsIgnoreCase("D")){
                f = 3;
            } else{
                f = 4;
            }

            adjacencyMatrix[t][f] = weight;
        } catch (ArrayIndexOutOfBoundsException ex){
            System.out.print("The vertices do not exist");
        }
    }

    public static void findMinimumCycle(){
        int minimumPathWeightSum = 0;
        int counter = 0;
        int j = 0, i = 0;
        int minimumWeight = Integer.MAX_VALUE;

        List<Integer> visitedNodeList = new ArrayList<>();

        // Starting from the first node and marking it as visited
        visitedNodeList.add(0);

        // This array stores the route taken in the cycle
        int[] routeTaken = new int[adjacencyMatrix.length];

        // Traverse the adjacency matrix to find the minimum path
        while (i < adjacencyMatrix.length && j < adjacencyMatrix[i].length) {

            // Breaking out of the loop if the value of counter goes beyond the length of matrix
            if (counter >= adjacencyMatrix[i].length - 1) {
                break;
            }

            // Checking the path to be unvisited and weight is minimum
            if (j != i && !(visitedNodeList.contains(j))) {
                if (adjacencyMatrix[i][j] < minimumWeight) {
                    minimumWeight = adjacencyMatrix[i][j];
                    routeTaken[counter] = j + 1;
                }
            }
            j++;

            // Check all paths from the ith indexed node
            if (j == adjacencyMatrix[i].length) {
                minimumPathWeightSum += minimumWeight;
                minimumWeight = Integer.MAX_VALUE;
                visitedNodeList.add(routeTaken[counter] - 1);
                j = 0;
                i = routeTaken[counter] - 1;
                counter++;
            }
        }

        // Update the ending node in the array that was last visited
        i = routeTaken[counter - 1] - 1;

        for (j = 0; j < adjacencyMatrix.length; j++) {
            if ((i != j) && adjacencyMatrix[i][j] < minimumWeight) {
                minimumWeight = adjacencyMatrix[i][j];
                routeTaken[counter] = j + 1;
            }
        }
        minimumPathWeightSum += minimumWeight;

        System.out.print("Minimum Cost is : ");
        System.out.println(minimumPathWeightSum);

        for (int k =0; k<routeTaken.length; k++) {

            if(k==0) {
                System.out.print("[ " + routeTaken[k] + ", ");
            }

            else if(k == routeTaken.length-1){
                System.out.print(routeTaken[k] + " ]");
            }
            else{
                System.out.print(routeTaken[k] + ", ");
            }

        }

    }


    public static void findMinimum(Map<String, List<Edge>> stringListMap){

        int sum = 0;

        int counter = 0;

        List<String> visitedNodeList = new ArrayList<>();

        for (String v : stringListMap.keySet()) {

            if(counter == stringListMap.size() -1){

                visitedNodeList.remove(stringListMap.entrySet().stream().findFirst().get().getKey());

            }

            for (int i = 0; i < stringListMap.get(v).size(); i++) {

                if(!visitedNodeList.contains(stringListMap.get(v).get(i).getDestination()) && !visitedNodeList.contains(v)) {
                    sum = sum + (int) stringListMap.get(v).get(i).getWeight();
                    visitedNodeList.add(v);
                    counter++;
                }


            }
        }

       System.out.print(sum);
    }
}
