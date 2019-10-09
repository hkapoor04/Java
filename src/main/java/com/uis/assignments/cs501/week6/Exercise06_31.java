package com.uis.assignments.cs501.week6;

import java.util.Scanner;

public class Exercise06_31 {

    /*
     * Main Method
     */

    public static void main(String args[]) {

        //-- Reading character from the keyboard
        Scanner inputCardNumber = new Scanner(System.in);

        //-- Display input field for entering the credit card number
        System.out.println("Enter a credit card number as long integer: ");

        //-- Validate the input type to be long
        validateUserInput(inputCardNumber);
    }

    /*
     * Checking the input type of credit card number to be long
     *
     * @param: cardNumber, the credit card number entered by the user
     *
     */

    private static void validateUserInput(Scanner inputCardNumber) {

        //-- Declare and assign input credit card number
        long cardNumber = 0;

        //-- Check for input to be long
        if (!inputCardNumber.hasNextLong()) {
            System.out.println("Invalid Input");
            System.exit(-1);

        } else
            cardNumber = inputCardNumber.nextLong();

        //-- Checking the length of input credit card number
        checkCreditCardNumberLength(cardNumber);

    }


    /*
     * Checking the length of credit card numbers entered by the user :
     *                  - Must be between 13 and 16 digits
     *                  - Most not be a negative number
     *
     * @param: cardNumber, the credit card number entered by the user
     *
     */

    private static void checkCreditCardNumberLength(long cardNumber) {

        //-- Converting the input long credit card number to String
        String cardNumberString = Long.toString(cardNumber);

        //-- Checking the length of credit card number
        if (cardNumberString.trim().length() < 13 || cardNumberString.trim().length() > 16 || cardNumber < 0) {
            System.out.println(cardNumberString + " is invalid");
            System.exit(-1);
        } else
            //-- Checking the credit card type to be among Visa, Master, American Express or Discover
            checkCreditCardType(cardNumber);
    }

    /*
     * Checking the credit card type for below starting digits:
     *              - 4 for Visa cards
     *              - 5 for Master cards
     *              - 37 for American Express cards
     *              - 6 for Discover cards
     *
     * @param: cardNumber, the card number entered by the user
     *
     */
    private static void checkCreditCardType(long cardNumber) {

        //-- Converting the input long credit card number to String
        String cardNumberString = Long.toString(cardNumber);
        if (cardNumberString.trim().startsWith("4") || cardNumberString.trim().startsWith("5") || cardNumberString.trim().startsWith("6") || cardNumberString.trim().substring(0, 2).equals("37")) {

            //-- Checking the validity of the credit card number
            calculateSumOfEvenAndOddDigits(cardNumber);
        } else

            //-- Display the error message for invalid card number
            System.out.println(cardNumberString + " is invalid");
    }


    /*
     * Calculating the sum of digits at odd and even places separately
     *
     * @param: cardNumber, the card number entered by the user
     *
     */
    private static void calculateSumOfEvenAndOddDigits(long cardNumber) {

        //-- Converting the input long credit card number to String
        String cardNumberString = Long.toString(cardNumber);

        //-- Variable to store the current read number from the input credit card number
        long currentNumber;

        //-- Variable to store the double of digit at odd places
        int doubleOfOddDigits;

        //-- Variable to store the sum of digits at even places
        int sumOfEvenDigits = 0;

        //-- Variable to store the sum of digits at odd places
        int sumOfOddDigits = 0;

        for (int i = cardNumberString.trim().length(); i >= 1; i--) {

            //-- Finding out the right most number of the credit card for each run of the loop
            currentNumber = cardNumber % 10;

            //-- Calculating the sum of double of each digit on the odd position
            if (i % 2 != 0) {
                doubleOfOddDigits = (int) (currentNumber * 2);

                //-- Adding both the digits in case the double of digit is greater than 9
                if (doubleOfOddDigits >= 10) {
                    doubleOfOddDigits = doubleOfOddDigits / 10 + doubleOfOddDigits % 10;
                }

                //-- Finding the sum of digits at odd position
                sumOfOddDigits += doubleOfOddDigits;
            } else {

                //-- Finding the sum of digits at even place
                sumOfEvenDigits += currentNumber;
            }

            //-- Dividing the card number by 10 in each run of the loop to get the next digit at the right
            cardNumber = cardNumber / 10;
        }

        //-- Validity or Mod 10 Check for the credit card number entered by the user
        modTenCheck(sumOfEvenDigits, sumOfOddDigits, cardNumberString);

    }

    /*
     * Mod 10 check of the credit card number entered by the user
     *
     * @param: sumOfEvenDigits, sum of digits at even places
     *
     * @param: sumOfOddDigits, sum of digits at odd places
     *
     * @param: cardNumberString, the card number entered by the user
     *
     */
    private static void modTenCheck(int sumOfEvenDigits, int sumOfOddDigits, String cardNumberString) {

        //-- Checking sum of digits at odd and even to be divisible by 10
        if ((sumOfEvenDigits + sumOfOddDigits) % 10 == 0) {
            System.out.println(cardNumberString + " is valid");

        } else

            //-- Displaying the result in case the sum of digits at odd and even is not divisible by 10
            System.out.println(cardNumberString + " is invalid");
    }

}
