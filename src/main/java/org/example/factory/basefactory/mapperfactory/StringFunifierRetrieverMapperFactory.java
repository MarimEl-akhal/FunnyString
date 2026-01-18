package org.example.factory.basefactory.mapperfactory;

import org.example.factory.basefactory.BaseFactory;
import org.example.mapper.StringFunifierRetrieverMapper;

public class StringFunifierRetrieverMapperFactory implements BaseFactory<StringFunifierRetrieverMapper> {
    private StringFunifierRetrieverMapper mapper;

    @Override
    public StringFunifierRetrieverMapper createInstance() {
        if (mapper == null) {
            mapper = new StringFunifierRetrieverMapper();
        }
        return mapper;
    }
}
