package org.practice.stack.MonotonicStack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class NextGreaterElement1 {
    public static void main(String[] args){

    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {

        //we know that nums1 is subset of nums2
        //element are unique in each array

        Map<Integer,Integer> elementIndexMap = new HashMap<>();
        for(int i = 0; i<nums2.length; i++){
            elementIndexMap.put(nums2[i],i);
        }

        //Now get the next greater element for every element of nums2[]

        int[] tempResult = new int[nums2.length];
        Deque<Integer> stack = new ArrayDeque<>();

        //Since we need to find the next greater element in right , so will start from right.

        for(int i=nums2.length-1; i>=0; i--){
            int num = nums2[i];
            while(!stack.isEmpty() && stack.peek()<num){
                stack.pop();
            }
            if(stack.isEmpty()){
                tempResult[i]=-1;
            }else{
                tempResult[i] = stack.peek();
            }
            stack.push(num);
        }


        int[] finalResult = new int[nums1.length];
        for(int i=0; i<nums1.length; i++){
            int indexInNum2 = elementIndexMap.get(nums1[i]);
            finalResult[i]= tempResult[indexInNum2];
        }

        return finalResult;
    }

    //Use only when elements are unique
    public int[] nextGreaterElementV2(int[] nums1, int[] nums2) {

        //we know that nums1 is subset of nums2
        //element are unique in each array
        //Map of element and its greater element
        Map<Integer,Integer> elementNextGreaterMap = new HashMap<>();

        Deque<Integer> stack = new ArrayDeque<>();

        for(int i=0; i<nums2.length; i++){
            int num = nums2[i];
            while(!stack.isEmpty() && stack.peek()<num){
                elementNextGreaterMap.put(stack.pop(),num);
            }
            stack.push(num);
        }

        //Now the element remaining in the stack are those who don't have any next greater element
        while(!stack.isEmpty()){
            elementNextGreaterMap.put(stack.pop(),-1);
        }

        int[] result = new int[nums1.length];
        for(int i=0; i<nums1.length; i++){
            int nextGreaterElement = elementNextGreaterMap.get(nums1[i]);
            result[i]= nextGreaterElement;
        }

        return result;
    }


}
