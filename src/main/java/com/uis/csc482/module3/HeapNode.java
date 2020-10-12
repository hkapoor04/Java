package com.uis.csc482.module3;

public class HeapNode<T extends Comparable<T>>  implements Comparable<HeapNode<T>>{
    private T element;
    private T priority;

    public HeapNode(T element, T priority){
        this.element = element;
        this.priority = priority;
    }

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public T getPriority() {
        return this.priority;
    }

    public void setPriority(T priority) {
        this.priority = priority;
    }

    @Override
    public int compareTo( HeapNode <T> o) {
        if (this.getPriority().compareTo(o.getPriority()) > 0) {
            return 1;
        } else if (this.compareTo(o) == 0) {
            return 0;
        } else return -1;
    }


}
