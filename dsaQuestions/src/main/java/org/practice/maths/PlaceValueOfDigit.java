package org.practice.maths;

public class PlaceValueOfDigit {
    public static void main(String[] args){
        int number = -12045;
        int target = 0;
    System.out.println(getPlaceValue(number, target));
  }


  //Constraint :
  //Can be any number within int range
    // The place value of a digit in a number is a value that it holds at that place.
//     109 = 1*100 + 0*10 + 9*1;
//    Hence place value of the zero is 0;
    //target value should be non-negative between 0 to 9 ,it can be enum
    //number can be negative of positive;

  private static int getPlaceValue(int number, int target) {
        int placeFactor = 1 ;

        //make it positive
        if(number<0){
            number = number*(-1);
        }

        //if number is zero
        if(number==0){
            if(target==0){
                return 0 ;
            }
            return -1;
        }
        //means it is positive number
        while(number>0){
            int rem = number%10;
            if(rem==target){
                return rem*placeFactor;
            }
            else {
                placeFactor = placeFactor*10;
            }
            number=number/10;
        }
        //means not found
      return -1;
  }
}
