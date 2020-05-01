package com.uis.assignment.cs385.hashset;

import java.util.*;


public class HashAssignment {
    public static void main(String args[]) {
        List<List<Integer>> intLists = new LinkedList<>();

        intLists.add(new ArrayList<Integer>(Arrays.asList(3, 4, 9, 8, 12, 15, 7, 13)));
        intLists.add(new ArrayList<Integer>(Arrays.asList(15, 24, 50, 12, 3, 9)));
        intLists.add(new ArrayList<Integer>(Arrays.asList(78, 65, 24, 13, 9, 3, 12)));
        intLists.add(new ArrayList<Integer>(Arrays.asList(15, 78, 14, 3, 2, 9, 44, 12)));

        List<Integer> intResult = findCommonElements(intLists);

        System.out.println("Common elements of the integer list");
        System.out.println(intResult + "\n");

        List<List<String>> stringLists = new LinkedList<>();

        stringLists.add(new ArrayList<String>(Arrays.asList("a", "b", "d", "c", "h", "e")));
        stringLists.add(new ArrayList<String>(Arrays.asList("g", "b", "e", "j", "u", "z", "h", "d")));
        stringLists.add(new ArrayList<String>(Arrays.asList("y", "p", "b", "d", "h")));

        List<String> stringResult = findCommonElements(stringLists);

        System.out.println("Common elements of the string list");
        System.out.println(stringResult);
    }

    public static <T> List<T> findCommonElements(List<List<T>> collections) {

        Set<T> commonSet = new HashSet<>(); //-- Declaring a HashSet to store the common elements
        Set<T> addSet; //-- Declaring a HashSet to store the array from collection

        if(collections.size() == 1){ //-- This is the case when there is only one array in the collection
            commonSet.addAll(collections.get(0));
        }

        for (int i = 1; i < collections.size(); i++) { //-- Iterating through the outer list/ number of collections

            addSet = new HashSet<>(collections.get(i-1)); //-- storing the previous array from collection in the hashset

            for (int j = 0; j < collections.get(i).size(); j++) { //-- Iterating through each array element

                if (i == 1) {
                    if (addSet.contains(collections.get(i).get(j))) { //-- Checking the contents of HashSet with the array at position 1
                        commonSet.add(collections.get(i).get(j)); //-- Adding the common elements to commonSet
                    }
                } else {
                    //-- Continue processing for the arrays at positions 2 and above in the collection
                    if (commonSet.contains(collections.get(i).get(j))) { //-- Checking the content of HashSet against the elements in the common HashSet
                        commonSet.add(collections.get(i).get(j)); //-- Adding the common elements to the common HashSet
                    } else {
                        //-- removing the entries from the common HashSet which do not match between common and the original HashSet
                        Iterator<T> e = commonSet.iterator(); //-- Declaring iterator of type common HashSet
                        addSet = new HashSet<>(collections.get(i)); //-- Populating the set with current array from collection
                        while (e.hasNext()) { //-- Iterating through the common HashSet
                            if (!addSet.contains(e.next())) {
                                e.remove(); //-- Removing the entries that do not match
                            }
                        }
                    }
                }
            }
        }
        return new ArrayList<>(commonSet); //-- Returning the common HashSet entries as an ArrayList
    }
}

