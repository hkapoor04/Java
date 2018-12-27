package com.arrays;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CombinationsOfString {

    String str = "ABC";
    char temp;


    List<String> q = new LinkedList<String>();


    public List<String> FindCombinations(String s){
        String tempCombination;
        String combination;
        for(int i=0;i<str.length();i++){
            tempCombination = Swap(s,i,str.length()-1);
            q.add(tempCombination);

            System.out.println(tempCombination);
            }
            /*for(int j=0;j<str.length();j++){
                combination = Swap(q.get(j),j,str.length()-1);
                q.add(combination);
                System.out.println(combination);

            }*/
            return q;
    }

    public String Swap(String inputString,int startIndex, int lastIndex){

        char arr[]= inputString.toCharArray();
        temp = arr[startIndex];
        arr[startIndex] = arr[lastIndex];
        arr[lastIndex] = temp;

        return String.valueOf(arr);
    }

    public static void main (String args[]){

        CombinationsOfString combinationsOfString = new CombinationsOfString();
        List<String> finalString = combinationsOfString.FindCombinations(combinationsOfString.str);
        //finalString.forEach(s -> System.out.println(s));
    }

}
