package com.arrays;

public class ClosestMatch {
    public int findClosestValue(int [] arr,int number){
        int index = 0;
        int max_value = Integer.MAX_VALUE;

        for(int i=0;i<arr.length;i++){
            int difference = Math.abs(arr[i] - number);

            if(difference ==0){
                index =i;
            }

            if(difference !=0 && difference<max_value){
                max_value = difference;
                index = i;
            }
        }

        return arr[index];

    }


    public static void main(String args[]){
        int arr[] = {2,5,6,7,8,8,9};
        ClosestMatch closestMatch = new ClosestMatch();
        int inputNumber = 4;
        int closestValue  = closestMatch.findClosestValue(arr,inputNumber);


        System.out.println(Integer.parseInt("x"));
    }
}
