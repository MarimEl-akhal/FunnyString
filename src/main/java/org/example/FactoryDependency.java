package org.example;

public class FactoryDependency {
    private static StringOperator operator;
    private static DataBaseConnection dbConnection;

    public static <T> T getDependency(Class<T> className) {
        if (className == StringOperator.class) {
            if (operator == null){
             operator =  new StringOperator();
            }
            return (T) operator;
        }
        if (className == DataBaseConnection.class) {
            if(dbConnection == null){
                dbConnection = new DataBaseConnection();
            }
            return (T) dbConnection;
        }
        return null;
    }
}

