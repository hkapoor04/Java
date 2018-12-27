package com.arrays;

import java.util.HashMap;
import java.util.Hashtable;

/**
 * Created by Harshit on 9/16/2017.
 */
public class CheckForPair {

    /*private static void findPair(int key){

        int arr[] = {1,2,3,4,5};

        int sum =0;

        for (int i=0 ; i<arr.length ; i++) {

            for (int j = i ; j < arr.length; j++) {

                sum = arr[i] + arr[j];

                if (sum == key && arr[i]!=arr[j]){

                    System.out.println(arr[i]);
                    System.out.println(arr[j]);
                }

            }
        }
    }*/

    public static void main(String args[]) {

        //findPair(6);

        int arr[] = {1, 2, 3, 4, 5};

        Hashtable<Integer, Integer> ht = new Hashtable<Integer, Integer>();
        for (int i = 0; i < arr.length; i++) {
            ht.put(arr[i], i);
        }

        int counter = 0;
        for (int j = 0; j < arr.length; j++) {

            if (ht.containsKey(6 - arr[j])) {
                counter++;
                if (6 - arr[j] == arr[j]) {
                    counter--;
                }
            }
        }

        System.out.println(counter / 2);
    }
}
