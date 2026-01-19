package org.example.factory.BaseFactory.stringFunifierStrategyFactory;

import org.example.StringFunifier;
import org.example.factory.BaseFactory.BaseFactory;

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
