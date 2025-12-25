package org.example.factory;

import org.example.IParsing;
import org.example.Parsing;

public class ParsingFactory implements BaseFactory<IParsing> {
    @Override
    public IParsing createInstance() {
        return  new Parsing();
    }
}
