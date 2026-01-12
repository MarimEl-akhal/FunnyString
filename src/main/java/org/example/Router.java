package org.example;

import org.example.factory.FactoryDependency;
import org.example.stringStrategy.*;
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
        StringFunifierStrategy funRangeStrategy = FactoryDependency.getDependency(FunRangeStrategy.class);
        StringFunifierStrategy funnyStringStrategy = FactoryDependency.getDependency(FunnyStringStrategy.class);
        StringFunifierStrategy funifierIdRetrieverStrategy = FactoryDependency.getDependency(StringFunifierIdRetrieverStrategy.class);
        List<StringFunifierStrategy> stringFunifierStrategies = List.of(funRangeStrategy,funnyStringStrategy,funifierIdRetrieverStrategy);

        while (true) {
            String option = inputStrategy.read().toUpperCase();

            for (StringFunifierStrategy strategy : stringFunifierStrategies) {
                if (option.equals(strategy.getOptionName().name())) {
                    strategy.run(inputStrategy, outputStrategy);
                    break;
                }
            }

        }
    }

}

