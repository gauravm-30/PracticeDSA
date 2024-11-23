package org.practice.datatypes.Enums;

/*
* This code works, but it isn’t very pretty. It won’t compile without the throw
 statement because the end of the method is technically reachable, even though it
 will never be reached [JLS, 14.21]. Worse, the code is fragile. If you add a new
 enum constant but forget to add a corresponding case to the switch, the enum will
 still compile, but it will fail at runtime when you try to apply the new operation.
Luckily, there is a better way to associate a different behavior with each enum
 constant: declare an abstract apply method in the enum type, and override it with
 a concrete method for each constant in a constant-specific class body. Such methods are known as constant-specific method implementations:
* */
public enum OperationV1 {
    PLUS,
    MINUS,
    TIMES,
    DIVIDE;

    public double apply(double x ,double y){
        switch (this){
            case PLUS -> {
                return x+y;
            }
            case MINUS -> {
                return x-y;
            }
            case TIMES -> {
                return x*y;
            }
            case DIVIDE -> {
                return x/y;
            }
        }
        throw new AssertionError("Unknown Operation" + this);
    }
}
