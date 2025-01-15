package org.practice.arrays.slidingwindow.variablesize;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/minimum-window-substring/description/
public class MinimumWindowSubstring {

    public static void main(String[] args){
        String s = "ADOBECODEBANC";
        String t ="ABC";
        String s1 = "AAAA";
        String t1="AA";
    System.out.println(minWindowSubstring(s1, t1));
    }


    //Brute Force Approach
    //O(n^3)
    //The brute-force approach to finding the minimum window substring
    // involves checking all possible substrings of the input string s
    // to see if they contain all the characters of the target string t.
    public static String minWindow(String s, String t) {
        if (s == null || t == null || s.length() == 0 || t.length() == 0 || s.length() < t.length()) {
            return "";
        }

        int minLen = Integer.MAX_VALUE;
        String minWindow = "";

        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                String sub = s.substring(i, j + 1);
                if (containsAllChars(sub, t)) {
                    if (sub.length() < minLen) {
                        minLen = sub.length();
                        minWindow = sub;
                    }
                }
            }
        }

        return minWindow;
    }

    //Very important functions of string
    private static boolean containsAllChars(String s, String t) {
        Map<Character, Integer> tMap = new HashMap<>();
        Map<Character, Integer> sMap = new HashMap<>();

        for (char c : t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }

        for (char c : s.toCharArray()) {
            sMap.put(c, sMap.getOrDefault(c, 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : tMap.entrySet()) {
            char key = entry.getKey();
            int value = entry.getValue();
            if (!sMap.containsKey(key) || sMap.get(key) < value) {
                return false;
            }
        }
        return true;
    }

    //Sliding window approach
    //O(n)
    //https://www.youtube.com/watch?v=3Bp3OVD1EGc
    //https://youtu.be/26E3K8Njm7M
    public static String minWindowSubstring(String s, String t){
        if(s==null || t==null || s.isEmpty() || t.isEmpty() || s.length()<t.length()){
            return "";
        }
        Map<Character, Integer> charFreqMap = new HashMap<>();

        //storing all chars of t
        for (char ch : t.toCharArray()){
            if(!charFreqMap.containsKey(ch)){
                charFreqMap.put(ch,1);
            }else {
                charFreqMap.put(ch,charFreqMap.get(ch)+1);
            }
        }

        int uniqueCharCount = charFreqMap.size();
        //window start end variable
        int i=0,j=0;

        int minWindowSize=Integer.MAX_VALUE;

        int startI = -1;

        //sliding window approach start
        while(j<s.length()){
            //Expansion Phase
            char ch = s.charAt(j);
            if(charFreqMap.containsKey(ch)){
                charFreqMap.put(ch,charFreqMap.get(ch)-1);
                if(charFreqMap.get(ch)==0){
                    uniqueCharCount--;
                }
            }

            //Shrinking Phase
            while (uniqueCharCount==0){
                //start shrinking the window
                int currentWindowSize = j-i+1;

                if(minWindowSize>currentWindowSize){
                    minWindowSize = currentWindowSize;
                    startI=i;
                }

                ch = s.charAt(i);
                if(charFreqMap.containsKey(ch)){
                    charFreqMap.put(ch, charFreqMap.get(ch)+1);
                    if(charFreqMap.get(ch)>0){
                        uniqueCharCount++;
                    }
                }
                i++;
            }
            j++;
        }

        if(startI==-1){
            return "";
        }
        return s.substring(startI,startI+minWindowSize);

    }

}
