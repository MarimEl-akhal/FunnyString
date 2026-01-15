package org.example.decorator;

import org.example.strategy.input.InputStrategy;
import org.example.strategy.output.OutputStrategy;

public abstract class Decorator implements RouterStrategy {
    protected RouterStrategy wrapper;

    public Decorator(RouterStrategy routerStrategy) {
        this.wrapper = routerStrategy;
    }

    @Override
    public String getOptionName() {
        return wrapper.getOptionName();
    }

    @Override
    public void run(InputStrategy in, OutputStrategy out) {
        wrapper.run(in, out);
    }
}