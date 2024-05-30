package org.practice.recursion.subsetsequence;

import java.util.ArrayList;
import java.util.List;

public class RecursionSubsetSubsequence {

  // Definition of Subarray/Substrings and Example

  // As we know that an array is a linear collection of values stored at contiguous memory
  // locations. So, what is subarray? Well, a subarray is nothing but a slice of these contiguous
  // memory locations of the actual array. In simpler terms, a subarray is nothing but any
  // contiguous part of a given array. The subarray has the same sequence of elements (order of the
  // elements) as it is in the array.
  //
  //    A subarray is also known as a contiguous subarray. Although a subarray is contiguous
  // (continuous) in nature.
  //
  //    Example: Let the array be: arr = [1, 2, 3] Then one subarray of arr can be: subarray = [1,
  // 2] All the sub-arrays of arr are:
  //            [] -Empty subarray
  //            [1]
  //            [2]
  //            [3]
  //            [1, 2]
  //            [2, 3]
  //            [1, 2, 3]

  //  An empty array [] is considered a subarray of any array, including [1, 2, 3]. A subarray is
  // defined as a contiguous part of an array. Since the empty array has no elements, it satisfies
  // the condition of being a subarray.

  // **[1,3] is not a subarray because it is not contiguous
  //   So, we conclude that the size of the subarray can range from 1 to the size of the actual
  // array.
  // There are n*(n+1)/2 non-empty subarrays/substrings.

  //    Definition of Subset and Example
  //    A subset is often confused with subarray and subsequence but a subset is nothing but any
  // possible combination of the original array (or a set).
  //  The subsets of any set include all possible sets formed by its elements, including the null
  // set.
  // Note: If order of element is different but elements are same in two different array of one
  // will considered
  //    For example, the subsets of array arr = [1, 2, 3, 4] can be:
  //          [],                    //proper subset
  //          [1],[2],[3],
  //          [1,2] OR [2,1]  take only one //order can't be change so [1,2]
  //          [1,3] OR [3,1]  take only one //order can't be change so [1,3]
  //          [1,4] OR [4,1]  take only one //order can't be change so [1,4]
  //          [2,3] OR [3,2]  take only one
  //          [2,4] OR [4,2]  take only one
  //          [3,4] OR [4,3]  take only one
  //          [1,2,3] , other combinations with same elements like [2,1,3], [3,2,1],[3,1,2],... are
  // ignored
  //          [1,2,4]
  //          [1,3,4]
  //          [2,3,4]
  //          [1,2,3,4]    // improper subset of [1,2,3,4],
  // Except this all above subsets are
  // proper subset of [1,2,3,4] which includes [] this also.
  //
  //  So, we can conclude that subset is the superset of subarrays i.e. all the subarrays
  // are subsets but vice versa is not true.

  // Total subsets = 2^n
  // Total proper subset = 2^n -1

  //    Definition of Subsequence and Example
  //    As the name suggests, a subsequence is a sequence of the elements of the array obtained by
  // deleting some elements of the array.
  // One important thing related to the subsequence is that
  // even after deleting some elements, the sequence of the array elements is not changed.
  // Both the string and arrays can have subsequences.
  //
  //    The subsequence should not be confused with the subarray or substring. The subarray or
  // substring is contiguous but a subsequence need not to be contiguous.
  //
  //    For example, the subsequences of the array arr : [1, 2, 3, 4] can be:
  //
  //            [1, 3]
  //            [2, 3, 4]
  //            [1, 2, 3, 4], etc.
  //
  // Note: A subarray is a subsequence, a subsequence is a subset but the reverse order
  // is not correct.
  //

  //
  //    Number of subarrays, subset, subsequence we can form using a array of size n.
  //    Let us learn how many subsets, subsequences, and subarrays can an array (arr) of size n
  // have.

