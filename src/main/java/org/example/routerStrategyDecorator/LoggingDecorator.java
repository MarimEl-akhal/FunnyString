package org.example.routerStrategyDecorator;


import org.example.routerStrategyDecorator.stringFunifierStrategy.RouterStrategy;
import org.example.inputOutputSystem.input.InputStrategy;
import org.example.inputOutputSystem.output.OutputStrategy;

import java.io.IOException;

public class LoggingDecorator
        extends RouterStrategyDecorator {

    public LoggingDecorator(RouterStrategy routerStrategy) {
        super(routerStrategy);
    }

    @Override
    public void run(InputStrategy inputStrategy,
                    OutputStrategy outputStrategy) throws IOException {

        outputStrategy.print("You logged in Strategy " + getOptionName());
        wrapper.run(inputStrategy, outputStrategy);
    }
}
