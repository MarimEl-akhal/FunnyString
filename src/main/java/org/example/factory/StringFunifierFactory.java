package org.example.factory;

import org.example.StringFunifier;

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
