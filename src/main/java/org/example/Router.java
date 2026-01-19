package org.example;

import org.example.routerStrategyDecorator.stringFunifierStrategy.RouterStrategy;
import org.example.factory.FactoryDependency;
import org.example.inputOutputSystem.input.InputStrategy;
import org.example.inputOutputSystem.output.OutputStrategy;

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

