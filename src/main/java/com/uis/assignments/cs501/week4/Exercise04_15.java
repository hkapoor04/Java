package com.uis.assignments.cs501.week4;

import java.util.Scanner;

public class Exercise04_15 {

    /*
    * Main Method
    */
    public static void main(String args[]) {

        //-- Reading character from the keyboard
        Scanner readCharacter = new Scanner(System.in);

        //-- Display input field for entering the letter
        System.out.println("Enter a letter ");

        //-- Declare and assign input letter
        String letter = readCharacter.nextLine();

        //-- Checking for input to be non empty
        if (letter.trim().isEmpty()) {
            System.out.println("Invalid input");
            System.exit(-1);
        }

        //-- Trimming white spaces and reading the input character at index 0
        char character = letter.trim().charAt(0);

        //-- Converting the input character to upper case.
        character = Character.toUpperCase(character);

        // -- Declaring and initializing int variable to store the display value
        int digit = 0;

        //-- Checking for input to be a letter
        if (Character.isLetter(character)) {

            //-- Finding the corresponding number and assigning it to the declared int variable
            if (character >= 'W')
                digit = 9;
            else if (character >= 'T')
                digit = 8;
            else if (character >= 'P')
                digit = 7;
            else if (character >= 'M')
                digit = 6;
            else if (character >= 'J')
                digit = 5;
            else if (character >= 'G')
                digit = 4;
            else if (character >= 'D')
                digit = 3;
            else if (character >= 'A')
                digit = 2;

            //-- Display the result
            System.out.println(" The Number is " + digit);
        } else
            System.out.println("Invalid input");

    }
}
