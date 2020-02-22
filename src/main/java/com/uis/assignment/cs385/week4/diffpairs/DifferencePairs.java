package com.uis.assignment.cs385.week4.diffpairs;

import com.uis.assignment.cs385.week4.utility.ArrayUtils;

public class DifferencePairs {
	
	// Implement your sorting algorithm here.  Must be either
	//  * merge sort
	//  * quick sort
	//  * radix sort
	private static void sort(int arr[], int low, int high) {

		if(low<high){
			int pi = partition (arr, low, high);

			//-- Recursively sort elements before
			//-- partition and after partition
			sort(arr, low, pi-1);
			sort(arr, pi+1, high);
		}
		
	}

	public static Pair[] findPairs(int array[], int diff) {

		sort(array, 0, array.length -1);
		return null;
	}

	/*
	 * This method takes pivot as the last element in the array
	 *
	 * and puts all element lesser than pivot to the left of pivot
	 *
	 * and greater than pivot to the right of pivot
	 */
	private static int partition(int arr[], int low, int high)
	{
		int pivot = arr[high]; //-- pivot is the last element of the array
		int i = (low-1); //-- index of smaller element
		for (int j=low; j<high; j++)
		{
			//-- Checking current element smaller than the pivot
			if (arr[j] < pivot)
			{
				i++;

				//-- swapping arr[i] and arr[j]
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}

		//-- swap arr[i+1] and arr[high] (or pivot)
		int temp = arr[i+1];
		arr[i+1] = arr[high];
		arr[high] = temp;

		return i+1;
	}

}
