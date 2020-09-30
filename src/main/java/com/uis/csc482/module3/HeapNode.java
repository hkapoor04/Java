package com.uis.csc482.module3;

public class HeapNode  implements Comparable<HeapNode>{
    int element;
    int priority;

    public HeapNode(int element, int priority){
        this.element = element;
        this.priority = priority;
    }

    public int getElement() {
        return element;
    }

    public void setElement(int element) {
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
