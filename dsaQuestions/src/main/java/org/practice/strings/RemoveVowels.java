package org.practice.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class RemoveVowels {
    public static void main(String[] args) {
        String s2= "Welcome to geeksforgeeks";
        String s3 =removeVowelsFromStringV1(s2);
        String s4 =removeVowelsFromStringV2(s2);
        String s5 =removeVowelsFromStringV3(s2);
        System.out.println(s3);

    }


    private static String removeVowelsFromStringV2(String s2) {
        return s2.replaceAll("[aeiouAEIOU]","");
    }

    private static String removeVowelsFromStringV1(String s2) {
        ArrayList<Character> characterList = getCharacterListFrom(s2);
        //Whenever you want to remove something from the list use iterator
        Iterator<Character> characterIterator = characterList.iterator();
        while (characterIterator.hasNext()){
            Character ch = characterIterator.next();
            if(isVowel(ch)){
                characterIterator.remove();
            }
        }

        StringBuilder sb = getStringBuilderFrom(characterList);
        return new String(sb);

    }

    private static String removeVowelsFromStringV3(String s2) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s2.length(); i++) {
            char ch = s2.charAt(i);
            if(!isVowel(ch)){
                sb.append(ch);
            }
        }
        return new String(sb);

    }



    private static StringBuilder getStringBuilderFrom(ArrayList<Character> characterList) {
        StringBuilder sb = new StringBuilder();
        for (var character : characterList){
                sb.append(character.charValue());
        }
        return sb;
    }

    private static ArrayList<Character> getCharacterListFrom(String s2) {
        ArrayList<Character> characters = new ArrayList<>();
        for (int i = 0; i < s2.length(); i++) {
            characters.add(s2.charAt(i));
        }
        return characters;
    }

    private static boolean isVowel(char ch) {
        switch (ch){
            case 'A','E','I','O','U','a','e','i','o','u' :
                return true;
        }
        return false;
    }
}
