package org.practice.strings;

import java.util.ArrayList;

//https://leetcode.com/problems/shortest-word-distance/description/
//https://www.geeksforgeeks.org/problems/closest-strings0611/1?page=1&difficulty=Basic,Easy,Medium&sortBy=difficulty
public class ShortestWordDistance {
    public static void main(String[] args){

    }

   private int shortestDistance(ArrayList<String> s, String word1, String word2) {
        // code here
        int word1Index = -1;
        int word2Index = -1;
        int minDist =Integer.MAX_VALUE;
        for(int i = 0 ; i<s.size();i++){
            if(word1.equals(s.get(i))){
                word1Index = i;
            }
            if(word2.equals(s.get(i))){
                word2Index = i;
            }

            if(word1Index!=-1 && word2Index!=-1){
                minDist = getMinOf(minDist,abs(word2Index-word1Index));
            }
        }
        return minDist;
    }

   private int getMinOf(int a, int b){
        return a<b?a:b;
    }

   private int abs(int value){
        if(value<0){
            value=value*(-1);
        }
        return value;
    }
}
