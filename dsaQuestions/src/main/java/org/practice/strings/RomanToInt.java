package org.practice.strings;

public class RomanToInt {
    public static void main(String[] args){
        String roman = "MCMXCIV";
        String roman2= "LVIII";
    System.out.println(romanToInt(roman2));
    }

    //approach 1
    //TC O(N)
    //SC O(N) //we can do it without it also
    private static int romanToInt(String roman) {
         char[] chars = roman.toCharArray();
         int value = 0;
         for(int i = chars.length-1; i>=0; i--) {
              char ch = chars[i];
              switch (ch){
                  case 'I':{
                      value++;
                      break;
                  }
                  case 'V':{
                      if(i>0 && chars[i-1]=='I'){
                          value+=4;
                          i--;
                      }else {
                          value+=5;
                      }
                      break;
                  }

                  case 'X':{
                      if(i>0 && chars[i-1]=='I'){
                          value+=9;
                          i--;
                      }else {
                          value+=10;
                      }
                      break;
                  }

                  case 'L':{
                      if(i>0 && chars[i-1]=='X'){
                          value+=40;
                          i--;
                      }else {
                          value+=50;
                      }
                      break;
                  }

                  case 'C':{
                      if(i>0 && chars[i-1]=='X'){
                          value+=90;
                          i--;
                      }else {
                          value+=100;
                      }
                      break;
                  }

                  case 'D':{
                      if(i>0 && chars[i-1]=='C'){
                          value+=400;
                          i--;
                      }else {
                          value+=500;
                      }
                      break;
                  }

                  case 'M':{
                      if(i>0 && chars[i-1]=='C'){
                          value+=900;
                          i--;
                      }else {
                          value+=1000;
                      }
                      break;
                  }
              }

         }
         return value;
    }
}
