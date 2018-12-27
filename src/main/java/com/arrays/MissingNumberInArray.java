package com.arrays;

/**
 * Created by Harshit on 9/5/2017.
 */
public class MissingNumberInArray {

    public static void main(String args[]){

        int sumOfNNumbers = sumOfIntegers(7);

        sumOfArrayElements(sumOfNNumbers);
    }


    static void sumOfArrayElements(int sumOfNNumber){
        int [] arr = {1,2,3,4,5,7};

        int sum =0;

        for(int k =0; k<arr.length;k++){

             sum = sum + arr[k];

        }

        int missingNumber = sumOfNNumber-sum;

        System.out.println("Missing Number is"+missingNumber);
    }

    static int sumOfIntegers(int i){

        int sum = i*(i+1)/2;

        return sum;

    }

}
