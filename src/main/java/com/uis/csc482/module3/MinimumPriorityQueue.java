package com.uis.csc482.module3;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class MinimumPriorityQueue<T> {

    private HeapNode[] heap;

    private int heapSize;

    private int maximumSize;

    private Map<HeapNode, Integer> heapMap;

    public MinimumPriorityQueue(int maximumSize) {
        this.maximumSize = maximumSize;
        this.heapSize = 0;
        heap = new HeapNode[this.maximumSize + 1];
       for(int i=1; i<=maximumSize; i++){
           heap[i] = new HeapNode(0,0);
       }
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
        return heapSize == (heap.length - 1);
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
        HeapNode tmp = heap[firstNodeValue];
        heap[firstNodeValue] = heap[secondNodeValue];
        heap[secondNodeValue] = tmp;
    }


    /**
     * Function to heapify up
     */
    public void heapify_up(int index) {

        if (index > 1) {
            int parentIndex = getParent(index);
            if (heap[index].getPriority() < heap[parentIndex].getPriority()) {
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

        if ((leftChildIndex <= maximumSize) && heap[leftChildIndex] !=null && heap[leftChildIndex].getPriority() < heap[index].getPriority()) {
            smallest = leftChildIndex;

        } else {
            smallest = index;
        }

        if ( (rightChildIndex <= maximumSize) && heap[rightChildIndex]!= null && heap[rightChildIndex].getPriority() < heap[smallest].getPriority()) {
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
    public HeapNode findMin() {

        return heap[1];
    }

    /**
     * Function to identify the element with the minimum key value
     */
    public HeapNode extractMin() {

        if (isEmpty())
            throw new NoSuchElementException("Heap is empty, no element to extract");

        //-- Extracting the first element as it is the minimum
        HeapNode element = heap[1];

        //-- Deleting the first element from the heap by moving the item in the last array position to first
        heap[1] = heap[maximumSize];

        //-- Reducing the heap size upon deletion of an entry
        heapSize--;

        //-- Reducing the maximum size upon deletion of an entry
        maximumSize--;

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
    public HeapNode delete(int index) {
        if (isEmpty())
            throw new NoSuchElementException("Heap is empty, no element to delete");

        if (index > maximumSize) {
            throw new ArrayIndexOutOfBoundsException("The index is outside the maximum size of heap");
        }

        //-- Finding the element at the particular index in the heap
        HeapNode element = heap[index];

        //-- Deleting the element from the heap by moving the item in the last array position to index
        heap[index] = heap[heapSize];

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
     * @param heapNode - The element to be inserted in heap
     */
    public void insert(HeapNode  heapNode) {
        if (isFull())
            throw new NoSuchElementException("Heap is full, cannot insert new element");
        if (heap.length == maximumSize) {
            throw new ArrayIndexOutOfBoundsException("Heap is full capacity");
        }

        //-- Inserting new element at index 0
        heap[0] = heapNode;

        //-- calling heapify down to readjust the entire heap
        heapify_down(0);

        //-- Incrementing the heap size with each addition
        heapSize++;
    }


    /**
     * This method used to print all element of the heap
     */
    public void printHeap() {
        for (int i = 1; i <= maximumSize; i++)
            System.out.println("(" + heap[i].element + ", " + heap[i].priority + ")");
    }


    /**
     * This method adds all element of the heap in a map
     */
    public Map<HeapNode, Integer> populatePosition() {
        for (int i = 1; i <= maximumSize; i++) {
            heapMap.put(heap[i], i);
        }
        return heapMap;
    }

    /**
     * This method deletes a particular item from heap
     *
     * @param item - The item to be deleted
     */
    public HeapNode deleteItem(T item) {
        for (int i = 1; i <= maximumSize; i++) {
            if (heap[i].element == item) {
                return delete(i);
            }
        }
        throw new NoSuchElementException("Item does not exist in heap");
    }

    /**
     * This method changes a particular item in heap
     *
     * @param oldPriority     - The item to be changed
     * @param newPriority - The new value of the item
     */

    public void changeKey(int oldPriority, int newPriority) {
        for (int i = 1; i <= maximumSize; i++) {
            if (heap[i].priority == oldPriority) {
                heap[i].priority = newPriority;
                heapify_down(i);
            }
        }


    }

    public int getHeapSize() {
        return heapSize;
    }

    public int getMaximumSize() {
        return maximumSize;
    }

    public Map<HeapNode, Integer> getHeapMap() {
        return heapMap;
    }
}
