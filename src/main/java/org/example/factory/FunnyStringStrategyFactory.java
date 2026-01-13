package org.example.factory;

import org.example.stringStrategy.FunnyStringStrategy;

import java.io.IOException;

public class FunnyStringStrategyFactory implements BaseFactory<FunnyStringStrategy> {
    private FunnyStringStrategy funnyStringStrategy;

    @Override
    public FunnyStringStrategy createInstance() {
        if (funnyStringStrategy == null) {
            funnyStringStrategy = new FunnyStringStrategy();
        }
        return funnyStringStrategy;
    }
}
