package org.example.server.string.funifier.controller;

import org.example.io.method.input.InputStrategy;
import org.example.io.method.output.OutputStrategy;
import org.example.server.ClientOption;

import java.io.IOException;

public interface RouterStrategyInterface<REQ, RES> {
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
