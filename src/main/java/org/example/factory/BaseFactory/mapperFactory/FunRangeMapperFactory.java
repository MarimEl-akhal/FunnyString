package org.example.factory.BaseFactory.mapperFactory;

import org.example.factory.BaseFactory.BaseFactory;
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
