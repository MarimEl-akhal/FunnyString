package org.example.Task1;

public class Factory {
    private static StringOperator stringOperator;

    public static StringOperator getDependency(Class<StringOperator> stringOperatorClass) {
        if (stringOperator == null) {
            stringOperator = new StringOperator();
        }
        return stringOperator;    }
}
