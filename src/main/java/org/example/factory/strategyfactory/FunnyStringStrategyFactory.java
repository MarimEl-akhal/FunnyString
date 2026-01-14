package org.example.factory.strategyfactory;

import org.example.factory.BaseFactory;
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
