package org.example.factory.strategyfactory;

import org.example.factory.BaseFactory;
import org.example.operator.StringOperator;

public class StringOperatorFactory implements BaseFactory<StringOperator> {
    private StringOperator stringOperator;

    @Override
    public StringOperator createInstance() {
        if (stringOperator == null) {
            return new StringOperator();
        }
        return stringOperator;
    }
}
