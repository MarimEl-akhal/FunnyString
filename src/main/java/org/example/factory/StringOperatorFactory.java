package org.example.factory;

import org.example.StringOperator;

public class StringOperatorFactory implements BaseFactory<StringOperator>{
    @Override
    public StringOperator createInstance() {
        return new StringOperator();
    }
}
