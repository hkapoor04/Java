package com.uis.csc482.module3;

public class HeapNode<T>  implements Comparable<HeapNode>{
    T element;
    int priority;

    public HeapNode(T element, int priority){
        this.element = element;
        this.priority = priority;
    }

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public int compareTo(HeapNode o) {
        return Integer.compare(this.priority, o.priority);
    }


}