  //    As we know, a subarray is a slice of the contiguous memory locations of the array. So, we
  // can have n * (n+1)/2 non-empty subarrays of an array.
  //
  //            Now, a subset is nothing but any possible combination of the original array (or a
  // set). We can have 2^(size of the array) i.e. 2^n subsets of an array out of which [1 improper
  // subset + 2^n-1 proper subset]
  //
  //    A subsequence is a sequence of the elements of the array obtained by deleting some elements
  // of the array and preserving the order of the array elements. We can have 2^n subsequences of an
  // array since we keep the original ordering, this is the same as subsets of an array.
  //
  //    For example, if the size of the array is 3 then
  //
  //    The number of subarrays is 6.
  //    The number of the subsequences is 8.
  //    The number of subsets is 8.
  //    Src: https://www.scaler.com/topics/difference-between-subarray-subset-and-subsequence/

  public static void runSubsetSubsequenceProblem() {
    String s1 = "bcabcaabb";
    char ch = 'a';
    //    System.out.println(removeChar(s1, ch));
    String processed = "";
    skipCharV1(processed, s1);
    System.out.println(processed);
    printAllSubsets("", "ab");
    int[] arr = {1, 2, 3};
    int[] arr2 = {1, 2, 2};
    //    var subsets = printAllSubsetsIteratively(arr);
    //    for (List<Integer> list : subsets) {
    //      System.out.println(list);
    //    }

    var subsetsDuplicates = printAllSubsetsIterativelyDuplicates(arr2);
    for (List<Integer> list : subsetsDuplicates) {
      System.out.println(list);
    }
  }

  // removing subarray questions
  // Approach 1, for loop
  private static String removeChar(String s1, char ch) {
    StringBuilder sb = new StringBuilder(s1);
    for (int i = 0; i < sb.length(); i++) {
      while (sb.charAt(i) == 'a') {
        sb.deleteCharAt(i);
      }
    }
    return sb.toString();
  }

  // Approach 2 ,void recursion
  // function which doesn't return only prints
  private static void skipCharV1(String processed, String unprocessed) {
    if (unprocessed.isEmpty()) {
      System.out.println(processed);
      return;
    }
    char ch = unprocessed.charAt(0);
    if (ch == 'a') {
      skipCharV1(processed, unprocessed.substring(1));
    } else {
      skipCharV1(ch + processed, unprocessed.substring(1));
    }
  }

  // Instead of String we can use string builder class also
  // s1.substring(1) this will create new object every time
  // skip 'a'
  private static String skipCharV2(String s1) {
    if (s1.isEmpty()) {
      return "";
    }
    char ch = s1.charAt(0);
    if (ch == 'a') {
      return skipCharV2(s1.substring(1));
    } else {
      return ch + skipCharV2(s1.substring(1));
    }
  }

  // Skip only apple
  private static String skipString(String s1) {
    if (s1.isEmpty()) {
      return "";
    }

    char ch = s1.charAt(0);
    if (s1.startsWith("Apple")) {
      return skipString(s1.substring("apple".length() - 1));
    } else {
      return ch + skipString(s1.substring(1));
    }
  }

  // only skip app when it is not equal to apple
  private static String skipAppWhenNotApple(String s1) {
    if (s1.isEmpty()) {
      return "";
    }
    char ch = s1.charAt(0);
    if (s1.startsWith("app") && !s1.startsWith("apple")) {
      return skipAppWhenNotApple(s1.substring("app".length() - 1));
    } else {
      return ch + skipAppWhenNotApple(s1.substring(1));
    }
  }

  // Subsets Problems : Whenever we need to deal with permutation and combination
  // These type of problems can occur .
  // Use subset method
  // String s1 ="abc"
  // Subsets ["a","b","c","ab","ac","bc","abc"].
  // If we closely observe then each is removing/taking element from original element.
  // This pattern of taking some elements and removing  some of them is known as subset pattern.
  private static void printAllSubsets(String processed, String unprocessed) {
    if (unprocessed.isEmpty()) {
      System.out.println(processed);
      return;
    }
    char ch = unprocessed.charAt(0);
    // take the  new character in processed element at the last
    printAllSubsets(processed + ch, unprocessed.substring(1));
    // ignore the character from processed element
    printAllSubsets(processed, unprocessed.substring(1));
  }

