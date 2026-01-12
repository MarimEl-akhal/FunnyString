package org.example;

import org.example.abstraction.FunRangeStrategy;
import org.example.abstraction.FunnyStringStrategy;
import org.example.abstraction.StringFunifierContext;
import org.example.abstraction.StringFunifierIdRetrieverStrategy;
import org.example.factory.FactoryDependency;
import org.example.socket_v2.server.ClientOption;
import org.example.strategy.input.InputStrategy;
import org.example.strategy.output.OutputStrategy;

import java.io.IOException;

public class Service {

    private final StringFunifierContext stringFunifierContext;

    public Service() {
        this.stringFunifierContext = FactoryDependency.getDependency(StringFunifierContext.class);
    }

    public void execute(
            InputStrategy inputStrategy,
            OutputStrategy outputStrategy
    ) throws IOException {

        while (true) {
            String option = inputStrategy.read().toUpperCase();
            switch (ClientOption.valueOf(option)) {
                case FUNRANGE -> {
                    stringFunifierContext.setStrategy(new FunRangeStrategy());
                    stringFunifierContext.doStrategy(inputStrategy, outputStrategy);

                }
                case FUNNYSTRING -> {
                    stringFunifierContext.setStrategy(new FunnyStringStrategy());
                    stringFunifierContext.doStrategy(inputStrategy, outputStrategy);
                }
                case GET_FUNRANGEBYID -> {
                    stringFunifierContext.setStrategy(new StringFunifierIdRetrieverStrategy());
                    stringFunifierContext.doStrategy(inputStrategy, outputStrategy);
                }
            }

        }
    }

}

