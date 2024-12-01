package org.practice.strings;

import java.util.ArrayList;
import java.util.List;

// There are two main ways to solve this problem, using loops or by using recursion, the second one
// is what the interviewer expects.
//
// Read more:
// https://javarevisited.blogspot.com/2015/08/how-to-find-all-permutations-of-string-java-example.html#ixzz8pSBB0qIM
public class FindAllPermutationsOfString {
 /*
 * If you remember the factorial problem you know that factorial is naturally recursive
 * i.e. factorial of n is nothing but n * factorial of n -1.
 * Similarly, permutations are also a recursive problem
 * e.g. permutation of n characters is nothing but fixing one character and
 *  calculating permutation of n - 1 characters e.g. in the case of "xyz",
 *  you can fix "x" and calculate permutation of "yz".
 *
 * In order to calculate all permutations of a String,
 * you need to repeat this exercise for all characters one at a time.
 * This is where for loop comes into the picture.
 * So, this solution uses both for loop and recursion to print all permutations of a given String.
In the case of recursion,
* the most important question is the base case,
*  because that is responsible for stopping recursive calls.
*  If you don't have a base case then your program will eventually terminate with java.lang.StackOverFlowError.

In this problem,
*  our base case is a permutation of empty String,
*  which is nothing but the empty String itself.
* After each call,
* the problem set is reduced and inches towards the base case,
* when it reaches there stack starts rolling down and calculates the result.
 * */

    public static void main(String[] args){
        String s1 = "abcd";
        List<String> allPermutations = getAllPermutations(s1);
    System.out.println(allPermutations);
    }

    private static List<String> getAllPermutations(String s1) {
      return  getPermutationsRecursively("",s1);
    }

    private static List<String> getPermutationsRecursively(String processed, String unprocessed) {
        if(unprocessed.isEmpty()){
            List<String> currentList = new ArrayList<>();
            currentList.add(processed);
            return currentList;
        }
        List<String> answer = new ArrayList<>();
        char ch = unprocessed.charAt(0);
        for(int i = 0; i < processed.length()+1; i++) {
            String f = processed.substring(0,i);
            String s = processed.substring(i);
            List<String> ansFromBelowCalls = getPermutationsRecursively(f+ch+s,unprocessed.substring(1));
            answer.addAll(ansFromBelowCalls);
        }
        return answer;
    }

    private static int permutationsRecursivelyReturnCount(String processed, String unprocessed) {
        if (unprocessed.isEmpty()) {
            return 1;
        }
        int count = 0;
        char ch = unprocessed.charAt(0);
        for (int i = 0; i < processed.length() + 1; i++) {
            String f = processed.substring(0, i);
            String s = processed.substring(i);
            int countFromBelowCalls =
                    permutationsRecursivelyReturnCount(f + ch + s, unprocessed.substring(1));
            count = count + countFromBelowCalls;
        }

        return count;
    }

}
