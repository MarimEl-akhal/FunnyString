package org.example.decorator;

import org.example.strategy.input.InputStrategy;
import org.example.strategy.output.OutputStrategy;

public class OperationNamePrinterDecorator extends Decorator {

    public OperationNamePrinterDecorator(RouterStrategy routerStrategy) {
        super(routerStrategy);
    }

    @Override
    public void run(InputStrategy in, OutputStrategy out) {
        out.print("Operation : " + getOptionName());
        super.run(in, out);
    }
}
