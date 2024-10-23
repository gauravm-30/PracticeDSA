package org.practice.datatypes.IntegerAndInt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntegerAndIntConversion {
    public static void main(String[] args) {
        AutoBoxingAndAutoUnboxing();
        intArrayToIntegerList();
        IntegerListToIntArray();
    }

    private static void IntegerListToIntArray() {
        List<Integer> arr1 = Arrays.asList(1,2,3,4,6);
        int[] arr = getintArrayFromIntegerList(arr1);
    }

    private static void AutoBoxingAndAutoUnboxing() {
        //auto boxing and auto unboxing
        int a1 =5;
        Integer a2 = a1;
        a1 = a2;
    }

    private static void IntegerArrayToIntegerList(){
        Integer[] arr = {1,2,3,4,5};
        //Convert in into List<Integer>
        List<Integer> arr2 = Arrays.asList(arr);
    }

    private static void intArrayToIntegerList(){
        int[] arr = {1,2,3,4,5};
        //Convert in into List<Integer>
        List<Integer> arr2 =getIntegerList(arr);
    }

    private static List<Integer> getIntegerList(int[] arr) {
        List<Integer> arr2 = new ArrayList<>();
//        for (int i = 0; i < arr.length; i++) {
//            arr2.add(arr[i]);
//        }
        for(int value : arr){
            arr2.add(value);
        }
        return arr2;
    }

    private static int[] getintArrayFromIntegerList(List<Integer> arr1){
        int[] arr = new int[arr1.size()];
        for (int i =0; i < arr.length; i++) {
            arr[i] = arr1.get(i);
        }
        return arr;

    }
}
