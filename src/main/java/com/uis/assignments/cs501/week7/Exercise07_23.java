package com.uis.assignments.cs501.week7;

public class Exercise07_23 {

    /*
     * Main Method
     */

    public static void main(String args[]) {

        //-- Declare and initialize array for student number
        int[] students = new int[101];

        //-- Declare and initialize array for locker number
        int[] lockers = new int[101];

        //-- Declare and initialize array for locker status
        boolean[] lockerStatus = new boolean[101];

        //-- Populating students array from 1 to 100 where each array element shows student number
        for (int s = 1; s <= students.length - 1; s++) {
            students[s] = s;
        }

        //-- Populating locker array from 1 to 100 where each array element shows locker number
        for (int l = 1; l <= lockers.length - 1; l++) {
            lockers[l] = l;
        }

        //-- Iterating each element of student array
        for (int s = 1; s <= students.length - 1; s++) {

            //-- Iterating through locker array for each student
            for (int l = s; l <= lockers.length - 1; l++) {

                //-- Checking that every student changes the locker status for locker number == student number
                if (l % s == 0) {

                    //-- Changing the status of the locker in case locker number = student number
                    lockerStatus[l] = !lockerStatus[l];
                }

            }

        }

        //-- Iterating through the locker status array to print the result
        for (int l = 1; l <= lockerStatus.length - 1; l++) {

            //-- Check the open lockers
            if (lockerStatus[l]) {

                //-- Display the open locker numbers
                System.out.println("Locker " + l + " is open");
            }
        }

    }
}
