package org.practice.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SortStringLexicographically {
    public static void main(String[] args){
        List<String>  stringList =new ArrayList<>(List.of("Gaurav", "Hello", "Dog", "Zebra"));
        String[] arr = {"Gaurav", "Hello", "Dog", "Zebra"};

        Comparator<String> stringComparator = (s1,s2)->{
            return s1.compareTo(s2);
        };

        Arrays.sort(arr,stringComparator);

        for(String  s : arr){
      System.out.println(s);
        }
    stringList.sort(stringComparator);
    System.out.println(stringList);
    }


}
