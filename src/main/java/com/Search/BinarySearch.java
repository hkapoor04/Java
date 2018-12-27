package com.Search;

/**
 * Created by Harshit on 9/22/2017.
 */
public class BinarySearch {

    private int Search(int arr[],int si, int li, int value){
        if(si<=li){
            int mid = si + (li-si)/2;

            if(arr[mid] == value)
                return mid;

            if(arr[mid]>value)

            return Search(arr,si,mid-1,value);

            return Search(arr,mid+1,li, value);

        }

        return -1;

    }


    public static void main (String args[]){

        int arr[] = {1,2,3,4,5,6,7};

        BinarySearch binarySearch = new BinarySearch();

        int si =0;
        int li = arr.length-1;
        int value = 5;

        int index = binarySearch.Search(arr,si,li,value);

        System.out.println("Found at index   " + index);
    }
}
