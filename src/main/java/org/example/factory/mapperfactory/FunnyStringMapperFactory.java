package org.example.factory.mapperfactory;

import org.example.factory.BaseFactory;
import org.example.mapper.FunnyStringMapper;

public class FunnyStringMapperFactory implements BaseFactory<FunnyStringMapper> {
    private FunnyStringMapper mapper;

    @Override
    public FunnyStringMapper createInstance()  {
        if (mapper == null) {
            mapper = new FunnyStringMapper();
        }
        return mapper;
    }
}
