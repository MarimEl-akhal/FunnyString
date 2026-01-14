package org.example.factory;


import org.example.stringStrategy.RouterStrategyContext;



public class RouterStrategyContextFactory implements BaseFactory<RouterStrategyContext >{
    private RouterStrategyContext routerStrategy;
    @Override
    public RouterStrategyContext createInstance() {
        if (routerStrategy == null) {
            routerStrategy = new RouterStrategyContext();
        }
        return routerStrategy;
    }
}
