package org.practice.strings;

import java.util.*;

public class LongestSubstringWithKUniqueCharacters {
    public static void main(String[] args){
        String s = "adaaadco";
        int k = 3;
        String longestSubstring = getLongestSubstringWithKUniqueChars("",k);
    System.out.println(longestSubstring.length());
    }

    //brute force approach
    //O(n^3)
    private static String getLongestSubstringWithKUniqueChars(String s, int k) {
        Set<String> kUniqueCharsString = new HashSet<>();
        for(int i = 0; i < s.length(); i++) {
            for(int j = i+1; j < s.length(); j++) {
                String substring = s.substring(i,j);
                if(hasKUniqueChars(substring,k)){
                    kUniqueCharsString.add(substring);
                }
            }
        }
        String[] strings = kUniqueCharsString.toArray(new String[0]);
        kUniqueCharsString = null;
        String result  = "";
        for (String string : strings) {
            if (result.length() < string.length()) {
                result = string;
            }
        }
        return result;
    }


    private static boolean hasKUniqueChars(String input,int k){
        Set<Character> uniqueChar = new HashSet<>();
         for(char ch : input.toCharArray()){
             uniqueChar.add(ch);
         }
       return uniqueChar.size() == k;
   }

   //sliding window approach
   public static int longestSubstring(String s , int k){

        //two pointer of window, i ==start pointer and j == end pointer
        int i = 0;
        int j = 0;
        Map<Character, Integer> charFreq = new HashMap<>();

        int maxSubstrLength = -1;

        while(j<s.length()){
            addCharInMap(charFreq,s.charAt(j));

            while(charFreq.size()>k){
                decreaseCharFreq(charFreq,s.charAt(i));
                if(charFreq.get(s.charAt(i))==0){
                    charFreq.remove(s.charAt(i));
                }
                i++;
            }

            if(charFreq.size()==k){
                int lengthOfSubstr = j-i+1; // basically window length
                maxSubstrLength = Math.max(maxSubstrLength,lengthOfSubstr);
            }
            j++;
        }
        return maxSubstrLength;
   }

    private static void addCharInMap(Map<Character, Integer> charFreq,char ch) {
        if(!charFreq.containsKey(ch)){
            charFreq.put(ch,1);
        }else {
            charFreq.put(ch,charFreq.get(ch)+1);
        }
    }

    private static void decreaseCharFreq(Map<Character, Integer> charFreq,char ch){
        if(charFreq.containsKey(ch)){
            charFreq.put(ch,charFreq.get(ch)-1);
        }
    }
}
