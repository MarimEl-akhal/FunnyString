package org.example.decorator;

import org.example.strategy.input.InputStrategy;
import org.example.strategy.output.OutputStrategy;

public interface RouterStrategy {
    void run(InputStrategy in, OutputStrategy out);

    String getOptionName();

     default void printOptionNameBeforeRun(InputStrategy inputStrategy ,OutputStrategy outputStrategy){
         this.getOptionName();
         this.run(inputStrategy,outputStrategy);
     }
}
