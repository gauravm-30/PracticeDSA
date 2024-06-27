package org.practice.searching.BinarySearch;

public class BinarySearchLeetCodePart1 {

  // Problem one : https://leetcode.com/problems/find-smallest-letter-greater-than-target/descripti
  /*Find the smallest letter greater than target */
  /*Given that array letters are in non-decreasing order*/
  /*OR letters are wrap around if
  Input: letters = ["c","f","j"], target = "j"
  Output: "c"
  */
  private static char nextGreatestChar(char[] letters, char target) {
    // In leetcode we need to avoid this condition
    if (letters == null || letters.length == 0) {
      return Character.MIN_VALUE;
    }
    int startIndex = 0;
    int endIndex = letters.length - 1;

    // wrap around condition
    if (target >= letters[endIndex]) {
      return letters[startIndex];
    }

    while (startIndex <= endIndex) {
      int midIndex = startIndex + (endIndex - startIndex) / 2;

      if (target < letters[midIndex]) {
        endIndex = midIndex - 1;
      } else {
        // when target is greater than or equal to !!
        startIndex = midIndex + 1;
      }
    }

    return letters[startIndex];
    // OR Use below
    //    return letters[startIndex % letters.length];
  }

  /*Find the greatest letter smaller than target */
  /*Given that array letters are in non-decreasing order*/
  private static char prevSmallestChar(char[] letters, char target) {
    // In leetcode we need to avoid this condition
    if (letters == null || letters.length == 0) {
      return Character.MIN_VALUE;
    }
    int startIndex = 0;
    int endIndex = letters.length - 1;

    while (startIndex <= endIndex) {
      int midIndex = startIndex + (endIndex - startIndex) / 2;
      // when target is smaller than or equal to midValue
      if (target <= letters[midIndex]) {
        endIndex = midIndex - 1;
      } else {
        // when target is greater than
        startIndex = midIndex + 1;
      }
    }
    // I think it should be endIndex here
    return letters[endIndex % letters.length];
  }

  // Problem 2:
  // https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/
  /*Find the first and last position of the element in sorted array*/

  public static int findElementPosInInfiniteArray(int[] infiniteArr, int target) {
    // initially we will put start and end as 0 and  1
    // and then we will double the search space if not found
    int startIndex = 0;
    int endIndex = 1;
    // if target element is greater than the endIndex then no need to check the in
    // that range and update the range.
    while (target > infiniteArr[endIndex]) {
      int newStart = endIndex + 1;
      endIndex = endIndex + 2 * (endIndex - (startIndex - 1));
      startIndex = newStart;
    }

    return binarSearchInInfiniteArr(infiniteArr, target, startIndex, endIndex);
  }

  private static int binarSearchInInfiniteArr(
      int[] infiniteArr, int target, int startIndex, int endIndex) {
    while (startIndex <= endIndex) {
      int midIndex = startIndex + (endIndex - startIndex) / 2;
      if (target == infiniteArr[midIndex]) {
        return midIndex;
      } else if (target < infiniteArr[midIndex]) {
        endIndex = midIndex - 1;
      } else {
        startIndex = midIndex + 1;
      }
    }
    return -1;
  }

  public int[] findFirstAndLastIndex(int[] nums, int target) {
    return searchRange(nums, target);
  }

  /* Find the position of element in a sorted array of infinite numbers
   * Now imagine the array is infinite means you can't use the arr.length function
   * Since array is infinite there will be no question of arrayIndexOutOfBoundException
   * We don't need to care about the OutOfBoundException
   *
   * Till now, we are reducing the search space every time if we don't  find the target element
   * Now we will increase the search space every time ,if we don't find the element
   * bottom-up approach
   */

  /*if target not found return [-1,-1]*/
  /*First find the first occurrence of the element
   * if found, find the last occurrence of the element */
  public int[] searchRange(int[] nums, int target) {
    int[] range = {-1, -1};
    if (nums == null || nums.length == 0) {
      return new int[] {-1, -1};
    }
    range[0] = searchOccurence(nums, target, true);

    // means element is there
    if (range[0] != -1) {
      range[1] = searchOccurence(nums, target, false);
    }
    return range;
  }

  private int searchOccurence(int[] nums, int target, boolean isStartIndex) {
    int ans = -1;
    int sIndex = 0;
    int eIndex = nums.length - 1;
    while (sIndex <= eIndex) {
      int mid = sIndex + (eIndex - sIndex) / 2;
      if (target == nums[mid]) {
        ans = mid;

        // checking if startIndex is required
        if (isStartIndex) {
          eIndex = mid - 1;
        } else {
          sIndex = mid + 1;
        }
      } else if (target < nums[mid]) {
        eIndex = mid - 1;
      } else {
        sIndex = mid + 1;
      }
    }
    return ans;
  }
}
