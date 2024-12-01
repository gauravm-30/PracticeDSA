package org.practice.strings;

//Leetcode : https://leetcode.com/problems/repeated-string-match/description/
public class RepeatedStringMatch {
    public static void main(String[] args){
        String a = "aa";
        String b = "a";

    System.out.println(repeatedStringMatch(a,b));
    }

//    https://youtu.be/Vff71v5b2V0?si=TBw3f6VYmg9fZ6PP
    //Concept
    //a = 'abcd'
    //b = 'cs abcd ab'
    //b = prefix + n*a + suffix  -> n + 2 ;

    // b = prefix + n*a -> n+1;
    //b = n*a + suffix -> n+1;
    //b = n*a -> n

    public static int repeatedStringMatch(String a, String b) {
        int numOfTimeRep= b.length()/a.length();
        int answer = 1 ;

        StringBuilder repString = new StringBuilder(a);
        for(int i = 0; i < numOfTimeRep+2; i++) {
            if(repString.toString().contains(b)){
                return answer;
            }
            repString.append(a);
            answer++;
        }
        return -1;
    }

}
