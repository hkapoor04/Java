package com.Sorting;

/**
 * Created by Harshit on 9/22/2017.
 */
public class MergeSort {

    private void Merge(int arr[],int si, int mid, int li){

        int l1 = mid -si +1;
        int l2 = li-mid;
        int i,j;

        int L[] = new int[l1],R[]= new int[l2];

        for( i=0;i<l1;i++){
            L[i] = arr[i];
        }

        for( j=0;j<l2;j++){
            R[j] = arr[j+mid+1];
        }

        while(i< l1 && j<l2){
            if(L[i]<R[j]){
                arr[si] = L[i];
                i++;
            }
            else {
                arr[si] = R[j];
                j++;
            }
            si++;

        }
    }

    private void Sort(int arr[], int si,int li){

        if(si<li){
            int mid = si+(li-si)/2;

            Sort(arr,si,mid);
            Sort(arr,mid+1,li);

            Merge(arr,si,mid,li);
        }

    }

    public static void main(String args []){

        int arr[] = {10, 50, 80, 30, 90, 40, 70};
        MergeSort mergeSort = new MergeSort();

        int si = 0;
        int li = arr.length-2;
        mergeSort.Sort(arr,si,li);

        for (int i=0;i<=arr.length-1;i++){
            System.out.println(arr[i]);
        }
    }
}
