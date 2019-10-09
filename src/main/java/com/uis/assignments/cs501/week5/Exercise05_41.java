package com.uis.assignments.cs501.week5;

import java.util.Scanner;

public class Exercise05_41 {

    /*
     * Main Method
     */

    public static void main(String args[]) {

        //-- Declaring a variable and assigning minimum Integer value
        int maximumNumber = Integer.MIN_VALUE;

        //-- Variable to store the count of largest number and initializing it with value 1
        int count = 1;

        //-- Variable to store each input number
        int number;

        //-- Display input field for entering the numbers
        System.out.println("Enter Numbers");

        //-- Reading numbers from the keyboard
        Scanner inputNumbers = new Scanner(System.in);

        do {
            //-- reading the integer value entered by the user
            number = inputNumbers.nextInt();

            //-- Finding the maximum number and assigning it to declared variable
            if (number > maximumNumber) {
                maximumNumber = number;
                count = 0; //-- The count is reset to 0 in case the next number encountered in the greatest
            }

            //-- Checking the next occurrences of current greatest number
            if (number == maximumNumber) {
                count++; //-- Incrementing the counter each time the greatest number is encountered next
            }

        } while (number != 0); //-- Continue repeating the logic until 0 is entered from the keyboard

        //-- Display the maximumNumber
        System.out.println("The largest number is " + maximumNumber);

        //-- Display the count of maximumNumber
        System.out.println("The occurrence count of the largest number is " + count);


    }
}
