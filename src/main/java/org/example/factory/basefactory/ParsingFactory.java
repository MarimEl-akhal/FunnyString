package org.example.factory.basefactory;

import org.example.parsingg.IParsing;
import org.example.parsingg.Parsing;

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
