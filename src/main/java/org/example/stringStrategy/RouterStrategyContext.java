package org.example.stringStrategy;

import org.example.strategy.input.InputStrategy;
import org.example.strategy.output.OutputStrategy;

import java.io.IOException;

public class RouterStrategyContext {
    private RouterStrategy routerStrategy;

    public void setRouterStrategy(RouterStrategy routerStrategy) {
        this.routerStrategy = routerStrategy;
    }

    public void doStrategy(InputStrategy inputStrategy, OutputStrategy outputStrategy){
        try {
            routerStrategy.run(inputStrategy,outputStrategy);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
