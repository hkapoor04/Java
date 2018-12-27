package com.Sorting;

/**
 * Created by Harshit on 9/22/2017.
 */
public class QuickSort {

    private int Partition(int arr[],int si, int li){

        int pivot = arr[li];

        int i=si-1;

        for(int j=si;j<li;j++){
            if(arr[j]<=pivot){
                i++;

                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;

            }
        }

        int temp = arr[i+1];
        arr[i+1] = arr[li];
        arr[li] = temp;


        return i+1;
    }

    private void sort(int arr[],int si, int li){

        if(si<li) {

            int pi = Partition(arr,si,li);

            sort(arr,si,pi-1);
            sort(arr,pi+1,li);
        }

    }


    public static void main (String [] args) {

        int arr[] = {10, 50, 80, 30, 90, 40, 70};

        QuickSort quickSort = new QuickSort();

        int si = 0;

        int li = arr.length -1;

        quickSort.sort(arr,si,li);

        for(int i=0; i<=arr.length -1;i++){

            System.out.println(arr[i] + " ");
        }
    }
}
