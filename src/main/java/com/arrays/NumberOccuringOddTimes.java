package com.arrays;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;

/**
 * Created by Harshit on 9/16/2017.
 */
public class NumberOccuringOddTimes {

    public static void main(String args[]) {
        int arr[] = {1, 1, 2, 2, 2};

        Set<Integer> st = new HashSet<>();
        int counter = 0;
        for (int i = 0; i < arr.length; i++) {
            if (st.contains(arr[i])) {
                counter++;
            }
            if(!st.contains(arr[i])){
                counter =0;
            }
            st.add(arr[i]);

            if (counter % 2 != 0) {

                System.out.println(arr[i]);

            }
        }






            /*int counter =0;
            for (int j=0;j<arr.length;j++){
                if(arr[i] == arr[j]){
                    counter ++;


                }
            }
            */

    }

}
