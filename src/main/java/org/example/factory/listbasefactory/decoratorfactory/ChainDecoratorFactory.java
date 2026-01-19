package org.example.factory.listbasefactory.decoratorfactory;

import org.example.decorator.*;
import org.example.factory.listbasefactory.ListBaseFactory;

import java.util.List;

public class ChainDecoratorFactory implements ListBaseFactory<RouterStrategy> {

    private List<RouterStrategy> strategies;

    @Override
    public List<RouterStrategy> createInstance() {
        if (strategies == null) {
            strategies = List.of(
                    new LogoutDecorator(new StrategyExecutionDecorator(new LoggingDecorator(new StrategyNamePrinterDecorator(new FunnyStringDecorator())))),
                    new LogoutDecorator(new StrategyExecutionDecorator(new LoggingDecorator(new StrategyNamePrinterDecorator(new FunRangeDecorator())))),
                    new LogoutDecorator(new StrategyExecutionDecorator(new LoggingDecorator(new StrategyNamePrinterDecorator(new StringFunifierIdRetrieverDecorator()))))
            );
        }

        return strategies;
    }
}
