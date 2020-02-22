package com.Sorting;

public class Insertion {

    public static void main (String args[]){
        int temp = 0;
        int [] array = {7,6,3,5,2,4,8};
        for (int i = 0; i <array.length ; i++) {
            for (int j = i+1; j >=0 ; j--) {
                if(array[i]> array[j]) {
                    temp = array[i];
                    array[j] = array[i];
                    array[j] = temp;
                }
                System.out.println(array[j]);
            }

        }

    }
}
