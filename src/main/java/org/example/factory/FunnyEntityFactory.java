package org.example.factory;

import org.example.entity.FunnyStringEntity;

import java.io.IOException;

public class FunnyEntityFactory implements BaseFactory<FunnyStringEntity> {
    private FunnyStringEntity funnyStringEntity;

    @Override
    public FunnyStringEntity createInstance()  {
        if (funnyStringEntity == null) {
            funnyStringEntity = new FunnyStringEntity();
        }
        return funnyStringEntity;
    }
}
