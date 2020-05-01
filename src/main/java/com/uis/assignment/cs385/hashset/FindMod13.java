package com.uis.assignment.cs385.hashset;

public class FindMod13 {



    public static void main(String[] args) {

        int [] arr = {1342415383, 700056533,330628742, 532139483,  217142585, 2112979549, 207265348, 1631149803 };

        for (int i = 0; i < arr.length; i++) {

            int mod13 = arr[i] % 13;

            System.out.println(mod13);
        }
    }


}
