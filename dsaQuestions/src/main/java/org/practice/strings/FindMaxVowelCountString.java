package org.practice.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class FindMaxVowelCountString {
    public static void main(String[] args) {
        String s1 = "I shall exit the auditorium in the next twenty minutes";
//        rearrange the  words based on max number of vowels . If same number of vowels are present then print in the same order
        s1 = s1.toLowerCase();
        rearrangeStrings(s1);

    }

    private static void rearrangeStrings(String s1) {
//       Arrays.asList() or List.of() creates unmodifiable list
        String[] stringArr = s1.split(" ");
        List<String> stringsList1 = new ArrayList<>(Arrays.asList(stringArr));
        List<Integer> vowelsCountList = getVowelsCountList(stringsList1);
//        getOutputV1(stringsList1,vowelsCountList);
        getOutputV2(stringsList1);


    }

    private static void getOutputV2(List<String> stringsList1) {
        Comparator<String> stringVowelsComparator = (s1,s2)->{
            int n1 = getVowelsCount(s1);
            int n2 = getVowelsCount(s2);
            if(n1<n2){
                return 1 ;
            }else if(n1==n2){
                return 0;
            }else {
                return -1;
            }
        };

        stringsList1.sort(stringVowelsComparator);
        System.out.println(stringsList1);

    }

    private static void getOutputV1(List<String> stringsList1, List<Integer> vowelsCountList) {
        List<String> outputString = new ArrayList<>();
        while (!stringsList1.isEmpty()){
            int maxIndex = findMaxVowelCountIndex(vowelsCountList);
            outputString.add(stringsList1.get(maxIndex));
            stringsList1.remove(maxIndex);
            vowelsCountList.remove(maxIndex);
        }
        System.out.println(outputString);
    }

    private static int findMaxVowelCountIndex(List<Integer> vowelsCountList) {
        int maxIndex = 0;
        for (int i = 1; i < vowelsCountList.size(); i++) {
            if(vowelsCountList.get(maxIndex)<vowelsCountList.get(i)){
                maxIndex= i;
            }
        }
        return maxIndex;
    }


    private static List<Integer> getVowelsCountList(List<String> stringsList1) {
        List<Integer> vowelsCountList = new ArrayList<>();
        for (String value : stringsList1){
            vowelsCountList.add(getVowelsCount(value));
        }
        return vowelsCountList;
    }

    private static Integer getVowelsCount(String value) {
        int count=0;
        for (int i = 0; i < value.length(); i++) {
            char ch = value.charAt(i);
            if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch =='u'){
                count++;
            }
        }
        return count;

    }


}
