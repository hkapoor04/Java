package com.uis.csc482.module4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Edge {

    String destination;
    String weight;

    Edge(String destination, String weight) {
        this.destination = destination;
        this.weight = weight;
    }

    Edge(String destination) {
        this.destination = destination;
    }
}

class Graph {
    private Map<String, List<Edge>> adjListMap = new HashMap<>();

    HashMap<Object, Integer> indexes = new HashMap<>();

    int index = -1;

    public Graph(List<String> vertices) {
        for (int i = 0; i < vertices.size(); i++) {
            String vertex = vertices.get(i);
            List<Edge> adjList = new ArrayList<>();
            adjListMap.put(vertex, adjList);
            indexes.put(vertex, ++index);
        }
    }

    /**
     * This method adds the destination edge to source edge
     *
     * @param source      the source edge where destination edge is added
     * @param destination the edge added to the source
     */
    public void addEdge(String source, String destination, boolean biDirectional) {

        List<Edge> list = adjListMap.get(source);
        Edge edge = new Edge(destination);
        list.add(edge);
        adjListMap.put(source, list);

        if (biDirectional) {
            List<Edge> listDestination = adjListMap.get(destination);
            Edge edgeDestination = new Edge(source);
            listDestination.add(edgeDestination);
            adjListMap.put(destination, listDestination);
        }
    }


    /**
     * This method adds the destination edge to source edge
     *
     * @param source      the source edge where destination edge is added
     * @param destination the edge added to the source
     * @param weight      the weight along each edge
     */
    public void addEdge(String source, String destination, String weight, boolean biDirectional) {

        List<Edge> list = adjListMap.get(source);
        Edge edge = new Edge(destination, weight);
        list.add(edge);
        adjListMap.put(source, list);

        if (biDirectional) {
            List<Edge> listDestination = adjListMap.get(destination);
            Edge edgeDestination = new Edge(source, weight);
            listDestination.add(edgeDestination);
            adjListMap.put(destination, listDestination);
        }


    }

    /**
     * This method adds a new vertex to the graph if not present
     *
     * @param newVertex the vertex that has to be added in graph
     */
    public void addVertex(String newVertex) {
        if (!adjListMap.containsKey(newVertex)) {
            adjListMap.put(newVertex, new ArrayList<>());
            System.out.println("The vertex " + newVertex + " added successfully");
        } else {
            System.out.println("The vertex " + newVertex + " already exist");
        }
    }

    /**
     * This method gets the list of edges that belongs to a vertex
     *
     * @param vertex the vertex
     * @return List of Edges around the vertex
     */
    public List<Edge> getEdges(String vertex) {
        if (!adjListMap.containsKey(vertex)) {
            System.out.println("The vertex does not exist in the graph");
        } else {
            return adjListMap.get(vertex);
        }
        return null;
    }

    /**
     * This method gets the list of vertices in the graph
     *
     * @return List of vertices in a graph
     */

    public List<String> getVertices() {

        List<String> vertices = new ArrayList<>();

        if (adjListMap != null) {
            vertices.addAll(adjListMap.keySet());
        } else {
            System.out.println("No vertex present in graph");
        }
        return vertices;
    }

    /**
     * This method prints the content of unweighted graph map
     */
    public String printGraphUnweighted() {
        StringBuilder builder = new StringBuilder();

        for (String v : adjListMap.keySet()) {
            builder.append(v + ": ");
            builder.append("[ ");

            for (int i = 0; i < adjListMap.get(v).size(); i++) {

                if (i == adjListMap.get(v).size() - 1) {
                    builder.append("( " + adjListMap.get(v).get(i).destination + " )");
                } else {
                    builder.append("( " + adjListMap.get(v).get(i).destination + " )" + ",");
                }
            }

            builder.append(" ]");
            builder.append("\n");
        }

        return (builder.toString());
    }

    /**
     * This method prints the content of weighted graph map
     */
    public String printGraphWeighted() {
        StringBuilder builder = new StringBuilder();

        for (String v : adjListMap.keySet()) {
            builder.append(v + ": ");
            builder.append("[ ");

            for (int i = 0; i < adjListMap.get(v).size(); i++) {
                if (i == adjListMap.get(v).size() - 1) {
                    builder.append("( " + adjListMap.get(v).get(i).destination + ", " + adjListMap.get(v).get(i).weight + " )");
                } else {
                    builder.append("( " + adjListMap.get(v).get(i).destination + ", " + adjListMap.get(v).get(i).weight + " )" + ",");
                }
            }

            builder.append(" ]");
            builder.append("\n");
        }
        return (builder.toString());
    }

}