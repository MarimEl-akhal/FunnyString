package org.example.server.factory.dependency.base.factory.string.funifier.strategy.factory;

import org.example.server.factory.dependency.base.factory.BaseFactory;
import org.example.server.string.funifier.controller.StringFunifierIdRetrieverStrategy;

public class StringFunifierIdRetrieverFactory implements BaseFactory<StringFunifierIdRetrieverStrategy> {
    private StringFunifierIdRetrieverStrategy retrieverStrategy;

    @Override
    public StringFunifierIdRetrieverStrategy createInstance() {
        if (retrieverStrategy == null) {
            retrieverStrategy = new StringFunifierIdRetrieverStrategy();
        }
        return retrieverStrategy;
    }
}
