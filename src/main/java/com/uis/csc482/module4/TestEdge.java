package com.uis.csc482.module4;

import sun.lwawt.macosx.CSystemTray;

import java.util.ArrayList;

public class TestEdge {

    public static void main(String[] args) {
        ArrayList<String> vertices = new ArrayList<>();
        vertices.add("A");
        vertices.add("B");
        vertices.add("C");
        vertices.add("D");
        vertices.add("E");
        vertices.add("F");
        vertices.add("G");

        System.out.println("*********************** Testing addEdge() without weight - start ************************");

        Graph graph = new Graph(vertices);
        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.addEdge("B", "D");
        graph.addEdge("B", "E");
        graph.addEdge("C", "D");
        graph.addEdge("D", "E");
        graph.addEdge("G", "E");
        graph.addEdge("A", "G");
        graph.printGraph();

        System.out.println("*********************** Testing addEdge() without weight - end ***************************");

        System.out.println("-----------------------------------------------------------------------------------------");

        System.out.println("************************ Testing addEdge() with weight - start **************************");

        Graph graph1 = new Graph(vertices);

        graph1.addEdge("A", "B", 20);
        graph1.addEdge("A", "C", 34);
        graph1.addEdge("B", "D", 2);
        graph1.addEdge("B", "E", 56);
        graph1.addEdge("C", "D", 44);
        graph1.addEdge("D", "E", 56);
        graph1.addEdge("G", "E", 12);
        graph1.addEdge("A", "G", 13);
        graph1.printGraph();
        System.out.println("************************ Testing addEdge() with weight - end ****************************");

        System.out.println("-----------------------------------------------------------------------------------------");


        System.out.println("**************************** Testing addVertex() - start ********************************");
        Graph graph2 = new Graph(vertices);

        graph2.addEdge("A", "B", 20);
        graph2.addEdge("A", "C", 34);
        graph2.addEdge("B", "D", 2);
        graph2.addEdge("B", "E", 56);
        graph2.addEdge("C", "D", 44);
        graph2.addEdge("D", "E", 56);
        graph2.addEdge("G", "E", 12);
        graph2.addEdge("A", "G", 13);

        graph2.addVertex("A");
        graph2.addVertex("H");
        graph2.printGraph();

        System.out.println("**************************** Testing addVertex() - end **********************************");

        System.out.println("-----------------------------------------------------------------------------------------");

        System.out.println("**************************** Testing getVertices() - start ******************************");
        Graph graph3 = new Graph(vertices);

        graph3.addEdge("A", "B", 20);
        graph3.addEdge("A", "C", 34);
        graph3.addEdge("B", "D", 2);
        graph3.addEdge("B", "E", 56);
        graph3.addEdge("C", "D", 44);
        graph3.addEdge("D", "E", 56);
        graph3.addEdge("G", "E", 12);
        graph3.addEdge("A", "G", 13);

        graph3.getVertices().forEach(obj -> {
            System.out.println(obj);
        });

        System.out.println("**************************** Testing getVertices() - end ********************************");

        System.out.println("-----------------------------------------------------------------------------------------");

        System.out.println("**************************** Testing getEdges() - start ******************************");
        Graph graph4 = new Graph(vertices);

        graph4.addEdge("A", "B", 20);
        graph4.addEdge("A", "C", 34);
        graph4.addEdge("B", "D", 2);
        graph4.addEdge("B", "E", 56);
        graph4.addEdge("C", "D", 44);
        graph4.addEdge("D", "E", 56);
        graph4.addEdge("G", "E", 12);
        graph4.addEdge("A", "G", 13);

        graph4.getEdges("A").forEach(obj ->{
            System.out.println(obj.destination +","+obj.weight);
                }
                );

        System.out.println("**************************** Testing getEdges() - end ********************************");


    }
}
