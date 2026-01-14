package org.example.factory;

import org.example.decorator.StringComponent;
import org.example.decorator.Basic;

public class RouterStrategyDecoratorFactory implements BaseFactory<StringComponent> {
    private StringComponent routerStrategyStrategyDecorator;

    @Override
    public StringComponent createInstance() {
        if (routerStrategyStrategyDecorator == null) {
            routerStrategyStrategyDecorator = new Basic() ;
        }
        return routerStrategyStrategyDecorator;

    }
}
