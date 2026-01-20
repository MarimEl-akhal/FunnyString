package org.example.server.factory.dependency.base.factory.mapper.factory;

import org.example.server.factory.dependency.base.factory.BaseFactory;
import org.example.server.mapper.FunRangeMapper;

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
