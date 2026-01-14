package org.example.decorator;

import org.example.strategy.input.InputStrategy;
import org.example.strategy.output.OutputStrategy;

public interface StringComponent {
    void run(InputStrategy in , OutputStrategy out);
    String getOptionName();
}
