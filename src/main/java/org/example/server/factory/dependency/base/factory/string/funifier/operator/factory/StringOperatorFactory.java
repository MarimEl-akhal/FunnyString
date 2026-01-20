package org.example.server.factory.dependency.base.factory.string.funifier.operator.factory;

import org.example.server.factory.dependency.base.factory.BaseFactory;
import org.example.server.service.operator.StringOperator;

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
