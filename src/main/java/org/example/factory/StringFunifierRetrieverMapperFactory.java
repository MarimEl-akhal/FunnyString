package org.example.factory;

import org.example.mapper.FunRangeMapper;
import org.example.mapper.StringFunifierRetrieverMapper;

import java.io.IOException;

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
