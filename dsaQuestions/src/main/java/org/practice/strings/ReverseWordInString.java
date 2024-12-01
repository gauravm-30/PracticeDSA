package org.practice.strings;

//https://leetcode.com/problems/reverse-words-in-a-string/description/
public class ReverseWordInString {
    public static void main(String[] args){
        String s = " the  sky  is        blue ";
        System.out.println(reverseWordInString(s));

    }
//Time Complexity - O(n)
    //Space Complexity - O(n)
    private static String reverseWordInString(String s) {
        //removed leading and trailing spaces
        String s2= s.strip();
        String[] strs = s2.split("\\s+");

        StringBuilder sb = new StringBuilder();
        //important
        for (int i = strs.length-1; i >0; i--) {
            sb.append(strs[i]).append(" ");
        }
        return sb.append(strs[0]).toString();
    }
}
