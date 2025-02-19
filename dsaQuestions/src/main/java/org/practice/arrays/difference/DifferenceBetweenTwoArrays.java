package org.practice.arrays.difference;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DifferenceBetweenTwoArrays {
    public static List<List<Integer>> findDifference(int[] nums1, int[] nums2){
        Set<Integer> integerSet = new HashSet<Integer>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for(int i : nums2){
            integerSet.add(i);
        }

        List<Integer> result1 = new ArrayList<>();
        for(int i : nums1){
            if(!integerSet.contains(i)){
                result1.add(i);
            }
        }
        result.add(result1);

        integerSet.clear();

        for(int i : nums1){
            integerSet.add(i);
        }

        List<Integer> result2 = new ArrayList<>();
        for(int i : nums2){
            if(!integerSet.contains(i)){
                result2.add(i);
            }
        }
        result.add(result2);

        return result;
    }

}
