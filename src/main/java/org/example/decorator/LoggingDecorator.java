package org.example.decorator;


import org.example.strategy.input.InputStrategy;
import org.example.strategy.output.OutputStrategy;

import java.io.IOException;

public class LoggingDecorator
        extends RouterDecorator {

    public LoggingDecorator(RouterStrategy routerStrategy) {
        super(routerStrategy);
    }

    @Override
    public void run(InputStrategy inputStrategy,
                    OutputStrategy outputStrategy) throws IOException {

        outputStrategy.print("You logged in Strategy " + getOptionName());
//        System.out.println("You logged in Strategy " + getOptionName() );
        wrapper.run(inputStrategy, outputStrategy);
    }
}
