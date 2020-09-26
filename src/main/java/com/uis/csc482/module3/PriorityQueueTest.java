package com.uis.csc482.module3;

public class PriorityQueueTest {

    public static void main(String[] args){
        MinimumPriorityQueue maxHeap = new MinimumPriorityQueue(10);
        maxHeap.insert(10);
        maxHeap.insert(4);
        maxHeap.insert(9);
        maxHeap.insert(1);
        maxHeap.insert(7);
        maxHeap.insert(5);
        maxHeap.insert(3);
        maxHeap.insert(2);
        maxHeap.insert(6);
        maxHeap.insert(8);

        maxHeap.printHeap();
        //maxHeap.delete(5);
        //maxHeap.printHeap();

    }
}
