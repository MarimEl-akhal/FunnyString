package org.example.factory;

import org.example.abstraction.StringFunifierContext;

import java.io.IOException;

public class StringFunifierContextFactory implements BaseFactory<StringFunifierContext> {
    private StringFunifierContext stringFunifierContext;

    @Override
    public StringFunifierContext createInstance() throws IOException {
        if (stringFunifierContext == null) {
            stringFunifierContext = new StringFunifierContext();
        }
        return stringFunifierContext;
    }
}
