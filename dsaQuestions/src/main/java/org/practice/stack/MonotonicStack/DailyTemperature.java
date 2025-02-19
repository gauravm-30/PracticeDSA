package org.practice.stack.MonotonicStack;

import java.util.ArrayDeque;
import java.util.Deque;

public class DailyTemperature {

    static class Pair{
        private final int temperature;
        private final int index;

        public Pair(int temperature, int index) {
            this.temperature = temperature;
            this.index = index;
        }

        public int getTemperature() {
            return temperature;
        }

        public int getIndex() {
            return index;
        }

    }

    public static void main(String[] args){

    }

    public static int[] dailyTemperatures(int[] temperatures){

        //Create monotonic stack
        //will always store the element greater than current element
        // if not then pop out
        Deque<Pair> stack = new ArrayDeque<>();
        int[] result = new int[temperatures.length];

    for (int i = temperatures.length-1; i>=0; i--) {
            int currentTemp = temperatures[i];
            while(!stack.isEmpty() && stack.peek().getTemperature()<=currentTemp){
                stack.pop();
            }
            if(stack.isEmpty()){
                result[i]=0;
            }else {
                result[i]=stack.peek().getIndex()-i;
            }
           stack.push(new Pair(currentTemp,i));
        }
    return result;
    }



}
