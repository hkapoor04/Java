package com.uis.assignment.cs385.week4.diffpairs;


public class DifferencePairs {
	
	/* Sorting the array using quick sort
	 *
	 * @param arr - The integer array
	 * @param low - index of the lowest element
	 * @param high - index of the highest element
	 *
	 */
	private static void sort(int arr[], int low, int high) {

		if(low<high){
			int pi = partition (arr, low, high);

			//-- Recursively sort elements before and after partition
			sort(arr, low, pi-1);
			sort(arr, pi+1, high);
		}
		
	}

	/* This method finds the pairs of elements with specific difference
	 *
	 * @param findPairs - the array of integers
	 * @param diff - the specific difference between two elements
	 */

	public static Pair[] findPairs(int array[], int diff) {

		//-- sorting the array
		sort(array, 0, array.length - 1);

		//-- variable to store the size of array.
		int size = array.length;

		//-- variable to store the key to be searched in the array.
		int matchKey = 0;

		//-- variable to store the index of the matching key in the array
		int matchIndex = -1;

		//-- Initializing the array to store the pairs of integers matching the criteria
		Pair[] pairs = new Pair[size + 1];

		//-- Declaring variable of type Pair
		Pair pair = null;

		for (int i = 0; i < array.length; i++) {

			//-- Calculating the value of key to be searched in array
			matchKey = diff + array[i];

			//-- Calling binarySearch method to find the key in the array
			matchIndex = binarySearch(array, matchKey);

			//-- Checking if the key exists in the array
			if (matchIndex != -1) {

				//-- putting both the integers with matching difference into Pair object
				pair = new Pair(array[i], matchKey);
			} else {

				//-- assigning null in case none of the pairs match the criteria
				pair = null;
			}

			//-- populating the array with all the integers pairs
			pairs[i] = pair;
		}
		return pairs;
	}


	/* This method finds the key in the array
	 *
	 *@param arr - The integer array
	 *@param matchKey - The integer that needs to be looked up in the array
	 */
	static int binarySearch(int arr[], int matchKey) {

		//-- Variable to store the index of the lowest element
		int low = 0;

		//-- Variable to store the index of the highest element
		int high = arr.length - 1;

		//-- Variable to store the index of middle element
		int mid = 0;

		while (low <= high) {

			mid = (low + high) / 2;

			if (arr[mid] == matchKey) {

				return mid;

			} else if (matchKey < arr[mid]) {

				//-- reassigning the index value of the highest element in sub array
				high = mid - 1;
			} else {

				//-- reassigning the index value of the lowest element in sub array
				low = mid + 1;
			}
		}

		//-- returning -1 in case of no match
		return -1;
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