  private static List<String> printAllSubsetsV1(String processed, String unprocessed) {
    if (unprocessed.isEmpty()) {
      ArrayList<String> list = new ArrayList<>();
      list.add(processed);
      return list;
    }

    char ch = unprocessed.charAt(0);
    // take the  new character in processed element at the last
    List<String> ansFromLeft = printAllSubsetsV1(processed + ch, unprocessed.substring(1));
    // ignore the character from processed element
    List<String> ansFromRight = printAllSubsetsV1(processed, unprocessed.substring(1));

    // while returning backing can you please my answer back to above call .
    ansFromLeft.addAll(ansFromRight);
    return ansFromLeft;
  }

  private static List<String> printSubsetsAlongWithAsciiCharV2(
      String processed, String unprocessed) {
    if (unprocessed.isEmpty()) {
      ArrayList<String> list = new ArrayList<>();
      list.add(processed);
      return list;
    }

    char ch = unprocessed.charAt(0);
    // take the  new character in processed element at the last
    List<String> ansFromLeft =
        printSubsetsAlongWithAsciiCharV2(processed + ch, unprocessed.substring(1));
    List<String> ansFromAscii =
        printSubsetsAlongWithAsciiCharV2(processed + (ch + 0), unprocessed.substring(1));
    List<String> ansFromRight =
        printSubsetsAlongWithAsciiCharV2(processed, unprocessed.substring(1));

    // while returning backing can you please my answer back to above call .
    ansFromLeft.addAll(ansFromAscii);
    ansFromLeft.addAll(ansFromRight);
    return ansFromLeft;
  }

  // Iterative Subset Problems
  private static List<List<Integer>> printAllSubsetsIteratively(int[] arr) {
    List<List<Integer>> result = new ArrayList<>();
    result.add(new ArrayList<>());
    for (int ele : arr) {
      int numOfListToMake = result.size();
      for (int i = 0; i < numOfListToMake; i++) {
        ArrayList<Integer> internalList = new ArrayList<>(result.get(i));
        internalList.add(ele);
        result.add(internalList);
      }
    }

    return result;
  }

  // What if duplicates are present into the arrays then
  // sort first
  // if current element is equal to previous element then create the list with newly added element
  // only
  private static List<List<Integer>> printAllSubsetsIterativelyDuplicates(int[] arr) {
    int start = 0;
    int end = 0;
    List<List<Integer>> result = new ArrayList<>();
    result.add(new ArrayList<>());
    for (int i = 0; i < arr.length; i++) {
      // for every element we need to get the start and end Index of the index.
      start = 0;
      // if current and previous element is same , star=end+1;
      if (i > 0 && arr[i] == arr[i - 1]) {
        start = end + 1;
      }
      end = result.size() - 1;
      int numOfListToMake = result.size();
      for (int j = start; j < numOfListToMake; j++) {
        ArrayList<Integer> internalList = new ArrayList<>(result.get(j));
        internalList.add(arr[i]);
        result.add(internalList);
      }
    }

    return result;
  }

  private void printSubsetsAlongWithAsciiChar(String processed, String unprocessed) {
    if (unprocessed.isEmpty()) {
      System.out.println(processed);
      return;
    }
    char ch = unprocessed.charAt(0);
    // ch+0 will give ascii value
    printSubsetsAlongWithAsciiChar(processed + ch, unprocessed.substring(1));
    printSubsetsAlongWithAsciiChar(processed + (ch + 0), unprocessed.substring(1));
    printSubsetsAlongWithAsciiChar(processed, unprocessed.substring(1));
  }
}
