package org.practice.strings;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class StringSplit {
    public static void main(String[] args) {
        String s1 = "without in within with";
        String s2 = "singing dancing ing flower flowering";
        getListOfString(s2);
    }

    private static void getListOfString(String s1) {
        s1=s1.toLowerCase();
        String[] s2 = s1.split(" ");
        getFormattedString(s2);
    }

    private static void getFormattedString(String[] s2) {
        for (String value : s2) {
            LinkedList<String> subStrings = new LinkedList<>();
            for (String string : s2) {
                if (!string.equals(value) && string.contains(value)) {
                    subStrings.addLast(string);
                }
            }
            if (!subStrings.isEmpty()) {
                subStrings.addFirst(value);
                subStrings.forEach(s -> System.out.print(s + " "));
            }
            System.out.println();
        }
    }
}
