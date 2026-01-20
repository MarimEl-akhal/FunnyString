package org.example.server.string.funifier.controller.router.decorator;

import org.example.io.method.input.InputStrategy;
import org.example.io.method.output.OutputStrategy;
import org.example.server.string.funifier.controller.RouterStrategyInterface;

import java.io.IOException;

public class StrategyExecutionDecorator extends RouterStrategyDecorator {
    public StrategyExecutionDecorator(RouterStrategyInterface routerStrategy) {
        super(routerStrategy);
    }

    @Override
    public void run(InputStrategy inputStrategy,
                    OutputStrategy outputStrategy) throws IOException {
        super.wrapper.run(inputStrategy, outputStrategy);
    }
}
