package org.example.factory.strategyfactory;

import org.example.factory.BaseFactory;
import org.example.stringStrategy.StringFunifierIdRetrieverStrategy;

public class StringFunifierRetrieverFactory implements BaseFactory<StringFunifierIdRetrieverStrategy> {
    private StringFunifierIdRetrieverStrategy retrieverStrategy;

    @Override
    public StringFunifierIdRetrieverStrategy createInstance() {
        if (retrieverStrategy == null) {
            retrieverStrategy = new StringFunifierIdRetrieverStrategy();
        }
        return retrieverStrategy;
    }
}
