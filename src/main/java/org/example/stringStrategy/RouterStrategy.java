package org.example.stringStrategy;

import org.example.socket_v2.server.ClientOption;
import org.example.strategy.input.InputStrategy;
import org.example.strategy.output.OutputStrategy;

import java.io.IOException;

public abstract class RouterStrategy<T, U> {
    public abstract T setInput(InputStrategy inputStrategy) throws IOException;

    public abstract U executeScenario(T request);

    public abstract void sendOutPutMessage(U response, OutputStrategy outputStrategy);

    public abstract ClientOption getOptionName();

    public void run(InputStrategy inputStrategy, OutputStrategy outputStrategy) throws IOException {
        T request = setInput(inputStrategy);
        U response = executeScenario(request);
        sendOutPutMessage(response, outputStrategy);
    }


}
