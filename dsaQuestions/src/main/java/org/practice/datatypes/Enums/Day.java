package org.practice.datatypes.Enums;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public enum Day {
    MONDAY("Monday"),
    TUESDAY("Tuesday"),
    WEDNESDAY("Wednesday"),
    THURSDAY("Thursday"),
    FRIDAY("Friday"),
    SATURDAY("Saturday"),
    SUNDAY("Sunday");

    private static final Map<String,Day> enumToStringMap=getEnumToStringMap();
    private final String value;

     Day(String value){
        this.value = value;
    }

    public String getValue(){
         return this.value;
    }

    private static Map<String, Day> getEnumToStringMap() {
        Map<String,Day> enumToStringMap = new HashMap<>();
        for (Day d : Day.values()){
            enumToStringMap.put(d.value,d);
        }
        return enumToStringMap;
    }

    public static Optional<Day> fromString(String day){
           return Optional.ofNullable(enumToStringMap.get(day));
    }




}
