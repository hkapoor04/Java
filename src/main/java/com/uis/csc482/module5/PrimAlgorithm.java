package com.uis.csc482.module5;

import com.uis.csc482.module3.HeapNode;
import com.uis.csc482.module3.MinimumPriorityQueue;
import com.uis.csc482.module4.Edge;
import com.uis.csc482.module4.GraphLanguage;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrimAlgorithm {

    public void processPrimAlgorithm( String inputFileName, String outputFileName) throws IOException {
    //public static void main(String args []) throws IOException{

        GraphLanguage graphLanguage = new GraphLanguage();
        Map<String, List<Edge>> stringListMap =  graphLanguage.processFile(inputFileName);

        Map<Object, Object> mst = new HashMap<>();

        Map<Object, Boolean> connected = new HashMap<>();

        MinimumPriorityQueue minimumPriorityQueue = new MinimumPriorityQueue(stringListMap.size());

        for (String v : stringListMap.keySet()){

            connected.put(v,false);

            if(v.equalsIgnoreCase("r")){
                minimumPriorityQueue.insert(new HeapNode(v, 0.0F));
            } else {

                minimumPriorityQueue.insert(new HeapNode(v, 99999F));
            }
        }

        while(!minimumPriorityQueue.isEmpty()){

            HeapNode heapNode = minimumPriorityQueue.extractMin();

            if(!connected.get(heapNode.getElement())) {

                for (Map.Entry<String, List<Edge>> entry : stringListMap.entrySet()) {
                    for(int i=0; i< entry.getValue().size(); i++) {
                        if (heapNode.getPriority().compareTo(entry.getValue().get(i).getWeight()) == 0) {

                mst.put(heapNode.getElement(), new MSTNode(heapNode.getPriority(), entry.getValue().get(i).getDestination()));
                        }
                    }
                }

                connected.put(heapNode.getElement(), true);

                List<Edge> edges = stringListMap.get(heapNode.getElement());

                for (int i = 0; i < edges.size(); i++) {

                    minimumPriorityQueue.changeKey(edges.get(i).getDestination(), edges.get(i).getWeight());

                }

            }
        }

        String filePath = new File("").getAbsolutePath();

    Writer writer = new BufferedWriter(new OutputStreamWriter(
            new FileOutputStream(new File(filePath + outputFileName)), StandardCharsets.UTF_8));
    mst.forEach((key, MSTNode) -> {
        try {


            StringBuilder stringBuilder = new StringBuilder();

            MSTNode mstNode = (com.uis.csc482.module5.MSTNode) mst.get(key);
            stringBuilder.append(mstNode.getWeight() + " = " + mstNode.getParent());

            writer.write(key + " = " + stringBuilder.toString() + System.lineSeparator());

        } catch (IOException e) {
            e.printStackTrace();
        }
    });
    writer.flush();
    writer.close();


    }
}
