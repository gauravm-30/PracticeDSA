package org.practice.strings;


public class BasicStringOperations {
    public static void main(String[] args){
        String word = "Gaurav";
        char[] wordChar = word.toCharArray();
        modifyStringUsingCharArray('a','b',wordChar);
        modifySingleCharacterInString(' ','b',word);
        deleteSingleCharacterFromString('v',word);
        insert("Gaurav","c",5);
    }

    private static void modifyStringUsingCharArray(char a, char b, char[] wordChar) {
        for(int i = 0; i < wordChar.length; i++) {
            if(wordChar[i]=='a'){
                wordChar[i]='b';
            }
        }
        String s2 = new String(wordChar);
    }

    //replaces all 'a' with 'b'
    private static void modifySingleCharacterInString(char a, char replacement ,String word) {
        word.replace(a,replacement);
    }

    private static void deleteSingleCharacterFromString(char v, String word) {
        word.replace(String.valueOf(v),"");
    }

    private static String deleteCharUsingCharArray(char ch, String word){
        StringBuilder sb = new StringBuilder();
        for(char ch1: word.toCharArray()){
            if(ch1!=ch){
              sb.append(ch1);
            }
        }
        return sb.toString();
    }

    public static void insert(String s, String ch, int k) {
        // Inserts ch at kth index of str
        StringBuilder sb = new StringBuilder(s);
        sb.insert(k, ch);
        String modifiedString = sb.toString();
        System.out.println("Modified String: " + modifiedString);

    }
}
