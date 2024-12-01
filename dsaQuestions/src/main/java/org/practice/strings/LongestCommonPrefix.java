package org.practice.strings;


import java.util.Arrays;
import java.util.Comparator;

//https://leetcode.com/problems/longest-common-prefix/description/
public class LongestCommonPrefix {
    public static void main(String[] args){
        String[] strs = {"flower","flow","flight"};
    System.out.println(longestCommonPrefix(strs));
    }

    /*
    * The reason why we sort the input array of strings and compare the first and last strings is that
    * the longest common prefix of all the strings must be a prefix of the first string and
    * a prefix of the last string in the sorted array.
    * This is because strings are ordered based on their alphabetical order (Lexicographical order).
      For example, consider the input array of strings {"flower", "flow", "flight"}.
      * After sorting the array, we get {"flight", "flow", "flower"}.
      * The longest common prefix of all the strings is "fl", which is located at the beginning of the first string "flight" and the second string "flow".
      * Therefore, by comparing the first and last strings of the sorted array, we can easily find the longest common prefix.
    * */
    private static String longestCommonPrefix(String[] strs) {
        //check if it has only 1 string
        if(strs.length==0){
            return "";
        }

        if(strs.length==1){
            return strs[0];
        }
        Comparator<String> stringComparator = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return -s1.compareTo(s2);
            }
        };
    Arrays.sort(strs,stringComparator);
    String firstStr = strs[0];
    String lastStr = strs[strs.length-1];
    return getPrefix(firstStr,lastStr);

    }

    private static String getPrefix(String firstStr, String lastStr) {
        StringBuilder sb  = new StringBuilder();
        int i = 0;
        int j = 0;
        while(i<firstStr.length() && j<lastStr.length()){
            if(!(firstStr.charAt(i)==lastStr.charAt(i))){
                break;
            }
            sb.append(firstStr.charAt(i));
            i++;
            j++;

        }
        return sb.toString();
    }
}
