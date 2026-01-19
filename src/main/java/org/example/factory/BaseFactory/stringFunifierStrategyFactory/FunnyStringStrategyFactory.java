package org.example.factory.BaseFactory.stringFunifierStrategyFactory;

import org.example.factory.BaseFactory.BaseFactory;
import org.example.routerStrategyDecorator.stringFunifierStrategy.FunnyStringStrategy;

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
