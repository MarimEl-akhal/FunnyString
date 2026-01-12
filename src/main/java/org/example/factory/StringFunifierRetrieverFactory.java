package org.example.factory;

import org.example.stringStrategy.StringFunifierIdRetrieverStrategy;

import java.io.IOException;

public class StringFunifierRetrieverFactory implements BaseFactory<StringFunifierIdRetrieverStrategy>{
    private StringFunifierIdRetrieverStrategy retrieverStrategy;

    @Override
    public StringFunifierIdRetrieverStrategy createInstance() throws IOException {
        if (retrieverStrategy == null) {
            retrieverStrategy = new StringFunifierIdRetrieverStrategy();
        }
        return retrieverStrategy;
    }
}
