package com.arrays;

/**
 * Created by Harshit on 9/15/2017.
 */
public class MinMaxInArray {



    public static void main(String args[]) {

        int[] arr = {1, 2, 3, 5, 4};

        int max = Integer.MAX_VALUE;

        for(int i : arr){
            if (i<max) {
                max =i;
            }
        }
        System.out.print(max);
    }

}
