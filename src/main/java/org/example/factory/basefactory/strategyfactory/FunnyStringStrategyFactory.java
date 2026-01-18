package org.example.factory.basefactory.strategyfactory;

import org.example.factory.basefactory.BaseFactory;
import org.example.stringStrategy.FunnyStringStrategy;

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
