package com.slideproblems;

import java.util.Scanner;

public class Table {

    public static void main(String args[]){

        System.out.println(" Enter a number");

        Scanner inputNumber = new Scanner(System.in);

        int input = inputNumber.nextInt();

        for(int i=1;i<=10; i++){

            System.out.println(input * i );
        }
    }
}
