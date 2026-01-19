package org.example.factory.BaseFactory.stringFunifierStrategyFactory;

import org.example.factory.BaseFactory.BaseFactory;
import org.example.routerStrategyDecorator.stringFunifierStrategy.StringFunifierIdRetrieverStrategy;

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
