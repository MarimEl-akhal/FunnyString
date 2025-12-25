package org.example.factory;

import org.example.StringFunifier;

public class StringFunifierFactory implements BaseFactory<StringFunifier> {
    @Override
    public StringFunifier createInstance() {
        return new StringFunifier();
    }
}
