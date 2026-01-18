package org.example.decorator;

import org.example.socket_v2.server.ClientOption;
import org.example.strategy.input.InputStrategy;
import org.example.strategy.output.OutputStrategy;

import java.io.IOException;

public interface  RouterStrategy<T, U> {
     T setInput(InputStrategy inputStrategy) throws IOException;

     U executeScenario(T request);

     void sendOutPutMessage(U response, OutputStrategy outputStrategy);

     ClientOption getOptionName();

    default void run(InputStrategy inputStrategy, OutputStrategy outputStrategy) throws IOException {
        T request = setInput(inputStrategy);
        U response = executeScenario(request);
        sendOutPutMessage(response, outputStrategy);
    }


}
