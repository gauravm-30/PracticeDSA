package org.practice.strings;

//https://leetcode.com/problems/group-anagrams/description/
public class PrintAnagramsTogether {
    public static void main(String[] args){

    System.out.println(getFrequencyString("input"));
    }

    public static String getFrequencyString(String input){

        int[] freqChar = new int[26];
        for(char ch:input.toCharArray()){
            freqChar[ch-'a']++;
        }
        StringBuilder sb = new StringBuilder();

        char ch = 'a';
    for (int i = 0; i < freqChar.length; i++) {
        sb.append(ch);
        sb.append(freqChar[i]);
        ch++;
    }
    return sb.toString();
    }
}

