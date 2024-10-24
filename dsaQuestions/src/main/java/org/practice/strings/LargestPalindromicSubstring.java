package org.practice.strings;


import java.util.HashSet;
import java.util.Set;

public class LargestPalindromicSubstring {
    public static void main(String[] args){
        String word = "qwertyytr";
    System.out.println(largestPalindromicSubstring(word));
    }

    //Brute force approach
    public static String largestPalindromicSubstring(String word){
     //first get all the palindromic substring from the given word
        //find max length substring
        Set<String> allSubstrings = getAllSubstrings(word);
        Set<String> getPalindromicStringOnly = getPalindromicString(allSubstrings);
        return getMaxLengthPalindromicString(getPalindromicStringOnly);

    }

    private static Set<String> getPalindromicString(Set<String> allSubstrings) {
        Set<String> palindromicString = new HashSet<>();
        for (String string : allSubstrings){
            if(isPalindrome(string)){
                palindromicString.add(string);
            }
        }
        return palindromicString;
    }

    private static boolean isPalindrome(String word) {
        int i = 0;
        int j = word.length()-1;
        while(i<j){
            if(word.charAt(i)!=word.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    private static String getMaxLengthPalindromicString(Set<String> allSubstrings) {
        String maxLengthPalindromicString = "" ;
        for(String word : allSubstrings){
            if(maxLengthPalindromicString.length()<word.length()){
                maxLengthPalindromicString=word;
            }
        }
        return maxLengthPalindromicString;
    }

    private static Set<String> getAllSubstrings(String word) {
        Set<String> subStringSet = new HashSet<>();
        for(int i = 0; i < word.length(); i++) {
            for(int j = i+1; j <= word.length() ; j++) {
                String subString = word.substring(i,j);
                subStringSet.add(subString);
            }
        }
        return subStringSet;
    }
}
