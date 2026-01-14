package org.example.factory.strategyfactory;

import org.example.StringFunifier;
import org.example.factory.BaseFactory;

public class StringFunifierFactory implements BaseFactory<StringFunifier> {
    private StringFunifier stringFunifier;

    @Override
    public StringFunifier createInstance() {
        if (stringFunifier == null) {
            return new StringFunifier();
        }
        return stringFunifier;
    }
}
