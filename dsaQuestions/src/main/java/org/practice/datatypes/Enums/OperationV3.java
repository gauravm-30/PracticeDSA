package org.practice.datatypes.Enums;

public enum OperationV3 {
    PLUS("+") {
        @Override
        public double apply(double x, double y) {
            return x+y;
        }
    };

    private final String op;
    OperationV3(String op){
        this.op = op;
    }

    @Override
    public String toString(){
        return op;
    }
    public abstract double apply(double x, double y);


}
