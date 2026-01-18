package org.example.decorator;

import org.example.strategy.input.InputStrategy;
import org.example.strategy.output.OutputStrategy;

import java.io.IOException;

public class StrategyExecutionDecorator extends RouterDecorator {
    public StrategyExecutionDecorator(RouterStrategy routerStrategy) {
        super(routerStrategy);
    }

    @Override
    public void run(InputStrategy inputStrategy,
                    OutputStrategy outputStrategy) throws IOException {
        wrapper.run(inputStrategy, outputStrategy);
    }
}
