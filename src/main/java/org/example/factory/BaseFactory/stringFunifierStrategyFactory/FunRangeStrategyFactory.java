package org.example.factory.BaseFactory.stringFunifierStrategyFactory;

import org.example.factory.BaseFactory.BaseFactory;
import org.example.routerStrategyDecorator.stringFunifierStrategy.FunRangeStrategy;

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
