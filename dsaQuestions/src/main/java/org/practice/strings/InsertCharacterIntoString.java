package org.practice.strings;

public class InsertCharacterIntoString {
    public static void main(String[] args){
        String s2 = "Gaurav";
    System.out.println(insertCharAtIndex2(1, 'd', s2));
    System.out.println(insertCharSequence(1, "hello", s2));
    }

    private static String insertCharAtEnd(char ch, String word){
        return word+ch;
    }

    private static String insertCharAtIndex(int index, char ch, String word){
        return word.substring(0,index)+ch+word.substring(index);
    }

    private static String insertCharAtIndex2(int index, char ch, String word){
        StringBuilder sb = new StringBuilder(word);
        sb.insert(index,ch);
        return sb.toString();
    }

    private static  String insertCharSequence(int index, String word1, String word2){
        return word2.substring(0,index) + word1 + word2.substring(index);
    }

    private static  String insertCharSequenceV2(int index, String word1, String word2){
        StringBuilder sb = new StringBuilder(word2);
         sb.insert(index,word1);
         return sb.toString();
    }
}

