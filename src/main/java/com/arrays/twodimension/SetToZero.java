package com.arrays.twodimension;

public class SetToZero {
    public static void main(String args[]) {
        int arr[][] = {{1, 2, 3}, {4, 5, 6}, {7, 8, 0}};
        int rowSize = arr.length;
        int colSize = arr[0].length;
        boolean[] rowZero = new boolean[rowSize];
        boolean[] colZero = new boolean[colSize];
        for (int row = 0; row < rowSize; row++) {
            for (int col = 0; col < colSize; col++) {
                if (arr[row][col] == 0) {
                    rowZero[row] = true;
                    colZero[col] = true;
                }
            }
        }
        for (int row = 0; row < rowSize; row++) {
            if (rowZero[row]) {
                for (int col = 0; col < colSize; col++) {
                    arr[row][col] = 0;
                }
            }
        }
        for (int col = 0; col < colSize; col++) {
            if (colZero[col]) {
                for (int row = 0; row < rowSize; row++) {
                    arr[row][col] = 0;
                }
            }
        }
        for(int row =0;row<rowSize;row++){
            for(int col =0;col<colSize;col++){
                System.out.println(arr[row][col]);
            }
        }

    }

}
