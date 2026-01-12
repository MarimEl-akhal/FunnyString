package org.example.stringStrategy;

import org.example.strategy.input.InputStrategy;
import org.example.strategy.output.OutputStrategy;

import java.io.IOException;

public class StringFunifierContext {
    private Strategy strategy;

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void doStrategy(InputStrategy inputStrategy, OutputStrategy outputStrategy) throws IOException {
        strategy.run(inputStrategy, outputStrategy);
    }

}
