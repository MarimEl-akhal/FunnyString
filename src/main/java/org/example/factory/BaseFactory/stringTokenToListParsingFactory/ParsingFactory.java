package org.example.factory.BaseFactory.stringTokenToListParsingFactory;

import org.example.factory.BaseFactory.BaseFactory;
import org.example.stringTokenToListParsing.IParsing;
import org.example.stringTokenToListParsing.Parsing;

public class ParsingFactory implements BaseFactory<IParsing> {
    private IParsing parsing;

    @Override
    public IParsing createInstance() {
        if (parsing == null) {
            return new Parsing();
        }
        return parsing;
    }
}
