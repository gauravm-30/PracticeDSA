package org.practice.strings;

public class NumberOfVowelsAndConsonants {
    public static void main(String[] args){
        String s1 = " Gaurav Maurya ";
        String s2  = s1.replaceAll(" ","").toLowerCase();
        printNumberOfVowelsAndConsonants(s2);
    }

    private static void printNumberOfVowelsAndConsonants(String s1) {
        int vowelsCount = 0;
        int consonantsCount =0;
        for (char ch : s1.toCharArray()){
            if(isVowel(ch)){
                vowelsCount++;
            }
            if(isConsonants(ch)){
                consonantsCount++;
            }
        }

    System.out.println("vowelsCount = " + vowelsCount);
    System.out.println("consonantsCount = " + consonantsCount);
  }

    private static boolean isConsonants(char ch) {
        switch (ch){
            case 'b','c','d','f','g','h','j':
                return true;
            default: return false;
        }
    }

    public static boolean isVowel(char ch) {
        switch (ch){
            case 'a','e','i','o','u','A','I','E','O','U':
                return true;
            default:return false;
        }
    }
}

