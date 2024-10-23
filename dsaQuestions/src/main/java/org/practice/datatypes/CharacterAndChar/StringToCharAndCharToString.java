package org.practice.datatypes.CharacterAndChar;

public class StringToCharAndCharToString {
    public static void main(String[] args) {
        primitiveCharToString();
        stringToPrimitiveChar();
    }

    private static void stringToPrimitiveChar() {
        String string = "Gaurav";
        char[] chars = getCharsFrom(string);
        char[] chars1=string.toCharArray();
    }

    private static char[] getCharsFrom(String string) {
        char[] chars = new char[string.length()];
        for (int i = 0; i < string.length(); i++) {
            chars[i]= string.charAt(i);
        }
        return chars;
    }

    private static void primitiveCharToString() {
        char[] chars = {'a','b','c'};
        String string = new String(chars);
    }
}
