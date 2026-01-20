package org.example.server.factory.dependency.list.base.factory.router.strategy.factory;

import org.example.server.factory.dependency.list.base.factory.ListBaseFactory;
import org.example.server.string.funifier.controller.router.decorator.LoggingDecorator;
import org.example.server.string.funifier.controller.router.decorator.LogoutDecorator;
import org.example.server.string.funifier.controller.router.decorator.StrategyExecutionDecorator;
import org.example.server.string.funifier.controller.router.decorator.StrategyNamePrinterDecorator;
import org.example.server.string.funifier.controller.FunRangeStrategy;
import org.example.server.string.funifier.controller.FunnyStringStrategy;
import org.example.server.string.funifier.controller.RouterStrategyInterface;
import org.example.server.string.funifier.controller.StringFunifierIdRetrieverStrategy;

import java.util.List;

public class RouterStrategyFactory implements ListBaseFactory<RouterStrategyInterface> {

    private List<RouterStrategyInterface> strategies;

    @Override
    public List<RouterStrategyInterface> createInstance() {
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
