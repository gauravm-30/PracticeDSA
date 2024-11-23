package org.practice.datatypes.Enums;

public enum OperationV2 {
    PLUS {
        @Override
        public double apply(double x, double y) {
            return x+y;
        }
    },
    MINUS {
        @Override
        public double apply(double x, double y) {
            return x-y;
        }
    },
    TIMES {
        @Override
        public double apply(double x, double y) {
            return x*y;
        }
    },
    DIVIDE {
        @Override
        public double apply(double x, double y) {
            return x/y;
        }
    };

    public abstract double apply(double x, double y);

    }

