package org.example.factory.listBaseFactory.routerStrategyFactory;

import org.example.routerStrategyDecorator.*;
import org.example.routerStrategyDecorator.stringFunifierStrategy.FunRangeStrategy;
import org.example.routerStrategyDecorator.stringFunifierStrategy.FunnyStringStrategy;
import org.example.routerStrategyDecorator.stringFunifierStrategy.RouterStrategy;
import org.example.routerStrategyDecorator.stringFunifierStrategy.StringFunifierIdRetrieverStrategy;
import org.example.factory.listBaseFactory.ListBaseFactory;

import java.util.List;

public class RouterStrategyFactory implements ListBaseFactory<RouterStrategy> {

    private List<RouterStrategy> strategies;

    @Override
    public List<RouterStrategy> createInstance() {
        if (strategies == null) {
            strategies = List.of(
                    new LogoutDecorator(new StrategyExecutionDecorator(new LoggingDecorator(new StrategyNamePrinterDecorator(new FunnyStringStrategy())))),
                    new LogoutDecorator(new StrategyExecutionDecorator(new LoggingDecorator(new StrategyNamePrinterDecorator(new FunRangeStrategy())))),
                    new LogoutDecorator(new StrategyExecutionDecorator(new LoggingDecorator(new StrategyNamePrinterDecorator(new StringFunifierIdRetrieverStrategy()))))
            );
        }

        return strategies;
    }
}
