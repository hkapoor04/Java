package com.uis.assignments.cs501.week11;

public class Triangle extends GeometricObject {

    //-- data field to store three sides of the triangle
    private double side1, side2, side3;

    //-- no-arg constructor that creates default triangle
     Triangle(){
        this(1.0,1.0, 1.0);
    }

    //-- constructor that creates triangle with three given sides.
    Triangle(double side1, double side2, double side3){
         this.side1 = side1;
         this.side2 = side2;
         this.side3 = side3;
    }

    /*
     * Method to find the area of triangle
     */
    public double getArea(){
        if(side1 <=0 || side2 <=0 || side3 <=0){
            System.out.println("Invalid sides of triangle");
            System.exit(-1);
        }
         double semiPerimeter = Math.round(((side1+side2+side3)/2.0)*100.0)/100.0;
         return  Math.round(Math.sqrt(Math.abs(semiPerimeter*(semiPerimeter-side1)*(semiPerimeter-side2)*(semiPerimeter-side3)))*100.0)/100.0;
    }

    /*
     * Method to find the perimeter of triangle
     */
    public double getPerimeter(){
         return side1+side2+side3;
    }

    //-- returns the string representation of this object
    @Override
    public String toString() {
        return "Triangle" +
                "side1=" + side1 +
                ", side2=" + side2 +
                ", side3=" + side3;
    }
}
