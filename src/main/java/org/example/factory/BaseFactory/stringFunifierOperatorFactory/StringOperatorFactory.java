package org.example.factory.BaseFactory.stringFunifierOperatorFactory;

import org.example.factory.BaseFactory.BaseFactory;
import org.example.stringFunifierOperator.StringOperator;

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
