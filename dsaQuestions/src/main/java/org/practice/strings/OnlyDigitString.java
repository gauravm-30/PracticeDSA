package org.practice.strings;

public class OnlyDigitString {
    public static void main(String[] args){
        String s1 = "12345";
        String s2 = "-12345";
        String s3 = "-";
        String s4 = "1";
        String s5 = "";
        boolean isStringANumber = isStringANumberV1(s1);
        boolean isStringANumberUsingRegex = isStringANumberUsingRegex(s1);
        boolean isStringANumberUsingParsing = isStringANumberUsingParsing("+1234");

        System.out.println(isStringANumber);
    System.out.println(isStringANumberUsingParsing);
    }

    private static boolean isStringANumberUsingParsing(String s1) {
        try{
            Integer.parseInt(s1);
            return true;
}catch (NumberFormatException e){
            return false;
        }

    }

    private static boolean isStringANumberUsingRegex(String s1) {
        return false;
//https://javarevisited.blogspot.com/2012/10/regular-expression-example-in-java-to-check-String-number.html?ref=hackernoon.com#google_vignette
    }

    private static boolean isStringANumberV1(String s1) {
        char[] chars = s1.toCharArray();

        //when string is empty
        if(chars.length==0){
            return false;
        }
        //when string have only one character
        if(chars.length==1){
            return isDigit(chars[0]);
        }else {
            if(!isFirstCharValid(chars[0]) ){
                return false;
            }
            for(int i = 1; i < chars.length; i++) {
                if(!isDigit(chars[i])){
                    return false;
                }
            }
            return true;
        }
    }

    private static boolean isFirstCharValid(char ch) {
        return ch == '-' || ch =='+' || isDigit(ch);
    }

    private static boolean isDigit(char ch) {
     switch (ch){
         case '0','1','2','3','4','5','6','7','8','9':
             return true;
         default: return false;
     }
    }
}
