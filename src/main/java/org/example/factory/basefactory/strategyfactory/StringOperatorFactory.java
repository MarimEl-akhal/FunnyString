package org.example.factory.basefactory.strategyfactory;

import org.example.factory.basefactory.BaseFactory;
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
