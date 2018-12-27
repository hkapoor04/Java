package com.StringOperations;

import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDuplicateFromString {

    public static void main (String args[]){
        String dup = "AABBCD";
        char arr[] = dup.toCharArray();
        Set<Character> finalSet = new LinkedHashSet<Character>();
        for (int i =0;i<arr.length;i++){
            finalSet.add(arr[i]);
        }
        StringBuilder sb = new StringBuilder();
        finalSet.forEach( s ->
                sb.append(s)
        );

        System.out.println(sb);
    }
}
