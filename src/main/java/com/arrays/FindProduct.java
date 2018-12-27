package com.arrays;

public class FindProduct {

    public static void main(String args[]){
        int arr [] = {1,3,4,7};
        for (int i=0;i<arr.length;i++){
            int findSum = 1;
            for (int j=0;j<arr.length;j++){
                findSum = findSum*arr[j];
            }
          int sum = findSum/arr[i];
            System.out.println(sum);
        }

    }
}
