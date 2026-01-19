package org.example.factory.BaseFactory.mapperFactory;

import org.example.factory.BaseFactory.BaseFactory;
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
