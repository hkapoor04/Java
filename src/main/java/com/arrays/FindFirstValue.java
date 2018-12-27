package com.arrays;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Harshit on 9/25/2017.
 */
public class FindFirstValue {

    public static void main(String args[]) {
        int[] arr = {0, 1, 1, 2, 2, 2, 2, 4, 5, 7, 8, 9};
        findFirstRepeating(arr, 2);
    }

    public static void findFirstRepeating(int[] arr, int value) {
        if(arr.length<1){
            System.err.println("Invalid Array");
        }
        int index = -1;
        Set<Integer> hashSet = new HashSet<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            hashSet.add(arr[i]);
            if (arr[i] == value && hashSet.contains(arr[i])) {
                index = i;
            }
        }
        System.out.println(index);
    }
}
