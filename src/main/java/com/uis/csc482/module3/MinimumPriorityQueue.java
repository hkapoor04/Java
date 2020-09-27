package com.uis.csc482.module3;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class MinimumPriorityQueue {

    private int[] heap;

    private int heapSize;

    private int maximumSize;

    private Map<Integer, Integer> heapMap;

    public MinimumPriorityQueue(int maximumSize) {
        this.maximumSize = maximumSize;
        this.heapSize = 0;
        heap = new int[this.maximumSize + 1];
        heap[0] = Integer.MIN_VALUE;
        heapMap = new HashMap<>();
    }


    /**
     * This will check if the heap is empty or not
     */
    public boolean isEmpty() {
        return heapSize == 0;
    }

    /**
     * This will check if the heap is full or not
     */
    public boolean isFull() {
        return heapSize == heap.length;
    }


    /**
     * Creates a priority queue
     *
     * @param n
     * @return MinimumPriorityQueue
     */
    public static MinimumPriorityQueue startHeap(int n) {

        return new MinimumPriorityQueue(n);
    }

    /**
     * Function to get right child of a node of a tree
     */
    public int getRightChildIndex(int index) {
        if (index >= 0)
            return (2 * index) + 1;
        return -1;
    }

    /**
     * Function to get left child of a node of a tree
     */
    public int getLeftChildIndex(int index) {
        if (index >= 0)
            return 2 * index;
        return -1;
    }

    /**
     * Function to get parent of a node of a tree
     */
    public int getParent(int index) {
        if (index >= 1)
            return index / 2;
        return -1;
    }

    /**
     * Function to swap two nodes' values of heap
     */
    public void swap(int firstNodeValue, int secondNodeValue) {
        int tmp;
        tmp = heap[firstNodeValue];
        heap[firstNodeValue] = heap[secondNodeValue];
        heap[secondNodeValue] = tmp;
    }

    /**
     * Function to heapify up
     */
    public void heapify_up(int index) {

        if (index > 1) {
            int parentIndex = getParent(index);
            if (heap[index] < heap[parentIndex]) {
                swap(index, parentIndex);

                heapify_up(parentIndex);
            }
        }
    }

    /**
     * Function to heapify down
     */
    public void heapify_down(int index) {

        int leftChildIndex = getLeftChildIndex(index);

        int rightChildIndex = getRightChildIndex(index);

        int smallest = 0;

        if ((leftChildIndex < heap.length) && heap[leftChildIndex] < heap[index]) {
            smallest = leftChildIndex;

        } else {
            smallest = index;
        }

        if ((rightChildIndex < heap.length) && heap[rightChildIndex] < heap[smallest]) {
            smallest = rightChildIndex;

        }

        if (smallest != index) {
            swap(index, smallest);
            heapify_down(smallest);
        }
    }


    /**
     * Function to find the least element in the heap
     */
    public int findMin() {

        return heap[1];
    }

    /**
     * Function to identify the element with the minimum key value
     */
    public int extractMin() {
        //-- Extracting the first element as it is the minimum
        int element = heap[1];

        //-- Deleting the first element from the heap by moving the item in the last array position to first
        heap[1] = heap[heapSize--];

        //-- calling heapify down to readjust the entire heap
        heapify_down(1);

        //-- The deleted element is returned
        return element;
    }


    /**
     * This will delete the element at the position index
     *
     * @param index - The index of the entry to be deleted
     */
    public int delete(int index) {
        if (isEmpty())
            throw new NoSuchElementException("Heap is empty, no element to delete");

        //-- Finding the element at the particular index in the heap
        int element = heap[index];

        //-- Deleting the element from the heap by moving the item in the last array position to index
        heap[index] = heap[heapSize - 1];

        //-- Reducing the heap size upon deletion of an entry
        heapSize--;

        //-- calling heapify down to readjust the entire heap
        heapify_down(index);

        //-- The deleted element is returned
        return element;
    }


    /**
     * This will insert new element in to heap
     *
     * @param element - The element to be inserted in heap
     */
    public void insert(int element) {
        if (isFull())
            throw new NoSuchElementException("Heap is full, cannot insert new element");

        //-- Inserting new element at index 0
        heap[0] = element;

        //-- calling heapify down to readjust the entire heap
        heapify_down(0);

        //-- Incrementing the heap size with each addition
        heapSize++;
    }


    /**
     * This method used to print all element of the heap
     */
    public void printHeap() {
        for (int i = 1; i < maximumSize; i++)
            System.out.println(heap[i] + " ");
    }


    /**
     * This method adds all element of the heap in a map
     */
    public Map<Integer, Integer> populatePosition() {
        for (int i = 1; i < maximumSize; i++) {
            heapMap.put(heap[i], i);
        }
        return heapMap;
    }

    /**
     * This method deletes a particular item from heap
     *
     * @param item - The item to be deleted
     */
    public int deleteItem(int item) {
        return delete(item);
    }

    /**
     * This method changes a particular item in heap
     *
     * @param item - The item to be changed
     * @param newValue - The new value of the item
     */

    public void changeKey(int item, int newValue){

        for(int i = 1; i< maximumSize; i++){
            if(heap[i] != item){
                throw new NoSuchElementException("The item {} does not exist in heap" + item);
            } else{
                heap[i] = newValue;
                heapify_down(i);
            }
        }

    }

}
