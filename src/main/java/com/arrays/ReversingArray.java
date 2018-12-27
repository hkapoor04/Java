package com.arrays;

/**
 * Created by Harshit on 9/3/2017.
 */
public class ReversingArray {

    public static void main(String args[]){

        int [] arr = {1,2,3,4,5,6,7,8};

        System.out.println("Before");
        printArray(arr);

        for(int i=0; i<=arr.length/2;i++){
            int Temp = arr[i];
            arr[i] = arr[arr.length-1-i];
            arr[arr.length-1-i] = Temp;
        }
        System.out.println("After Reversing");
        printArray(arr);

    }

    static void printArray(int ar[]){
        for(int l:ar)
            System.out.println(l);
    }
}
