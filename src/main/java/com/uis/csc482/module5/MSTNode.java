package com.uis.csc482.module5;

public class MSTNode <T extends Comparable<T>> {
    private T weight;
    private T parent;

    public MSTNode(T weight, T parent){
        this.weight = weight;
        this.parent = parent;
    }

    public T getWeight() {
        return weight;
    }

    public T getParent() {
        return parent;
    }
}
