package com.slideproblems;

public class PredictFutureTuition {
    public static void main(String args[]) {
        double tuition = 10000;
        int numberOfYears = 0;
        double doubleOfTuition = tuition * 2.0;
        while (tuition <= doubleOfTuition) {
            tuition = tuition * 1.07;
            numberOfYears++;
        }
        System.out.println("Number of Years" + numberOfYears);
    }
}
