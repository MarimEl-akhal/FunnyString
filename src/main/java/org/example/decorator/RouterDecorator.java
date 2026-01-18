package org.example.decorator;

import org.example.socket_v2.server.ClientOption;
import org.example.strategy.input.InputStrategy;
import org.example.strategy.output.OutputStrategy;

import java.io.IOException;

public abstract class RouterDecorator<T,U> implements RouterStrategy<T,U> {
    protected RouterStrategy <T,U> wrapper;

    public RouterDecorator(RouterStrategy routerStrategy) {
        this.wrapper = routerStrategy;
    }

    @Override
    public T setInput(InputStrategy inputStrategy) throws IOException {
        return wrapper.setInput(inputStrategy);
    }

    @Override
    public U executeScenario(T request) {
        return wrapper.executeScenario(request);
    }

    @Override
    public void sendOutPutMessage(U response, OutputStrategy outputStrategy) {
        wrapper.sendOutPutMessage(response, outputStrategy);
    }

    @Override
    public ClientOption getOptionName() {
        return wrapper.getOptionName();
    }

}