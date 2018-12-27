package com.StringOperations;

/**
 * Created by Harshit on 9/16/2017.
 */
public class ReverseString {

    public static void main(String args []) {
        String a = "test";
        String b="";
        for(int i=a.length()-1; i>=0;i--){
            b = b + a.charAt(i);

        }

        System.out.println(b);
        char arr [] = a.toCharArray();
        System.out.println(a.length());

    }


}
