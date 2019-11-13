package com.slideproblems;

import java.util.Scanner;

public class MathLearningTool {

    public static void main(String args[]) {
        int count = 0;
        for (int i = 0; i < 5; i++) {
            double firstNumber = Math.random() * 100;
            double secondNumber = Math.random() * 100;
            if (firstNumber >= secondNumber)
                System.out.print("Enter your answer " + (int) firstNumber + " - " + (int) secondNumber + " = ");
            else
                System.out.print("Enter your answer " + (int) secondNumber + " - " + (int) firstNumber + " = ");
            Scanner inputNumber = new Scanner(System.in);

            if (inputNumber.nextInt() == Math.abs((int)secondNumber - (int)firstNumber)) {
                count++;
            }
        }

        System.out.println("Number of correct questions " + count);
    }
}
