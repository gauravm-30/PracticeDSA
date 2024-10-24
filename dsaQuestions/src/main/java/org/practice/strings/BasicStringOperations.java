package org.practice.strings;


public class BasicStringOperations {
    public static void main(String[] args){
        String word = "Gaurav";
        modifySingleCharacterInString('a','b',word);
        deleteSingleCharacterFromString('v',word);
    }

    private static void modifySingleCharacterInString(char a, char replacement ,String word) {
        word.replace(a,replacement);
    }

    private static void deleteSingleCharacterFromString(char v, String word) {
    }

    public static void insert(String s, String ch, int k) {
        // Inserts ch at kth index of str
        StringBuilder sb = new StringBuilder(s);
        sb.insert(k, ch);
        String modifiedString = sb.toString();
        System.out.println("Modified String: " + modifiedString);
    }
}
