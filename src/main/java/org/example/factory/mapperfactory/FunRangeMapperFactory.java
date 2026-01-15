package org.example.factory.mapperfactory;

import org.example.factory.BaseFactory;
import org.example.mapper.FunRangeMapper;

public class FunRangeMapperFactory implements BaseFactory<FunRangeMapper> {
    private FunRangeMapper mapper;

    @Override
    public FunRangeMapper createInstance() {
        if (mapper == null) {
            mapper = new FunRangeMapper();
        }
        return mapper;
    }
}
