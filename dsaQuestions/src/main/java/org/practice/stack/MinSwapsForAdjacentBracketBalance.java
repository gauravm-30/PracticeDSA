package org.practice.stack;

import java.util.ArrayDeque;
import java.util.Deque;

//https://www.geeksforgeeks.org/problems/minimum-swaps-for-bracket-balancing2704/1
public class MinSwapsForAdjacentBracketBalance {

    //Stack variant
    static int minimumNumberOfSwaps(String s) {
        // code here
        Deque<Character> stack = new ArrayDeque<>();
        int swaps=0;
        int unbalanceClose =0;

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);

            if(ch=='['){
                if(unbalanceClose!=0){
                    swaps=swaps + unbalanceClose ;
                    unbalanceClose--;
                }else{
                    stack.push(ch);
                }
            }else{
                if(stack.isEmpty() || stack.peek()==']'){
                    unbalanceClose++;
                }else{
                    stack.pop();
                }
            }

        }

        return swaps;
    }


}
