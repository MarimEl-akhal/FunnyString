package org.example.Task1;

public class Bringer {
    private static StringOperator stringOperator;

    public static StringOperator getStringOperator() {
        if (stringOperator == null) {
            stringOperator = new StringOperator();
        }
        return stringOperator;
    }
}
