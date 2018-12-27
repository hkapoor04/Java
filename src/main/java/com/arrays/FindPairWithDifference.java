package com.arrays;

import java.util.Hashtable;

public class FindPairWithDifference {

    public static void main (String args[]){

        int arr[] = {1,3,5,6,8,11};

        Hashtable<Integer,Integer> ht = new Hashtable<Integer, Integer>();

        for (int i=0;i<arr.length;i++){

            ht.put(arr[i],i);
        }
        int counter = 0;
        for (int j=0; j<arr.length;j++){

            if(ht.containsKey(arr[j]+2)){
                counter++;
            }
        }

        System.out.println(counter);


    }
}
