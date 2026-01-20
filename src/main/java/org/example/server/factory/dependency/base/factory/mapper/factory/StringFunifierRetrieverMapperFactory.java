package org.example.server.factory.dependency.base.factory.mapper.factory;

import org.example.server.factory.dependency.base.factory.BaseFactory;
import org.example.server.mapper.StringFunifierRetrieverMapper;

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
