package org.practice.sorting;

import java.util.ArrayList;
import java.util.List;

public class SortingLeetcodeProblems {

  public static void runSortingLeetcode() {
    int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
    int[] nums2 = {4, 3, 5, 7, 5, 5, 5, 1};
    int[] arr = {1, 2, 0};
    //    var missing = findDisappearedNumbers(nums2);
    //    var missingList = findAllDuplicateElement(nums2);
    //    missingList.stream().forEach(System.out::println);
    var missingFirstPositive = firstMissingPositive(arr);
    System.out.println(missingFirstPositive);
    //    missing.stream().forEach(System.out::println);
  }

  // Problem 1 : find only missing number
  // https://leetcode.com/problems/missing-number/description/
  private static int findMissingNumber(int[] arr) {
    applyCyclicSort(arr);
    // search for the first missing number
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] != i) {
        return i;
      }
    }
    // If not returned in for loop means largest element is not present i.e.
    return arr.length;
  }

  // Important Note :
  // [4,0,1,2] whenever such case arise apply cyclic  sort , and whenever you see element whose
  // index will be out of bound just ignore it.
  private static void applyCyclicSort(int[] arr) {
    int i = 0;
    while (i < arr.length) {
      int correctIndex = arr[i];
      // If arr[i] > arr.length then ignore it ,i.e. out of bound exception
      if (arr[i] < arr.length && arr[i] != arr[correctIndex]) {
        swap(arr, i, correctIndex);
      } else {
        i++;
      }
    }
  }

  // Problem 2 : Find all numbers disappeared in an Array
  // https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/description/

  private static List<Integer> findDisappearedNumbers(int[] nums) {
    List<Integer> missingNumbers = new ArrayList<>();
    applyCyclicSortForDisappearedNumbers(nums);
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != i + 1) {
        missingNumbers.add(i + 1);
      }
    }
    return missingNumbers;
  }

  //  Problem 3: find the duplicate numbers
  //  https://leetcode.com/problems/find-the-duplicate-number/description/
  public static int findDuplicateElement(int[] nums) {
    applyCyclicSortForDuplicateElement(nums);
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != i + 1) {
        return nums[i];
      }
    }

    return -1;
  }

  //  Problem 4: find all the duplicate numbers
  //  https://leetcode.com/problems/find-all-duplicates-in-an-array/description/
  public static List<Integer> findAllDuplicateElement(int[] nums) {
    // Question is saying that each element appears once or twice ,so no need to use hashset
    //    Set<Integer> missing = new HashSet<>();
    List<Integer> missing = new ArrayList<>();
    applyCyclicSortForDuplicateElement(nums);
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != i + 1) {
        missing.add(nums[i]);
      }
    }

    //    for (int ele : missing) {
    //      arr.add(ele);
    //    }
    return missing;
  }

  //  Problems 5: Set Mismatch
  //  https://leetcode.com/problems/set-mismatch/description/

  public static int[] findErrorNums(int[] nums) {
    applyCyclicSortForDuplicateElement(nums);
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != i + 1) {
        return new int[] {nums[i], i + 1};
      }
    }
    return new int[] {-1, -1};
  }

  // Problem 6: First Missing Positive
  //  https://leetcode.com/problems/first-missing-positive/description/
  public static int firstMissingPositive(int[] nums) {
    applyCyclicSortForFirstMissingPositive(nums);
    // case 1
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != i + 1) {
        return i + 1;
      }
    }
    // case 2
    return nums.length + 1;
  }

  private static void applyCyclicSortForFirstMissingPositive(int[] nums) {

    int i = 0;
    while (i < nums.length) {
      int correctIndex = nums[i] - 1; // correct index of the element 'nums[i]'
      // nums[i] > 0 &&  nums[i] < nums.length  this is to ignore cyclic sorting for elements<=0 or
      // greater than length
      if (nums[i] > 0 && nums[i] < nums.length && nums[i] != nums[correctIndex]) {
        swap(nums, i, correctIndex);
      } else {
        i++;
      }
    }
  }

  // for [1,n]
  private static void applyCyclicSortForDuplicateElement(int[] nums) {

    int i = 0;
    while (i < nums.length) {
      int correctIndex = nums[i] - 1; // correct index of the element 'nums[i]'
      if (nums[i] != nums[correctIndex]) {
        swap(nums, i, correctIndex);
      } else {
        i++;
      }
    }
  }

  private static void applyCyclicSortForDisappearedNumbers(int[] nums) {
    int i = 0;
    while (i < nums.length) {
      int correctIndex = nums[i] - 1;
      // it is giving the correct index of value present at ith index
      // we should ignore if current index and correct index values are same.If we swap then it will
      // go into infinite loop
      // For ex: [5,2,3,4,5,5,5]  Here infinite may occur as 5 is at its correct position and its on
      // zero index also
      if (nums[i] != nums[correctIndex]) {
        swap(nums, i, correctIndex);
      } else {
        i++;
      }
    }
  }

  private static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
}
