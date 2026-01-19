package org.example.routerStrategyDecorator;

import org.example.routerStrategyDecorator.stringFunifierStrategy.RouterStrategy;
import org.example.inputOutputSystem.input.InputStrategy;
import org.example.inputOutputSystem.output.OutputStrategy;

import java.io.IOException;

public class LogoutDecorator extends RouterStrategyDecorator {
    public LogoutDecorator(RouterStrategy routerStrategy) {
        super(routerStrategy);
    }

    @Override
    public void run(InputStrategy inputStrategy,
                    OutputStrategy outputStrategy) throws IOException {

        super.wrapper.run(inputStrategy, outputStrategy);
        outputStrategy.print("Strategy " + getOptionName() + " is finished");
    }
}
