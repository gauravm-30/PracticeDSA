package org.practice.strings;

import java.util.*;

public class PrintDuplicateCharacter {
    public static void main(String[] args) {
        String s2 = "afkj3aadr3kvscc";
        //considering no space is there in string or remove whitespace if there
        String s3 = getDuplicateCharactersFrom(s2);
        String s4 = getDuplicateCharactersOrderWiseFrom(s2);
        String s5 = getDuplicateCharactersSortedOrderFrom(s2);
        System.out.println(s3);
        System.out.println(s4);
        System.out.println(s5);
    }

    private static String getDuplicateCharactersSortedOrderFrom(String s2) {
        Map<Character, Integer> freqMap =getSortedOrderFreqMapOfCharactersFrom(s2);
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<Character,Integer> freqEntry : freqMap.entrySet()){
            if(freqEntry.getValue()>1){
                sb.append(freqEntry.getKey());
            }
        }
        return new String(sb);


    }

    private static Map<Character, Integer> getSortedOrderFreqMapOfCharactersFrom(String s2) {
        //Sort based on the key
        //Since key is of Character type so we need to provide the Character comparator
        Comparator<Character> characterComparator = (c1,c2)->{
            if(c1.charValue()<c2.charValue()){
                return 1;
            }else if(c1.charValue()==c2.charValue()){
                return 0;
            }else {
                return -1;
            }
        };
        Map<Character, Integer> freqMap = new TreeMap<>(characterComparator);
        for (int i = 0; i < s2.length(); i++) {
            char ch = s2.charAt(i);
            if (!freqMap.containsKey(ch)){
                freqMap.put(ch,1);
            }else {
                freqMap.put(ch,freqMap.get(ch)+1);
            }
        }
        return freqMap;
    }

    private static String getDuplicateCharactersOrderWiseFrom(String s2) {
            Map<Character, Integer> freqMap =getOrderedFreqMapOfCharactersFrom(s2);
            StringBuilder sb = new StringBuilder();
            for(Map.Entry<Character,Integer> freqEntry : freqMap.entrySet()){
                if(freqEntry.getValue()>1){
                    sb.append(freqEntry.getKey());
                }
            }
            return new String(sb);

        
    }

    private static Map<Character, Integer> getOrderedFreqMapOfCharactersFrom(String s2) {
        Map<Character, Integer> freqMap = new LinkedHashMap<>();
        for (int i = 0; i < s2.length(); i++) {
            char ch = s2.charAt(i);
            if (!freqMap.containsKey(ch)){
                freqMap.put(ch,1);
            }else {
                freqMap.put(ch,freqMap.get(ch)+1);
            }
        }
        return freqMap;
    }

    private static String getDuplicateCharactersFrom(String s2) {
        Map<Character, Integer> freqMap =getFreqMapOfCharactersFrom(s2);
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<Character,Integer> freqEntry : freqMap.entrySet()){
            if(freqEntry.getValue()>1){
                sb.append(freqEntry.getKey());
            }
        }
        return new String(sb);

    }

    private static Map<Character, Integer> getFreqMapOfCharactersFrom(String s2) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for (int i = 0; i < s2.length(); i++) {
            char ch = s2.charAt(i);
            if (!freqMap.containsKey(ch)){
                freqMap.put(ch,1);
            }else {
                freqMap.put(ch,freqMap.get(ch)+1);
            }
        }
        return freqMap;
    }
}
