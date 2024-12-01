package org.practice.strings;

public class IntToRoman {
    public static void main(String[] args){
        int number = 1234;
    System.out.println(intToRoman(number));
    }

    //Constraint:
    //number 1 <= num <= 3999
    //because roman number have limit
    private static String intToRoman(int num) {

        //Create Mapping of roman symbols and their associated numerals
        StringBuilder roman = new StringBuilder();
        //Create Mapping of roman symbols and their associated numerals from largest to smaller
        String[] romanSymbols = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int[] romanNumerals={1000,900,500,400,100,90,50,40,10,9,5,4,1};
        for(int i = 0 ; i<13;i++){

            //takes place when remainder becomes zero for ex - 1200
            if(num == 0){
                break;
            }
            int times = num/romanNumerals[i];
            while(times>0){
                roman.append(romanSymbols[i]);
                times--;
            }
            num = num%romanNumerals[i];
        }
        return roman.toString();


    }
}
