package org.example.server.service;

import org.example.server.factory.dependency.FactoryDependency;
import org.example.io.method.input.InputStrategy;
import org.example.io.method.output.OutputStrategy;
import org.example.server.string.funifier.controller.RouterStrategyInterface;

import java.io.IOException;
import java.util.List;

public class Router {

    public Router() {
    }

    public void execute(
            InputStrategy inputStrategy,
            OutputStrategy outputStrategy
    ) throws IOException {
        List<RouterStrategyInterface> routerStrategies = FactoryDependency.getDependencies(RouterStrategyInterface.class);

        while (true) {
            String option = inputStrategy.read().toUpperCase();
            for (RouterStrategyInterface strategy : routerStrategies) {
                if (option.equals(strategy.getOptionName().name())) {
                    strategy.run(inputStrategy, outputStrategy);
                    break;
                }
            }

        }
    }

}

