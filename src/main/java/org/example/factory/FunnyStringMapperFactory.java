package org.example.factory;

import org.example.mapper.FunnyStringMapper;

import java.io.IOException;

public class FunnyStringMapperFactory implements BaseFactory<FunnyStringMapper> {
    private FunnyStringMapper mapper;

    @Override
    public FunnyStringMapper createInstance() throws IOException {
        if (mapper == null) {
            mapper = new FunnyStringMapper();
        }
        return mapper;
    }
}
