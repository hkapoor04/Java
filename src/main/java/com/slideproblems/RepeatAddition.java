package com.slideproblems;

import java.util.Scanner;

public class RepeatAddition {

    public static void main(String args[]) {

        double firstNumber = Math.random() * 100;

        double secondNumber =  Math.random() * 100;

        double sum = 0;
        do {
            System.out.print("Enter the sum of " + (int)firstNumber + " and " + (int)secondNumber + " ");
            Scanner inputSum = new Scanner(System.in);
            sum = inputSum.nextInt();
        } while (sum != (int)firstNumber + (int)secondNumber);

    }
}
