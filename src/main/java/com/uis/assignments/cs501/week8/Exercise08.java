package com.uis.assignments.cs501.week8;

import java.util.Scanner;

public class Exercise08 {
    /*
     * Main Method
     */

    public static void main(String args[]) {

        //-- Reading Rows and Columns from the keyboard
        Scanner inputRowsColumns = new Scanner(System.in);

        //-- Display input field for entering the rows and columns
        System.out.println("Enter the number of rows and columns of the array:");

        //-- Check for input row to be Int
        if (!inputRowsColumns.hasNextInt()) {
            System.out.println("Invalid Input");
            System.exit(-1);
        }

        //-- Declaring and initializing the input number of rows
        int rows = inputRowsColumns.nextInt();

        //-- Check for input column to be Int
        if (!inputRowsColumns.hasNextInt()) {
            System.out.println("Invalid Input");
            System.exit(-1);
        }

        //-- Declaring and initializing the input number of columns
        int columns = inputRowsColumns.nextInt();

        //-- Declaring and initializing an array with input rows and columns
        double[][] numberArray = new double[rows][columns];

        //-- Display input field for entering the array elements
        System.out.println("Enter The Array");

        //-- Iterating through each row element
        for (int i = 0; i < numberArray.length; i++) {

            //-- Iterating through each column of every row
            for (int j = 0; j < numberArray[i].length; j++) {

                //-- Check for input to be double
                if (!inputRowsColumns.hasNextDouble()) {
                    System.out.println("Invalid Input");
                    System.exit(-1);
                }

                //-- populating the array with input values
                numberArray[i][j] = inputRowsColumns.nextDouble();
            }
        }

        //-- Check for array to have length greater than zero
        if (numberArray.length > 0) {

            //-- Calling the method to locate the largest element in the array
            int[] location = locateLargest(numberArray);

            //-- Display the location of largest element in the array
            System.out.println("The location of the largest element is at (" + location[0] + "," + location[1] + ")");
        }

        //-- Display error message in case the length of array is 0
        else
            System.out.println("The array is empty");

    }

    /*
     * Locating the largest element in the array
     *
     * @param: array, the array of numbers entered by the user
     *
     */

    public static int[] locateLargest(double[][] a) {

        //-- Initialize the array to store the location of largest element
        int[] location = {0, 0};

        //-- Initializing variable to store the largest element with the first element of array
        double largestElement = a[0][0];

        //-- Iterating each row of the array
        for (int i = 0; i < a.length; i++) {

            //-- Iterating through each column for every row
            for (int j = 0; j < a[i].length; j++) {

                //-- Finding the largest element
                if (largestElement < a[i][j]) {
                    largestElement = a[i][j];

                    //-- Assigning the row and column of the largest element to the integer array
                    location[0] = i;
                    location[1] = j;
                }
            }
        }
        //-- Returns the array with location of largest element
        return location;
    }
}
