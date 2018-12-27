package com.arrays;

public class FindMultiples {

    static int min = Integer.MAX_VALUE;
    static int n = 200;
    public static void main (String args[]){
        for (int i=n;i>0;i--){
            int remainder = n%i;
            if(remainder == 0){
                int multiplier = n/i;
                    int number = Integer.valueOf(String.valueOf(multiplier)+String.valueOf(i));
                    if(number<min){
                        min = number;
                    }
            }
        }

        System.out.println(min);
    }
}
