package org.example;

import org.example.decorator.StringComponent;
import org.example.decorator.Basic;
import org.example.decorator.StringDecorator;
import org.example.factory.FactoryDependency;
import org.example.strategy.input.InputStrategy;
import org.example.strategy.output.OutputStrategy;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class Router {

    public Router() {
    }

    public void execute(
            InputStrategy inputStrategy,
            OutputStrategy outputStrategy
    ) throws IOException {
        List<StringComponent> routerStrategies = Collections.singletonList(FactoryDependency.getDependency(StringComponent.class));

        while (true) {
            String option = inputStrategy.read().toUpperCase();
            for (StringComponent strategy : routerStrategies) {
//                System.out.println(strategy.getOptionName());
                if (option.equals(strategy.getOptionName())) {
                    strategy.getOptionName();
                    strategy.run(inputStrategy, outputStrategy);
                    break;
                }
            }

        }
    }

}

