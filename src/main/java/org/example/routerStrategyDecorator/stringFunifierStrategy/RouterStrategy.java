package org.example.routerStrategyDecorator.stringFunifierStrategy;

import org.example.serverWithMultiClient.server.ClientOption;
import org.example.inputOutputSystem.input.InputStrategy;
import org.example.inputOutputSystem.output.OutputStrategy;

import java.io.IOException;

public interface RouterStrategy<REQ, RES> {
    REQ mapInputToRequestBody(InputStrategy inputStrategy) throws IOException;

    RES executeScenario(REQ request);

    void sendOutPutMessage(RES response, OutputStrategy outputStrategy);

    ClientOption getOptionName();

    default void run(InputStrategy inputStrategy, OutputStrategy outputStrategy) throws IOException {
        REQ request = mapInputToRequestBody(inputStrategy);
        RES response = executeScenario(request);
        sendOutPutMessage(response, outputStrategy);
    }


}
