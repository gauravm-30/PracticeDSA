package org.practice.datatypes.String;

import java.util.ArrayList;
import java.util.List;

public class StringConversion {
    public static void main(String[] args) {
        String[] stringArr = {"I","wish"};
        List<String> stringList = getStringList(stringArr);
    }

    private static List<String> getStringList(String[] stringArr) {
        List<String> stringList = new ArrayList<>();
        for (String value : stringArr){
            stringList.add(value);
        }
        return stringList;
    }
}
