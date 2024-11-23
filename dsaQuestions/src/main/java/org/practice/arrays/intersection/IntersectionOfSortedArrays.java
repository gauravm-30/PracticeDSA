package org.practice.arrays.intersection;

import java.util.ArrayList;
import java.util.List;

//Sorted + Duplicate elements
public class IntersectionOfSortedArrays {
    public static void main(String[] args){

    }

    //Brute Force Approach
    //Traverse through a[] and avoid duplicates while traversing.
    // Since the arrays are sorted, we can avoid duplicates by matching with the previous element.
    //For every element of a[],
    // check if it is in b[],
    // If Yes, then add it to the result
    // and do not traverse further in b[] to avoid duplicates.

    // Function to find the intersection of two arrays
    // It returns a list containing the common elements
    //TC   O(n*m) Time and O(1) Space
    static List<Integer> intersection(int[] a, int[] b) {
        List<Integer> res = new ArrayList<>();
        int m = a.length;
        int n = b.length;

        for (int i = 0; i < m; i++) {

            // Note that duplicates must be
            // consecutive in a sorted array
            if (i > 0 && a[i - 1] == a[i])
                continue;

            // Since we are only searching distinct
            // elements of a[] in b[] and we break as
            // soon we find a match, we get only
            // distinct elements in result
            for (int j = 0; j < n; j++) {
                if (a[i] == b[j]) {
                    res.add(a[i]);
                    break;
                }
            }
        }

        return res;
    }

    //Using Hashset - same as for unsorted array
    //Best Time O(n+m) and O(n) Space


    //Using Merge Step of Merge Sort - O(n+m) Time and O(1) Space
// Function to find the intersection of two arrays
    static List<Integer> intersectionUsingMerge(int[] a, int[] b) {
        List<Integer> res = new ArrayList<>();
        // This is similar to merge of merge sort
        int i = 0, j = 0;
        while (i < a.length && j < b.length) {

            // Skip duplicate elements in the first array
            if (a[i]==a[i + 1]) {
                i++;
                continue;
            }

            // Skip the smaller
            if (a[i] < b[j]) {
                i++;
            } else if (a[i] > b[j]) {
                j++;
            }

            // If equal, add to result and move both
            else {
                res.add(a[i]);
                i++;
                j++;
            }
        }

        return res;
    }

}
