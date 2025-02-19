package org.practice.stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class AsteroidCollisions {

    public static void main(String[] args){
    System.out.println(Arrays.toString(asteroidCollision(new int[]{1, -2, -2, -2})));
    }

    public static int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i=0; i<asteroids.length;i++){
            int asteroid = asteroids[i];
            if(asteroid>0){
                stack.push(asteroid);
            }else{
                if(stack.isEmpty() || stack.peek()<0){
                    stack.push(asteroid);
                }else{
                    while(!stack.isEmpty()){
                        int top = stack.peek();
                        if(top<0){
                            stack.push(top);
                            break;
                        }
                        if(Math.abs(asteroid)==Math.abs(top)){
                            stack.pop();
                            break;
                        }
                        if(Math.abs(asteroid)<Math.abs(top)){
                            break;
                        }else {
                            stack.pop();
                            if(stack.isEmpty() || stack.peek()<0){
                                stack.push(asteroid);
                                break;
                            }
                        }
                    }
                }
            }
        }
        int[] result = new int[stack.size()];
        for(int i=result.length-1;i>=0;i--){
            result[i]=stack.pop();
        }
        return result;
    }



    public static int[] asteroidCollisionV2(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();
    for (int i = 0; i < asteroids.length; i++) {
      int asteroid = asteroids[i];
      if (stack.isEmpty() || asteroid > 0) {
        stack.push(asteroid);
      } else {
        while (!stack.isEmpty()) {
          int top = stack.peek();
          if(top<0){
              stack.push(asteroid);
              break;
          }
          int modVal = Math.abs(asteroid);
          if(modVal==top){
              stack.pop();
              break;
          }else if(modVal<top){
              break;
          }else {
              stack.pop();
              if(stack.isEmpty()){
                  stack.push(asteroid);
                  break;
              }
          }
        }
      }
    }

    int[] result = new int[stack.size()];
        for(int i=result.length-1;i>=0;i--){
            result[i]=stack.pop();
        }
        return result;
    }
}
