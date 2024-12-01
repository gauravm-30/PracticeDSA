package org.practice.strings;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveCharacterFromString {
    public static void main(String[] args) {
        String s2 = "asdjflaa23f2f";
        String chars = "[af2]";
        char ch= 'a';
        String s3 = removeAllOccurrenceFrom(ch,s2);
        String s4 = removeDuplicateCharFrom(s2);
        String s5 = removeSetOfCharsFrom(chars,s2);

        System.out.println(s3);
        System.out.println(s4);
        System.out.println(s5);
    }

    private static String removeSetOfCharsFrom(String chars,String s2){
        //regex way

       return s2.replaceAll(chars,"");
//       return s2.replace(chars,"");
    }

    private static String removeAllOccurrenceFrom(char ch, String s2) {
       StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s2.length(); i++) {
            char currChar = s2.charAt(i);
            if(currChar!=ch){
                sb.append(currChar);
            }
        }
       return sb.toString();
    }

    private static String removeAllOccurrenceFromUsingReplace(char ch, String s2) {
                return s2.replace(String.valueOf(ch),"");
    }

    private static String removeCharsUsingIndex(int index,String word){
        //PLease validate the index before using it.
        StringBuilder sb = new StringBuilder(word);
        sb.deleteCharAt(index);
        return sb.toString();
    }

    private static String removeCharUsingIndex2(int index, String word){
        //validate index before using it
        return word.substring(0,index)+word.substring(index+1);
    }





    private static String removeDuplicateCharFrom(String s2){
        StringBuilder sb = new StringBuilder();
        char[] lookUp = new char[s2.length()];
        for (int i = 0; i < s2.length(); i++) {
            char currChar = s2.charAt(i);
            if(!isPresent(currChar,lookUp)){
                sb.append(currChar);
                lookUp[i]=currChar;
            }
        }
        return new String(sb);
    }

    private static boolean isPresent(char currChar, char[] lookUp) {
        for (char c : lookUp) {
            if (currChar == c) {
                return true;
            }
        }
        return false;
    }
}
