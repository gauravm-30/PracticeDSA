package org.practice.stack;

import java.util.ArrayDeque;
import java.util.Deque;

//https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/description/
public class MinimumAddToMakeParenthesisValid {
public static void main(String[] args){

}


//Observation
    //if closing bracket comes first before opening bracket means it is invalid,
    //means if stack is empty and closing bracket come then it is invalid.
    //Now we have find number of open invalid and  close  invalid pair.

    private static int minAddToMakeValid(String s){
        Deque<Character> stack = new ArrayDeque<>();
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if(ch=='('){
                stack.push(ch);
            }else {
                if(stack.isEmpty() || stack.peek()==')'){
                    stack.push(ch);
                }else {
                    stack.pop();
                }
            }
        }
        return stack.size();
    }

    //Can we save space of stack.
    //Yes using two pointer
    private static int minAddToMakeValidUsingTwoPointer(String s){
        int open = 0, close = 0;

        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch=='('){
                open++;
            }else {
                if(open==0)
                {
                   close++;
                }
                else {
                    open--;
                }
            }
        }
        return open+close;
    }
}
