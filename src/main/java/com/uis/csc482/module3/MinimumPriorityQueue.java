package com.uis.csc482.module3;

import java.util.NoSuchElementException;

public class MinimumPriorityQueue {

    private int[] heap;

    private int heapSize;

    private int maximumSize;

    public MinimumPriorityQueue(int maximumSize)
    {
        this.maximumSize = maximumSize;
        this.heapSize = 0;
        heap = new int[this.maximumSize + 1];
        heap[0] = Integer.MIN_VALUE;
    }


    /**
     *  This will check if the heap is empty or not
     */
    public boolean isEmpty(){
        return heapSize==0;
    }

    /**
     *  This will check if the heap is full or not
     */
    public boolean isFull(){
        return heapSize == heap.length;
    }



    /**
     * Creates a priority queue
     * @param n
     * @return MinimumPriorityQueue
     */
    public static MinimumPriorityQueue startHeap(int n){

        return new MinimumPriorityQueue(n);
    }

    /**
     * Function to get right child of a node of a tree
     */
    public int getRightChildIndex(int index) {
        if(index >= 0)
            return (2*index)+1;
        return -1;
    }

    /**
     * Function to get left child of a node of a tree
     */
    public int getLeftChildIndex(int index) {
        if(index >= 0)
            return 2*index;
        return -1;
    }

    /**
     * Function to get parent of a node of a tree
     */
    public int getParent(int index) {
        if(index >= 1)
            return index/2;
        return -1;
    }

    /**
     * Function to swap two node values of heap
     */
    public void swap(int firstNodeValue, int secondNodeValue)
    {
        int tmp;
        tmp = heap[firstNodeValue];
        heap[firstNodeValue] = heap[secondNodeValue];
        heap[secondNodeValue] = tmp;
    }

    /**
     * Function to heapify up
     */
    public void heapify_up(int index){

        if(index > 1){
            int parentIndex = getParent(index);
            if(heap[index] < heap[parentIndex]){
                swap(index, parentIndex);

                heapify_up(parentIndex);
            }
        }
    }

    /**
     * Function to heapify down
     */
    public void heapify_down(int index){

        int leftChildIndex =  getLeftChildIndex(index);

        int rightChildIndex = getRightChildIndex(index);

        int smallest = 0;

        if((leftChildIndex < heap.length ) && heap[leftChildIndex] < heap[index]){
            smallest =  leftChildIndex;

        } else {
            smallest = index;
        }

        if((rightChildIndex < heap.length) && heap[rightChildIndex] < heap[smallest]){
            smallest =  rightChildIndex;

        }

        if(smallest != index){
            swap(index, smallest);
            heapify_down(smallest);
        }
    }


    /**
     * Function to find the least element in the heap
     */
    public int findMin(){

        return heap[1];
    }

    /**
     * Function to identify the element with the minimum key value
     */
    public int extractMin()
    {
        int element = heap[1];
        heap[1] = heap[heapSize--];
        heapify_down(1);
        return element;
    }


    /**
     *  This will delete the element at the position index
     */
    public int delete(int index){
        if(isEmpty())
            throw new NoSuchElementException("Heap is empty, no element to delete");

        int element = heap[index];
        heap[index] = heap[heapSize -1];
        heapSize--;
        heapify_down(index);
        return element;
    }


    /**
     *  This will insert new element in to heap
     */
    public void insert(int element){
        if(isFull())
            throw new NoSuchElementException("Heap is full, cannot insert new element");
        heap[0] = element;
        heapify_down(0);
        heapSize++;

        //heapSize++;

        //heap[heapSize - 1] = element;

        //heapify_up(heapSize - 1);
    }


    /**
     *  This method used to print all element of the heap
     *
     */
    public void printHeap()
    {
        for (int i = 1; i < maximumSize; i++)
            System.out.println(heap[i] +" ");
    }

}
