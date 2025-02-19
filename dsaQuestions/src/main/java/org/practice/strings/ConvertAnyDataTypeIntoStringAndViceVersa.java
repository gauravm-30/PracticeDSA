package org.practice.strings;

public class ConvertAnyDataTypeIntoStringAndViceVersa {
    public static void main(String[] args){
        primitiveDataTypeIntoString();
        WrapperClassesToString();
        StringToPrimitive();
        StringToWrapperClasses();
    }

    private static void StringToWrapperClasses() {
        String s1 = "true";
        Boolean b = Boolean.valueOf(s1);
        boolean b1 = b.booleanValue();

    }

    private static void StringToPrimitive() {
        String strInt = "123";
        int intValue = Integer.parseInt(strInt); // intValue will be 123

        String strFloat = "3.14";
        float floatValue = Float.parseFloat(strFloat); // floatValue will be 3.14

        String strBoolean = "true";
        boolean booleanValue = Boolean.parseBoolean(strBoolean); // booleanValue will be true
    }



    private static void WrapperClassesToString() {
        Short s = 117;
        Byte bt = 23;
        Integer i = 123;
        Long l = 123L;

        Boolean b =true;

        Float f = 123.12F;
        Double d = 123.56;

        //Below called the String.valueOf(Object o) because above acts as objects and toString of specified classes are called
        String ss= String.valueOf(s);
        String bts= String.valueOf(bt);
        String is= String.valueOf(i);
        String ls= String.valueOf(l);
        String bs= String.valueOf(b);
        String fs= String.valueOf(f);
        String ds= String.valueOf(d);



    }

    private static void primitiveDataTypeIntoString() {
        String booleanDataType = String.valueOf(true);
        String charDataType = String.valueOf('a');
        String doubleDataType = String.valueOf(123.123);
        String floatDataType = String.valueOf(123.12F);
        String longDataType = String.valueOf(123L);
        String intDataType = String.valueOf(123);

        //short and byte values 123 and 35 upcasted to int first
        // and then valueOf function is applied
        String shortDataType = String.valueOf((short)123);
        String byteDataType = String.valueOf((byte)35);


    }
}
