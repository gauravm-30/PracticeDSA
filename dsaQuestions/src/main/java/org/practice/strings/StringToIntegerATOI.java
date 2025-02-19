package org.practice.strings;

public class StringToIntegerATOI {
    public static void main(String[] args){
    System.out.println(myAtoi("  -042"));
    }


    //important concepts
    public static int myAtoi(String s){

        if(s==null || s.isEmpty()){
            return 0;
        }

        String s2 = s.trim() ; //ignoring the whitespaces if present
        boolean isNegative = false;
        long res = 0;
        for(int i = 0; i < s2.length(); i++) {
            char ch = s2.charAt(i);

      if (i == 0) {
        if (ch == '-') {
          isNegative = true;
          continue;
        } else if (ch == '+') {
            isNegative = false;
            continue;
        }
      }
      if (ch >= '0' && ch <= '9') {
                int digit = ch - '0';
                res = res*10 + digit;
            }
      else {
          break;
      }
        }

      if(isNegative){
          res = res*(-1);
      }
      if(res>Integer.MAX_VALUE){
          res = Integer.MAX_VALUE;
      }else if(res<Integer.MIN_VALUE){
          res = Integer.MIN_VALUE;
      }

        return (int)res;
    }
}
