package org.example.factory;

import org.example.mapper.FunRangeMapper;


import java.io.IOException;

public class FunRangeMapperFactory implements BaseFactory<FunRangeMapper> {
    private FunRangeMapper mapper;

    @Override
    public FunRangeMapper createInstance() throws IOException {
        if (mapper == null) {
            mapper = new FunRangeMapper();
        }
        return mapper;
    }
}
