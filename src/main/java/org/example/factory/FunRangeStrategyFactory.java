package org.example.factory;

import org.example.stringStrategy.FunRangeStrategy;

import java.io.IOException;

public class FunRangeStrategyFactory implements BaseFactory<FunRangeStrategy> {
    private FunRangeStrategy funRangeStrategy;

    @Override
    public FunRangeStrategy createInstance()  {
        if (funRangeStrategy == null) {
            funRangeStrategy = new FunRangeStrategy();
        }
        return funRangeStrategy;
    }
}
