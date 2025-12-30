package org.example.factory;

import org.example.*;
import org.example.database.DataBaseManager;
import org.example.operator.StringOperator;


public class FactoryDependency {
    public static <T> T getDependency(Class<T> className) {

        if (className == StringOperator.class) {
            return (T) new StringOperatorFactory().createInstance();
        } else if (className == StringFunifier.class) {
            return (T) new StringFunifierFactory().createInstance();
        } else if (className == Parsing.class) {
            return (T) new ParsingFactory().createInstance();
        } else if (className == DataBaseManager.class) {
            return (T) new DataBaseManagerFactory().createInstance();
        }

        return null;
    }
}

