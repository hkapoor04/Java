package com.uis.assignment.cs385.week4.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import com.uis.assignment.cs385.week4.diffpairs.DifferencePairs;
import com.uis.assignment.cs385.week4.diffpairs.Pair;
import com.uis.assignment.cs385.week4.utility.ArrayUtils;

public class FileTest {
	
	private static void closeScanner(Scanner s) {
		if(s != null) {
			s.close();
		}
	}
	
	private static int numberOfLines(String filepath) {
		Scanner fileIn = null;
		int count = 0;
		try {
			fileIn = new Scanner(new File(filepath));
			while(fileIn.hasNextLine()) {
				count += 1;
				fileIn.nextLine();
			}
		} catch(FileNotFoundException e) {
			System.err.println(String.format("File not found: %s\n%s", filepath, e.getMessage()));
			closeScanner(fileIn);
			System.exit(1);
		} catch(Exception e) {
			e.printStackTrace();
			closeScanner(fileIn);
			System.exit(2);
		} finally {
			closeScanner(fileIn);
		}
		return count;
	}

	public static void main(String[] args) throws FileNotFoundException{
		int diff = 13;
		String filepath = "nums.txt";
		int numberCount = numberOfLines(filepath);
		int arr[] = new int[numberCount];
		Scanner fileIn = new Scanner(new File(filepath));
		for(int i = 0; i < arr.length; i++) {
			arr[i] = fileIn.nextInt();
		}
		ArrayUtils.printIntegerArray(arr);
		Pair pairs[] = DifferencePairs.findPairs(arr, diff);
		ArrayUtils.printObjectArray(pairs);
		fileIn.close();
	}

}
