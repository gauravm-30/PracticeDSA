package org.practice.strings;

public class ReverseStrings {
    public static void main(String[] args) {

    }
    public static void reverseStringV1() {
        String s2 = "GeeksForGeeks";
        StringBuilder reverseString = new StringBuilder();
        for (int i = s2.length() - 1; i >= 0; i--) {
            char ch = s2.charAt(i);
            reverseString = reverseString.append(ch);
            //      reverseString = reverseString.append(String.valueOf(ch));
        }
        System.out.println("reverseString = " + reverseString);
    }

    public static void reverseStringV2() {
        String s2 = "GeeksForGeeks";

        // First get stream of characters and transform each character into string
        String reverseString =
                s2.chars().mapToObj(ele -> String.valueOf((char) ele)).reduce("", (ch1, ch2) -> ch2 + ch1);
    }

    public static void reverseStringV3() {
        String s2 = "GeeksForGeeks";
        String reverseString = new StringBuilder(s2).reverse().toString();
    }
}
