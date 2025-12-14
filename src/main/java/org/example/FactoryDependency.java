package org.example;

public class FactoryDependency {

    public static <T> T getDependency(Class<T> className) {
        if (className == StringOperator.class) {
            return (T) new StringOperator();
        }
        if (className == DataBaseConnection.class ){
            return (T) new DataBaseConnection();
        }
        return null;
    }
}

