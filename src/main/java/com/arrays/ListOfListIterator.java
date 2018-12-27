package com.arrays;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

public class ListOfListIterator {
    public static void main(String args[]) {
        ListOfListIterator listOfListIterator = new ListOfListIterator();
        List<List<Integer>> nestedList = asList(
                asList(1, 3),
                asList(1, 1),
                asList(3, 1));

        List<List<Integer>> outputList = new ArrayList<>();
        nestedList.forEach(obj -> listOfListIterator.findSquareSum(obj, outputList));
    }

    private List<List<Integer>> findSquareSum(List<Integer> valueList, List<List<Integer>> outputList) {
        int sum = valueList.get(0) + valueList.get(1);
        if (sum < 3) {
            outputList.add(valueList);
        }
        return outputList;
    }
}
