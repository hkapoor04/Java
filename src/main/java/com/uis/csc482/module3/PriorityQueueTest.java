package com.uis.csc482.module3;

public class PriorityQueueTest {

    public static void main(String[] args){
        MinimumPriorityQueue minimumPriorityQueue = new MinimumPriorityQueue(10);
        minimumPriorityQueue.insert(10);
        minimumPriorityQueue.insert(4);
        minimumPriorityQueue.insert(9);
        minimumPriorityQueue.insert(1);
        minimumPriorityQueue.insert(7);
        minimumPriorityQueue.insert(5);
        minimumPriorityQueue.insert(3);
        minimumPriorityQueue.insert(2);
        minimumPriorityQueue.insert(6);
        minimumPriorityQueue.insert(8);


        //System.out.println("Minimum " + maxHeap.extractMin());
        //maxHeap.delete(0);

        minimumPriorityQueue.populatePosition();
        minimumPriorityQueue.printHeap();
        System.out.println("MinimumNow " + minimumPriorityQueue.extractMin());
        //maxHeap.printHeap();
        //maxHeap.delete(0);

        System.out.println("Minimum Again " + minimumPriorityQueue.extractMin());

        System.out.println("Minimum Again1 " + minimumPriorityQueue.extractMin());

        System.out.println("Minimum Again2 " + minimumPriorityQueue.extractMin());

        System.out.println("Minimum Again3 " + minimumPriorityQueue.extractMin());
        //maxHeap.printHeap();
    }
}
