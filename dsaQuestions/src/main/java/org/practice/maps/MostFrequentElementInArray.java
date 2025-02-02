package org.practice.maps;


import java.util.HashMap;
import java.util.Map;

public class MostFrequentElementInArray {
    public static void main(String[] args){

    }

    public static int mostFrequentElement(int[] arr){
        int maxFreq = 0;
        int maxFreqElement = 0;
        Map<Integer,Integer> freqMap = new HashMap<>();
        for(int i = 0; i < arr.length; i++) {
            if(freqMap.containsKey(arr[i])){
                freqMap.put(arr[i],freqMap.get(arr[i])+1);
            }else {
                freqMap.put(arr[i],1);
            }
            int currFreq = freqMap.get(arr[i]);
                    if(maxFreq<currFreq){
                        maxFreq=currFreq;
                        maxFreqElement=arr[i];
                    }
        }
        return maxFreq;
    }
}
