package org.practice.arrays.commonbasicquestions;

import java.util.*;

public class FindPairOfSum {
//    https://www.geeksforgeeks.org/print-all-pairs-with-given-sum/
    public static void main(String[] args){

        int[] nums = {1,2,6,3,1,1,2,3,4,5,6,1};
        getPairOfElementFor(nums,7);
    }

    //for the target multiple solution may exist
    //numbers can repeat in the array
    //Time Complexity -O(n^3)
    public static void getPairOfElementFor(int[] nums,int target){

        //check arr.length should be greater than 1
        //for the numbers repeat in the array , we will use lookup array
        List<List<Integer>> res = new ArrayList<>();
    int countPairs = 0;
        for(int i = 0; i < nums.length-1; i++) {
            for(int j = i+1; j <nums.length ; j++) {
                 if(nums[i]+nums[j]==target && nums[i]!=nums[j]){   //checking for the same pair like {3,3}
                     int first = Math.min(nums[i], nums[j]);
                     int second = Math.max(nums[i], nums[j]);
                     List<Integer> cur = new ArrayList<>();
                     cur.add(first);
                     cur.add(second);
                     //OR Use Arrays.asList(x1,x2);
                     countPairs++;

                     // Making sure that all pairs with target
                     // sum are distinct
                     if (!res.contains(cur))    // Takes O(n) to check
                         res.add(cur);
                 }
            }

        }
    System.out.println(res);
    }


    // Function to find all possible pairs with the sum target
    //TC O(n^2)
    //SC O(n)
    static List<List<Integer>> distinctPairs(int[] arr, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int n = arr.length;

        // Set to handle duplicates using sorted pairs
        Set<List<Integer>> st = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] + arr[j] == target) {
                    int first = Math.min(arr[i], arr[j]);
                    int second = Math.max(arr[i], arr[j]);
                    List<Integer> cur = new ArrayList<>
                            (Arrays.asList(first, second));

                    // If the pair is not already in the set, add it
                    if (!st.contains(cur)) {
                        res.add(cur);
                        st.add(cur);
                    }
                }
            }
        }
        return res;
    }

    //Two pointer approach
    // O(n*logn) Time and O(1) Space
//    The idea is to sort the array and use two pointers technique to find all the pairs. Initialize two pointers at the beginning and end of the array.
//    Now, compare the sum of elements at these pointers:
//
//
//    If sum = target, store the pair and skip duplicates to ensure they are distinct.
//    If sum < target, we move the left pointer towards right.
//    If sum > target, we move the right pointer towards left.
//    This continues until all pairs are checked, giving us all the distinct pairs.

 public  static List<List<Integer>> distinctPairsTwoPointerApproach(int[] arr, int target) {
        List<List<Integer>> res = new ArrayList<>();

        // Initialize pointers
        int l = 0;
        int r = arr.length - 1;

        while (l < r) {

            // Avoiding duplicates
            if (arr[l] == arr[l + 1]) {
                l++;
                continue;
            }

            if (arr[r] == arr[r - 1]) {
                r--;
                continue;
            }

            // Check if sum equals the target
            if (arr[l] + arr[r] == target) {
                res.add(Arrays.asList(arr[l], arr[r]));
                l++;
                r--;
            }
            else if (arr[l] + arr[r] > target) {
                r--;
            }
            else {
                l++;
            }
        }

        return res;
    }



}
