package com.uis.assignments.cs501.week3;


import java.util.Scanner;

public class Exercise03_23 {

    /*
     * Main Method
     */

    public static void main(String args[]) {

        //-- Reading coordinates from the keyboard
        Scanner readCoordinates = new Scanner(System.in);

        //-- Display input field for two coordinates
        System.out.println("Enter a point with two coordinates: ");

        //-- Declaring and assigning input horizontal coordinate
        double horizontalCoordinate = readCoordinates.nextDouble();

        //-- Declaring and assigning input vertical coordinate
        double verticalCoordinate = readCoordinates.nextDouble();

        /* Checking if the coordinates are within the rectangle centred at (0,0) with width 10
         * and height 5 and displaying the result accordingly
         */
        if (Math.abs(horizontalCoordinate) <= 10 / 2.0 && Math.abs(verticalCoordinate) <= 5 / 2.0)
            System.out.println("Point (" + horizontalCoordinate + ", " + verticalCoordinate + ") is in the rectangle");
        else
            System.out.println("Point (" + horizontalCoordinate + ", " + verticalCoordinate + ") is not in the rectangle");

    }
}


