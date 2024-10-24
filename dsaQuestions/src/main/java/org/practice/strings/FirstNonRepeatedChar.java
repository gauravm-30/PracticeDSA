package org.practice.strings;


import java.util.*;

public class FirstNonRepeatedChar {
    public static void main(String[] args){
   printFirstNonRepeatedCharV1("auravMaurya");
    }

    //using LinkedHashMap
    public static void printFirstNonRepeatedCharV1(String word){
        Map<Character,Integer> linkedHashMap = new LinkedHashMap<>();
        for (char ch : word.toCharArray()){
            if(!linkedHashMap.containsKey(ch)){
                linkedHashMap.put(ch,1);
            }else {
                linkedHashMap.put(ch,linkedHashMap.get(ch)+1);
            }
        }

        for (Map.Entry<Character,Integer> entry : linkedHashMap.entrySet()){
            if(entry.getValue()==1){
        System.out.println("entry.getKey() = " + entry.getKey());
        break;
            }
        }
    }

    public static char firstNonRepeatedCharacterV2(String word) {
        HashMap<Character,Integer> scoreboard = new HashMap<>();
        // build table [char -> count]
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (scoreboard.containsKey(c)) {
                scoreboard.put(c, scoreboard.get(c) + 1);
            } else {
                scoreboard.put(c, 1);
            }
        }
        // since HashMap doesn't maintain order, going through string again
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (scoreboard.get(c) == 1) {
                return c;
            }
        } throw new RuntimeException("Undefined behaviour");
    }

    public static char firstNonRepeatedCharacterV3(String word) {
    Set<Character> repeatedChar = new HashSet<>();
    List<Character> nonRepeatedChar = new ArrayList<>();
        // build table [char -> count]
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (repeatedChar.contains(c)) {
               continue;
            }
            //removing the element from non repeated and transfer to repeated one
            if(nonRepeatedChar.contains(c)){
                nonRepeatedChar.remove(c);
                repeatedChar.add(c);
            }
            else {
               nonRepeatedChar.add(c);
            }
        }
        return nonRepeatedChar.get(0);
    }
}
