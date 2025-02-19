package org.practice.stack.MonotonicStack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class OnlineStackSpan {

    //Brute Force Approach
    //O(n^2) for the given array


    //Optimal Approach Monotonic Stack
    //We will be maintaining the  monotonically
    public static void main(String[] args){
    }



}

class StockSpanner {
    Deque<int[]> stack;
    //we will store element as price,ans
    StockSpanner(){
        stack = new ArrayDeque<>();
    }

    public int next(int price){
        int ans = 1;
        while(!stack.isEmpty() && stack.peek()[0]<=price){
            ans =ans+stack.pop()[1];
        }
        stack.push(new int[]{price,ans});
        return ans;
    }
}