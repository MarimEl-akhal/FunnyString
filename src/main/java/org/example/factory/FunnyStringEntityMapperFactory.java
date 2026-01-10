package org.example.factory;

import org.example.mapper.FunnyStringEntityMapper;

import java.io.IOException;

public class FunnyStringEntityMapperFactory implements BaseFactory<FunnyStringEntityMapper> {
    private FunnyStringEntityMapper mapper;

    @Override
    public FunnyStringEntityMapper createInstance() throws IOException {
        if (mapper == null) {
            mapper = new FunnyStringEntityMapper();
        }
        return mapper;
    }
}
