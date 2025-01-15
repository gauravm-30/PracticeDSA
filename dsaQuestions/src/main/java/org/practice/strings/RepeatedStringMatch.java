package org.practice.strings;

//Leetcode : https://leetcode.com/problems/repeated-string-match/description/
//https://www.geeksforgeeks.org/problems/minimum-times-a-has-to-be-repeated-such-that-b-is-a-substring-of-it--170631/1?page=1&sortBy=submissions
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

    //Imp
    static int minRepeats(String A, String B) {
        int count = 1 ;
        // code here
        StringBuilder sb = new StringBuilder(A);

        //Firstly make sb.length() upto the B.length()
        while(sb.length()<B.length()){
            sb.append(A);
            count++;
        }

        for(int i = 0; i<2 ;i++){
            if(sb.toString().contains(B)){
                return count;
            }
            sb.append(A);
            count++;
        }
        return -1 ;
    }

}
