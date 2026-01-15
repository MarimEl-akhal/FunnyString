package org.example.factory;

import org.example.decorator.Basic;
import org.example.decorator.RouterStrategy;

public class RouterStrategyDecoratorFactory implements BaseFactory<RouterStrategy> {
    private RouterStrategy routerStrategyStrategyDecorator;

    @Override
    public RouterStrategy createInstance() {
        if (routerStrategyStrategyDecorator == null) {
            routerStrategyStrategyDecorator = new Basic();
        }
        return routerStrategyStrategyDecorator;

    }
}
