package org.example.server.factory.dependency.base.factory.string.funifier.strategy.factory;

import org.example.server.factory.dependency.base.factory.BaseFactory;
import org.example.server.string.funifier.controller.FunnyStringStrategy;

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
