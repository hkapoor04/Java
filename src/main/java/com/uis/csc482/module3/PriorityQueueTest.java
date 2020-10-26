package com.uis.csc482.module3;

public class PriorityQueueTest {

    public static void main(String[] args) {
        System.out.println("**********************Testing the MinimumPriorityQueue class **********************: ");


        MinimumPriorityQueue minimumPriorityQueue = new MinimumPriorityQueue<>(11);

        minimumPriorityQueue.insert(new HeapNode(10, 8f));
        minimumPriorityQueue.insert(new HeapNode(4, 20f));
        minimumPriorityQueue.insert(new HeapNode(9, 4f));
        minimumPriorityQueue.insert(new HeapNode(1, 5f));
        minimumPriorityQueue.insert(new HeapNode(7, 12f));
        minimumPriorityQueue.insert(new HeapNode(5, 7f));
        minimumPriorityQueue.insert(new HeapNode(3, 11f));
        minimumPriorityQueue.insert(new HeapNode(2, 9f));
        minimumPriorityQueue.insert(new HeapNode(6, 10f));
        minimumPriorityQueue.insert(new HeapNode(8, 96f));
        minimumPriorityQueue.insert(new HeapNode( 11, 82f));


        minimumPriorityQueue.populatePosition();

        System.out.println("Heap Size before running extract minimum:  " + minimumPriorityQueue.getHeapSize());

        System.out.println("**********************Testing the ExtractMin Method - start **********************: ");

        minimumPriorityQueue.printHeap();

        minimumPriorityQueue.changeKey(10, 16f);

        System.out.println("-------------------------------------------------------------------------------");

        minimumPriorityQueue.printHeap();

        for (int i = 1; i <= 11; i++) {

            System.out.println("Extracting Minimum " + i + " : " + minimumPriorityQueue.extractMin().getPriority());

        }

        System.out.println("-------------------------------------------------------------------------------");
        minimumPriorityQueue.printHeap();

        System.out.println("Heap Size after running extract minimum:  " + minimumPriorityQueue.getHeapSize());

        System.out.println("**********************Testing the ExtractMin Method - end ********************** ");


        /*System.out.println("################################################################################# ");


        System.out.println("**********************Testing delete (index) Method - start **********************: ");

        MinimumPriorityQueue minimumPriorityQueue2 = new MinimumPriorityQueue(11);

        minimumPriorityQueue2.insert(new HeapNode(10, 2f));
        minimumPriorityQueue2.insert(new HeapNode(4, 3f));
        minimumPriorityQueue2.insert(new HeapNode(9, 4f));
        minimumPriorityQueue2.insert(new HeapNode(1, 10f));
        minimumPriorityQueue2.insert(new HeapNode(7, 6f));
        minimumPriorityQueue2.insert(new HeapNode(5, 7f));
        minimumPriorityQueue2.insert(new HeapNode(3, 8f));
        minimumPriorityQueue2.insert(new HeapNode(2, 9f));
        minimumPriorityQueue2.insert(new HeapNode(6, 5f));
        minimumPriorityQueue2.insert(new HeapNode(8, 11f));
        minimumPriorityQueue2.insert(new HeapNode( 11, 12f));


        minimumPriorityQueue2.populatePosition();

        System.out.println("********************** Before Deletion **********************: ");

        minimumPriorityQueue2.printHeap();

        minimumPriorityQueue2.delete(6);

        System.out.println("********************** After Deletion **********************: ");

        minimumPriorityQueue2.printHeap();

        System.out.println("**********************Testing delete (index) Method - end **********************: ");


        System.out.println("################################################################################# ");

        MinimumPriorityQueue minimumPriorityQueue3 = new MinimumPriorityQueue(11);

        minimumPriorityQueue3.insert(new HeapNode(10, 2f));
        minimumPriorityQueue3.insert(new HeapNode(4, 3f));
        minimumPriorityQueue3.insert(new HeapNode(9, 4f));
        minimumPriorityQueue3.insert(new HeapNode(1, 5f));
        minimumPriorityQueue3.insert(new HeapNode(7, 6f));
        minimumPriorityQueue3.insert(new HeapNode(5, 7f));
        minimumPriorityQueue3.insert(new HeapNode(3, 8f));
        minimumPriorityQueue3.insert(new HeapNode(2, 9f));
        minimumPriorityQueue3.insert(new HeapNode(6, 10f));
        minimumPriorityQueue3.insert(new HeapNode(8, 11f));
        minimumPriorityQueue3.insert(new HeapNode( 11, 12f));

        minimumPriorityQueue3.populatePosition();

        System.out.println("**********************Testing deleteItem Method - start **********************: ");

        System.out.println("********************** Before Deletion **********************: ");

        minimumPriorityQueue3.printHeap();

        minimumPriorityQueue3.deleteItem(6);

        System.out.println("********************** After Deletion **********************: ");

        minimumPriorityQueue3.printHeap();

        System.out.println("**********************Testing deleteItem Method - end **********************: ");


        System.out.println("################################################################################# ");

        System.out.println("**********************Testing changeKey Method - start **********************: ");

        MinimumPriorityQueue minimumPriorityQueue4 = new MinimumPriorityQueue(11);

        minimumPriorityQueue4.insert(new HeapNode(10, 2f));
        minimumPriorityQueue4.insert(new HeapNode(4, 3f));
        minimumPriorityQueue4.insert(new HeapNode(9, 4f));
        minimumPriorityQueue4.insert(new HeapNode(1, 5f));
        minimumPriorityQueue4.insert(new HeapNode(7, 6f));
        minimumPriorityQueue4.insert(new HeapNode(5, 7f));
        minimumPriorityQueue4.insert(new HeapNode(3, 8f));
        minimumPriorityQueue4.insert(new HeapNode(2, 9f));
        minimumPriorityQueue4.insert(new HeapNode(6, 10f));
        minimumPriorityQueue4.insert(new HeapNode(8, 11f));
        minimumPriorityQueue4.insert(new HeapNode( 11, 12f));

        minimumPriorityQueue4.printHeap();


        minimumPriorityQueue4.changeKey(6, 22f);

        System.out.println("After Updating the key");
        minimumPriorityQueue4.printHeap();


        for (int i = 1; i <= 10; i++) {

            System.out.println("Extracting Minimum " + i + " time " + minimumPriorityQueue4.extractMin().getPriority());

        }

        System.out.println("**********************Testing changeKey Method - end **********************: "); */


    }
}
