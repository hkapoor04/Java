package com.uis.csc482.module3;

public class PriorityQueueTest {

    public static void main(String[] args) {
        System.out.println("**********************Testing the MinimumPriorityQueue class **********************: ");


        MinimumPriorityQueue minimumPriorityQueue = new MinimumPriorityQueue(11);

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
        minimumPriorityQueue.insert(11);


        minimumPriorityQueue.populatePosition();

        System.out.println("Heap Size before running extract minimum:  " + minimumPriorityQueue.getHeapSize());

        System.out.println("**********************Testing the ExtractMin Method - start **********************: ");

        for (int i = 1; i <= 11; i++) {

            System.out.println("Extracting Minimum " + i + " time " + minimumPriorityQueue.extractMin());

        }

        System.out.println("Heap Size after running extract minimum:  " + minimumPriorityQueue.getHeapSize());

        System.out.println("**********************Testing the ExtractMin Method - end ********************** ");


        System.out.println("################################################################################# ");


        System.out.println("**********************Testing delete (index) Method - start **********************: ");

        MinimumPriorityQueue minimumPriorityQueue2 = new MinimumPriorityQueue(10);

        minimumPriorityQueue2.insert(10);
        minimumPriorityQueue2.insert(4);
        minimumPriorityQueue2.insert(9);
        minimumPriorityQueue2.insert(1);
        minimumPriorityQueue2.insert(7);
        minimumPriorityQueue2.insert(5);
        minimumPriorityQueue2.insert(3);
        minimumPriorityQueue2.insert(2);
        minimumPriorityQueue2.insert(6);
        minimumPriorityQueue2.insert(8);


        minimumPriorityQueue2.populatePosition();

        System.out.println("********************** Before Deletion **********************: ");

        minimumPriorityQueue2.printHeap();

        minimumPriorityQueue2.delete(minimumPriorityQueue2.getHeapMap().get(6));

        System.out.println("********************** After Deletion **********************: ");

        minimumPriorityQueue2.printHeap();

        System.out.println("**********************Testing delete (index) Method - end **********************: ");


        System.out.println("################################################################################# ");

        MinimumPriorityQueue minimumPriorityQueue3 = new MinimumPriorityQueue(10);

        minimumPriorityQueue3.insert(10);
        minimumPriorityQueue3.insert(4);
        minimumPriorityQueue3.insert(9);
        minimumPriorityQueue3.insert(1);
        minimumPriorityQueue3.insert(7);
        minimumPriorityQueue3.insert(5);
        minimumPriorityQueue3.insert(3);
        minimumPriorityQueue3.insert(2);
        minimumPriorityQueue3.insert(6);
        minimumPriorityQueue3.insert(8);

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

        MinimumPriorityQueue minimumPriorityQueue4 = new MinimumPriorityQueue(10);

        minimumPriorityQueue4.insert(10);
        minimumPriorityQueue4.insert(4);
        minimumPriorityQueue4.insert(9);
        minimumPriorityQueue4.insert(1);
        minimumPriorityQueue4.insert(7);
        minimumPriorityQueue4.insert(5);
        minimumPriorityQueue4.insert(3);
        minimumPriorityQueue4.insert(2);
        minimumPriorityQueue4.insert(6);
        minimumPriorityQueue4.insert(8);

        minimumPriorityQueue4.printHeap();


        minimumPriorityQueue4.changeKey(6, 12);

        System.out.println("After Updating the key");
        minimumPriorityQueue4.printHeap();


        for (int i = 1; i <= 10; i++) {

            System.out.println("Extracting Minimum " + i + " time " + minimumPriorityQueue4.extractMin());

        }

        System.out.println("**********************Testing changeKey Method - end **********************: ");


    }
}
