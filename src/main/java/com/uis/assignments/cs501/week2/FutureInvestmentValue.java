package com.uis.assignments.cs501.week2;

import java.util.Scanner;

public class FutureInvestmentValue {
    /**
     * Main Method
     */
    public static void main(String args[]) {

        int i,j;
        for(i=0;i>1;i++){
            System.out.println(i);
        }

        String ss = "jkl", ff = "tt";

        //-- Reading Investment Amount from Keyboard
        Scanner readInvestmentAmount = new Scanner(System.in);

        //-- Display Input field for investment amount
        System.out.println("Enter Investment Amount: ");

        //-- Declaring and assigning input investment amount
        double investmentAmount = readInvestmentAmount.nextDouble();

        //-- Terminate the program in case the amount entered is negative
        if (investmentAmount < 0) {
            System.err.println("The amount cannot be negative.");
            System.exit(-1);
        }

        //-- Reading Annual Interest rate from Keyboard
        Scanner readAnnualInterestRate = new Scanner(System.in);

        //-- Display Input field for interest rate
        System.out.println("\n Enter Interest Rate: ");

        //-- Declaring and assigning input interest rate
        double annualInterestRate = readAnnualInterestRate.nextDouble();

        //-- Calculating monthly interest rate and rounding it
        double monthlyInterestRate = Math.round((annualInterestRate / 12.0) * 10000.0) / 10000.0;

        //-- Reading number of years from Keyboard
        Scanner readNumberOfYears = new Scanner(System.in);

        //-- Display Input field for number of years
        System.out.println("\n Enter Number of Years: ");

        //-- Declaring and assigning input number of years
        int numberOfYears = readNumberOfYears.nextInt();

        //-- Terminate the program in case the number of years entered is negative
        if (numberOfYears < 0) {
            System.err.println("The number of years cannot be negative.");
            System.exit(-1);
        }

        // Calculating the future investment value
        double futureInvestmentValue = investmentAmount * Math.pow(1 + monthlyInterestRate / 100, numberOfYears * 12);

        //-- Display the result
        System.out.println("\n The Future Investment value is $" + Math.round(futureInvestmentValue * 100.0) / 100.0);

    }
}
