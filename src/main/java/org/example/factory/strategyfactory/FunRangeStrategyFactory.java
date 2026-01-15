package org.example.factory.strategyfactory;

import org.example.factory.BaseFactory;
import org.example.stringStrategy.FunRangeStrategy;

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
