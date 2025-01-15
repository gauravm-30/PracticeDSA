package org.practice.strings;

import java.util.ArrayList;

// https://www.geeksforgeeks.org/find-the-minimum-distance-between-the-given-two-words/
public class MinDistanceBetweenGivenTwoWordsArray {

    public static void main(String[] args){

    }

  static int shortestDistance(ArrayList<String> s, String word1, String word2) {
    // code here
    int word1Index = -1;
    int word2Index = -1;
    int minDist = Integer.MAX_VALUE;
    for (int i = 0; i < s.size(); i++) {
      if (word1.equals(s.get(i))) {
        word1Index = i;
      }
      if (word2.equals(s.get(i))) {
        word2Index = i;
      }

      if (word1Index != -1 && word2Index != -1) {
        minDist = getMinOf(minDist, abs(word2Index - word1Index));
      }
    }
    return minDist;
  }

  static int getMinOf(int a, int b) {
    return Math.min(a, b);
  }

  static int abs(int value) {
    if (value < 0) {
      value = value * (-1);
    }
    return value;
  }
}

