package org.example.server.factory.dependency.base.factory.string.funifier.parser.factory;

import org.example.server.factory.dependency.base.factory.BaseFactory;
import org.example.parser.ParserInterface;
import org.example.parser.Parser;

public class ParsingFactory implements BaseFactory<ParserInterface> {
    private ParserInterface parsing;

    @Override
    public ParserInterface createInstance() {
        if (parsing == null) {
            return new Parser();
        }
        return parsing;
    }
}
