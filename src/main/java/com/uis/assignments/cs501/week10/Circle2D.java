package com.uis.assignments.cs501.week10;

public class Circle2D {

    //-- data fields to specify the centre of circle (x,y)
    private double x, y;

    //-- data field to store radius
    private double radius;

    //-- default no-arg constructor with values initialized for x, y and radius
    Circle2D() {
        this(0, 0, 1);
    }

    //-- constructor for creating circle with specific x, y and radius
    Circle2D(double x, double y, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    //-- get method for x
    public double getX() {
        return x;
    }

    //-- get method for y
    public double getY() {
        return y;
    }

    //-- get method for radius
    public double getRadius() {
        return radius;
    }

    /*
     * Method to calculate the area of circle with given radius
     *
     * @return double: area
     */
    public double getArea() {
        return Math.PI * radius * radius;
    }

    /*
     * Method to calculate the perimeter of circle with given radius
     *
     * @return double: perimeter
     */
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    /*
     * Method to find the position of given points w r t circle
     *
     * @return boolean: result of the location of point
     *                  - true  if given point is inside the circle
     *                  - false otherwise
     */

    public boolean contains(double x, double y) {
        return (radius > Math.sqrt(Math.abs((x - this.x) * (x - this.x) - (y - this.y) * (y - this.y))));
    }

    /*
     * Method to find the position of given circle w r t circle
     *
     * @return boolean: result of the location of circle
     *                  - true  if given circle is inside the circle
     *                  - false otherwise
     */

    public boolean contains(Circle2D circle) {
        return (radius > circle.radius + Math.sqrt(Math.abs((x - circle.x) * (x - circle.x) - (y - circle.y) * (y - circle.y))));
    }

    /*
     * Method to find if the given circle overlaps the circle
     *
     * @return boolean: result of the location of circle
     *                  - true  if given circle overlaps the circle
     *                  - false otherwise
     */
    public boolean overlaps(Circle2D circle) {
        return ((radius + circle.radius) > Math.sqrt(Math.abs((x - circle.x) * (x - circle.x) - (y - circle.y) * (y - circle.y))));
    }
}
