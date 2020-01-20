package com.uis.assignments.cs501.week11;

import java.util.Date;

public class GeometricObject {

    //-- data field to store color
    private String color;

    //-- data field for filled
    private boolean filled;

    //-- data field to store date created
    private Date dateCreated;

    //-- construct a default object
    public GeometricObject(){
        dateCreated = new Date();

    }

    //-- construct an object with specified color and filled value
    public GeometricObject(String color, boolean filled){
        this.color = color;
        this.filled = filled;
    }

    //-- returns color
    public String getColor() {
        return color;
    }

    //-- set the new color
    public void setColor(String color) {
        this.color = color;
    }

    //-- returns filled
    public boolean isFilled() {
        return filled;
    }

    //-- sets a new filled
    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    //-- get the created date
    public Date getDateCreated() {
        return dateCreated;
    }

    //-- returns the string representation of this object
    @Override
    public String toString() {
        return "GeometricObject{" +
                "color='" + color + '\'' +
                ", filled=" + filled +
                ", dateCreated=" + dateCreated +
                '}';
    }
}
