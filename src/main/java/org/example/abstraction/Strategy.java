package org.example.abstraction;

import org.example.dto.StringFunifierRequest;
import org.example.dto.StringFunifierResponse;
import org.example.strategy.input.InputStrategy;
import org.example.strategy.output.OutputStrategy;

import java.io.IOException;

public interface Strategy {
    void setInput(InputStrategy inputStrategy) throws IOException;

    StringFunifierResponse executeScenario(StringFunifierRequest request);

    void receiveOutPutMessage(OutputStrategy outputStrategy);

    void run(InputStrategy inputStrategy, OutputStrategy outputStrategy) throws IOException;


}
