package org.example.server.factory.dependency.base.factory.mapper.factory;

import org.example.server.factory.dependency.base.factory.BaseFactory;
import org.example.server.mapper.FunnyStringMapper;

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
