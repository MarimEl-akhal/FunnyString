package org.example.factory.basefactory.strategyfactory;

import org.example.StringFunifier;
import org.example.factory.basefactory.BaseFactory;

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
