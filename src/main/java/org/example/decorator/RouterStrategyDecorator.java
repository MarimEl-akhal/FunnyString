package org.example.decorator;

import org.example.socket_v2.server.ClientOption;
import org.example.stringStrategy.RouterStrategy;

public abstract class RouterStrategyDecorator extends RouterStrategy {
    protected RouterStrategy routerStrategy;

    public RouterStrategyDecorator(RouterStrategy routerStrategy) {
        this.routerStrategy = routerStrategy;
    }

    @Override
    public  ClientOption getOptionName(){
        return routerStrategy.getOptionName();
    }
}
