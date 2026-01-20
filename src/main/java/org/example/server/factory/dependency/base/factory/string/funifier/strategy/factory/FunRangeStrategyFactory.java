package org.example.server.factory.dependency.base.factory.string.funifier.strategy.factory;

import org.example.server.factory.dependency.base.factory.BaseFactory;
import org.example.server.string.funifier.controller.FunRangeStrategy;

public class FunRangeStrategyFactory implements BaseFactory<FunRangeStrategy> {
    private FunRangeStrategy funRangeStrategy;

    @Override
    public FunRangeStrategy createInstance() {
        if (funRangeStrategy == null) {
            funRangeStrategy = new FunRangeStrategy();
        }
        return funRangeStrategy;
    }
}
