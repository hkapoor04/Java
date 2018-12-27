package com.Sorting;

/**
 * Created by Harshit on 9/19/2017.
 */
public class BubbleSort {

    public static void main (String args []){

        int arr [] = {1,6,2,8,3,4,10};

        for (int i=0;i<arr.length;i++){
            for (int j=0;j<arr.length;j++){
                if(arr[i] <arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        printArray(arr);
    }

    static void printArray(int ar[]){
        for(int l:ar)
            System.out.println(l);
    }
}
