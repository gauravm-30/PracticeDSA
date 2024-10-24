package org.practice.strings;

public class CountOccurenceOfChar {
    public static void main(String[] args){

    }

    public static  int occurrenceOfChar(char ch , String word){
        int count= 0;
        for(int i = 0; i < word.length(); i++) {
            if(ch==word.charAt(i)){
                count++;
            }
        }
        return count;
    }
}


