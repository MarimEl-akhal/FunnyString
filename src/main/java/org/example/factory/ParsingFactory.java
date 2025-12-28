package org.example.factory;

import org.example.IParsing;
import org.example.Parsing;

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
