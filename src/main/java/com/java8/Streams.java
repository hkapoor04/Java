package com.java8;

import java.util.Arrays;
import java.util.List;

public class Streams {

    public static void main(String args[]) {


    List<String> alphabets = Arrays.asList("abc", "def", "ghi", "");
    Long count = alphabets.stream().filter(string -> string.isEmpty()).count();

    System.out.println(count);
}

}
