package org.practice.strings;


import java.util.LinkedHashSet;
import java.util.Set;

public class CheckRotatedString {
    public static void main(String[] args){
        String s1 = "abac";
        String s2 = "abac";
        Set<String> rotatedStringSet = getAllRotatedStrings(s1);
        boolean bo = checkIsRotatedStringV1(s2,rotatedStringSet);
        boolean bo2=checkIsRotatedStringV2(s1,s2);
        System.out.println(rotatedStringSet);
        System.out.println(bo);
        System.out.println(bo2);
    }

    //brute force approach
    private static boolean checkIsRotatedStringV1(String s2, Set<String> rotatedStringSet) {
        return rotatedStringSet.contains(s2);
    }

   //Imp function
    private static Set<String> getAllRotatedStrings(String s1) {
        Set<String> rotatedStringSet = new LinkedHashSet<>();
        for(int i = 0; i < s1.length(); i++) {
            String rotatedString = s1.substring(i) + s1.substring(0,i);
                rotatedStringSet.add(rotatedString);
        }
        return rotatedStringSet;
    }

    //Second approach is to concatenate the s1 string to itself and then find s2 string in s1 .
    // If it is present means s2 is rotated string of s1.
    private static boolean checkIsRotatedStringV2(String input , String target){
        input = input.concat(input);
        return input.contains(target);
    }
}
