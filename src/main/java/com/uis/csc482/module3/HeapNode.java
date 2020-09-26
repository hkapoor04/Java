package com.uis.csc482.module3;

public class HeapNode  implements Comparable<HeapNode>{
    int element;
    int priority;

    @Override
    public int compareTo(HeapNode o) {
        return Integer.compare(this.priority, o.priority);
    }
}
