package org.practice.datatypes.Enums;

import java.util.Optional;

public class Main {
    public static void main(String[] args){

      //Seasons
      for (Season s : Season.values()){
      System.out.println("s = " + s);
      }
      //valueOf() returns the Season reference of the given string.
      Season s2 = Season.valueOf("WINTER");


      //Days
        for (Day d : Day.values()){
      System.out.println("d = " + d);
       }
        Optional<Day> day = Day.fromString("Monday1");
    if (day.isPresent()) {System.out.println(day);}
        String value = Day.MONDAY.getValue();
        System.out.println("value = " + value);


        //Operation
        OperationV1 plus = OperationV1.PLUS;
    System.out.println(plus.apply(23.66, 26.42));
    try{
        OperationV1 x = OperationV1.valueOf("Gaurav");
    }
    catch (IllegalArgumentException e){
      System.out.println("Invalid operation");
    }
    System.out.println(plus.apply(21, 23));
  }
}
