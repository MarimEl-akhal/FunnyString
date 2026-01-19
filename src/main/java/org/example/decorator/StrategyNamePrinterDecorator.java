package org.example.decorator;

import org.example.strategy.input.InputStrategy;
import org.example.strategy.output.OutputStrategy;

import java.io.IOException;

public class StrategyNamePrinterDecorator extends RouterDecorator {
    public StrategyNamePrinterDecorator(RouterStrategy routerStrategy) {
        super(routerStrategy);
    }

    @Override
    public void run(InputStrategy inputStrategy,
                    OutputStrategy outputStrategy) throws IOException {

        outputStrategy.print("Strategy " + getOptionName() + " is running");
//        System.out.println("Strategy " + getOptionName() +" is running" );
        wrapper.run(inputStrategy, outputStrategy);
    }

}
