package org.example.server.string.funifier.controller.router.decorator;

import org.example.io.method.input.InputStrategy;
import org.example.io.method.output.OutputStrategy;
import org.example.server.ClientOption;
import org.example.server.string.funifier.controller.RouterStrategyInterface;

import java.io.IOException;

public abstract class RouterStrategyDecorator<REQ, RES> implements RouterStrategyInterface<REQ, RES> {
    protected RouterStrategyInterface<REQ, RES> wrapper;

    public RouterStrategyDecorator(RouterStrategyInterface<REQ, RES> routerStrategy) {
        this.wrapper = routerStrategy;
    }

    @Override
    public REQ mapInputToRequestBody(InputStrategy inputStrategy) throws IOException {
        return wrapper.mapInputToRequestBody(inputStrategy);
    }

    @Override
    public RES executeScenario(REQ request) {
        return wrapper.executeScenario(request);
    }

    @Override
    public void sendOutPutMessage(RES response, OutputStrategy outputStrategy) {
        wrapper.sendOutPutMessage(response, outputStrategy);
    }

    @Override
    public ClientOption getOptionName() {
        return wrapper.getOptionName();
    }

}