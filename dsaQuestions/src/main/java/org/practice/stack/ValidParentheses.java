package org.practice.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class ValidParentheses {
  public static void main(String[] args) {
    System.out.println(isValid("()[]{}"));
  }

  private static boolean isValid(String s) {

    if (s.length() % 2 == 1) {
      return false;
    }
    Deque<Character> stack = new ArrayDeque<>();
    for (Character ch : s.toCharArray()) {
      switch (ch) {
        case '(', '{', '[':
          stack.push(ch);
          break;
        case ')':
          if (stack.peek() != null && '(' == stack.peek()) {
            stack.pop();
          } else {
            return false;
          }
          break;

        case '}':
          if (stack.peek() != null && '{' == stack.peek()) {
            stack.pop();
          } else {
            return false;
          }
          break;
        case ']':
          if (stack.peek() != null && '[' == stack.peek()) {
            stack.pop();
          } else {
            return false;
          }
          break;
      }
    }
    return stack.isEmpty();
  }
}
