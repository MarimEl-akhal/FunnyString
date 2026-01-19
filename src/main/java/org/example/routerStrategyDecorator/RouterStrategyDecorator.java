package org.example.routerStrategyDecorator;

import org.example.routerStrategyDecorator.stringFunifierStrategy.RouterStrategy;
import org.example.serverWithMultiClient.server.ClientOption;
import org.example.inputOutputSystem.input.InputStrategy;
import org.example.inputOutputSystem.output.OutputStrategy;

import java.io.IOException;

public abstract class RouterStrategyDecorator<REQ, RES> implements RouterStrategy<REQ, RES> {
    protected RouterStrategy<REQ, RES> wrapper;

    public RouterStrategyDecorator(RouterStrategy<REQ, RES> routerStrategy) {
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