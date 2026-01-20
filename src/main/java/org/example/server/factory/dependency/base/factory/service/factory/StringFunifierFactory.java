package org.example.server.factory.dependency.base.factory.service.factory;

import org.example.server.factory.dependency.base.factory.BaseFactory;
import org.example.server.service.StringFunifier;

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
