package org.example.factory.BaseFactory.mapperFactory;

import org.example.factory.BaseFactory.BaseFactory;
import org.example.mapper.FunnyStringMapper;

public class FunnyStringMapperFactory implements BaseFactory<FunnyStringMapper> {
    private FunnyStringMapper mapper;

    @Override
    public FunnyStringMapper createInstance() {
        if (mapper == null) {
            mapper = new FunnyStringMapper();
        }
        return mapper;
    }
}
