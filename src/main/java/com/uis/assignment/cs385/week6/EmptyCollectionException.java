package com.uis.assignment.cs385.week6;

public class EmptyCollectionException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public EmptyCollectionException(String msg ){
        super(msg);
    }
}
