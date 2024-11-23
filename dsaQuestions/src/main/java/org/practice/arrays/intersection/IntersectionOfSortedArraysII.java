package org.practice.arrays.intersection;

import java.util.ArrayList;
import java.util.List;

//Sorted + Distinct
public class IntersectionOfSortedArraysII {
    public static void main(String[] args){

    }

//    Approaches Same as Unsorted Arrays with distinct elements –
//    Best Time O(n+m) and O(n) Space
//The idea is to use the same approaches as discussed in Intersection of Two Arrays with Distinct Elements.
// The most optimal approach among them is to use Hash Set
// which has a time complexity of O(n+m) and Auxiliary Space of O(n).


    //Approach 2
//    [Expected Approach] Using Merge Step of Merge Sort - O(n+m) Time and O(1) Space
    static ArrayList<Integer> intersection(int[] a, int[] b) {
        ArrayList<Integer> res = new ArrayList<>();

        int i = 0;
        int j = 0;

        // Start simultaneous traversal on both arrays
        while (i < a.length && j < b.length) {

            // if a[i] is smaller, then move in a[]
            // towards larger value
            if (a[i] < b[j]) {
                i++;
            }

            // if b[j] is smaller, then move in b[]
            // towards larger value
            else if (a[i] > b[j]) {
                j++;
            }

            // if a[i] == b[j], then this element is common
            // add it to result array and move in both arrays
            else {
                res.add(a[i]);
                i++;
                j++;
            }
        }
        return res;
    }

}
