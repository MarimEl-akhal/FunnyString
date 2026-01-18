package org.example;

import org.example.decorator.RouterStrategy;
import org.example.factory.FactoryDependency;
import org.example.strategy.input.InputStrategy;
import org.example.strategy.output.OutputStrategy;

import java.io.IOException;
import java.util.List;

public class Router {

    public Router() {
    }

    public void execute(
            InputStrategy inputStrategy,
            OutputStrategy outputStrategy
    ) throws IOException {
        List<RouterStrategy> routerStrategies = FactoryDependency.getDependencies(RouterStrategy.class);

        while (true) {
            String option = inputStrategy.read().toUpperCase();
            for (RouterStrategy strategy : routerStrategies) {
                if (option.equals(strategy.getOptionName().name())) {
                    strategy.run(inputStrategy, outputStrategy);
                    break;
                }
            }

        }
    }

}

