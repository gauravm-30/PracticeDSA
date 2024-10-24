package org.practice.strings;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatedChars {
    public static void main(String[] args){
        String word = "abcartgr";
        String word1 = "Geeksforgeeks";
        String word2 = "GG";
        String word3 = "";
        int longestUniqueCharLength = getLongestUniqueCharLength(word2);
        int longestUniqueCharLength1 = longestUniqueSubstr("abcabd");
        int longestUniqueCharLength2 = getLongestUniqueSubstringLength("GGBB");
    System.out.println(longestUniqueCharLength);
    System.out.println(longestUniqueCharLength1);
    System.out.println(longestUniqueCharLength2);
  }

  // brute force 1
  // find all substring with unique characters
  // find max from them
  private static int getLongestUniqueCharLength(String word) {
        int maxLength = 0;
      //find the substring starting from every index to every index;
        for(int i = 0; i < word.length(); i++) {
            Set<String> substrings = getAllSubstrings(i,word);  // O(n)
            Set<String> subStringsWithUniqueChars = getSubstringsWithUniqueChars(substrings); //O(n^2)
            int maxLengthUniqueChar = getMaxLengthUniqueChar(subStringsWithUniqueChars);
            maxLength = Math.max(maxLength,maxLengthUniqueChar);
        }
        return maxLength;
    }

    private static int getMaxLengthUniqueChar(Set<String> subStringsWithUniqueChars) {
        int length=0;
        for(String word : subStringsWithUniqueChars){
            if(length<word.length()){
                length= word.length();
            }
        }
        return length;
    }

    private static Set<String> getSubstringsWithUniqueChars(Set<String> substrings) {
           Set<String> uniqueCharsSubstring = new HashSet<>();
           for (String subString : substrings){
               if(isUniqueCharsPresent(subString)){
                   uniqueCharsSubstring.add(subString);
               }
           }
           return uniqueCharsSubstring;
    }

    private static Set<String> getAllSubstrings(int beginIndex, String word) {
        Set<String> allSubstrings = new HashSet<>();
        for(int i = beginIndex+1 ; i <=word.length(); i++) {
           String substring = word.substring(beginIndex,i);
           allSubstrings.add(substring);
        }
        return allSubstrings;
    }


    //TC : O(n)
    //SC : O(n)
    private static boolean isUniqueCharsPresent(String word){
        Set<Character> characterSet = new HashSet<>();
        for(int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if(characterSet.contains(ch)){
                return false;
            }else {
                characterSet.add(ch);
            }
        }
        return true;
    }


    //Brute Force Approach 2  using lookup array
    //TC O(n^2)
    public static int longestUniqueSubstr(String s) {
        int n = s.length();
        int res = 0;

        for (int i = 0; i < n; i++) {

            // Initializing all characters as not visited
            boolean[] visited = new boolean[256];

            for (int j = i; j < n; j++) {

                // If current character is visited,
                // Break the loop
                if (visited[s.charAt(j)]) {
                    break;
                }
                else {

                    // Else update the result if this
                    // window is larger, and mark current
                    // character as visited.
                    res = Math.max(res, j - i + 1);
                    visited[s.charAt(j)] = true;
                }
            }
        }
        return res;
    }


    //Approach  3
    //Efficient approach
    //Using sliding window
    //TC O(MaxCHar*N)
    public static int getLongestUniqueSubstringLength(String word){

        int maxLength = 0;
        int leftPointer = 0;
        int rightPointer = 0;
        boolean[] visitedChar = new boolean[256];

        while(rightPointer<word.length()){
            if(!visitedChar[word.charAt(rightPointer)]){
                visitedChar[word.charAt(rightPointer)]=true;
                maxLength = Math.max(maxLength,rightPointer-leftPointer+1);
                rightPointer++;
            }else {
        //If the character is repeated, move left pointer
        //            // to the right and mark visited characters as false
        //            // until the repeating character is no longer part
        //            // of the current window.
        while (visitedChar[word.charAt(rightPointer)]) {
                    visitedChar[word.charAt(leftPointer)]=false;
                    leftPointer++;
                }
            }

        }
        return maxLength;
    }

}
