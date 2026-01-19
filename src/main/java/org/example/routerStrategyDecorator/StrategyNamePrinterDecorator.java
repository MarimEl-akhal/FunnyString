package org.example.routerStrategyDecorator;

import org.example.routerStrategyDecorator.stringFunifierStrategy.RouterStrategy;
import org.example.inputOutputSystem.input.InputStrategy;
import org.example.inputOutputSystem.output.OutputStrategy;

import java.io.IOException;

public class StrategyNamePrinterDecorator extends RouterStrategyDecorator {
    public StrategyNamePrinterDecorator(RouterStrategy routerStrategy) {
        super(routerStrategy);
    }

    @Override
    public void run(InputStrategy inputStrategy,
                    OutputStrategy outputStrategy) throws IOException {

        outputStrategy.print("Strategy " + getOptionName() + " is running");
        wrapper.run(inputStrategy, outputStrategy);
    }

}
