package org.example.decorator;

import org.example.socket_v2.server.ClientOption;
import org.example.strategy.input.InputStrategy;
import org.example.strategy.output.OutputStrategy;

public class Basic implements StringComponent {
    @Override
    public void run(InputStrategy inputStrategy, OutputStrategy outputStrategy){
        System.out.println("EXECUTE");
    }
    @Override
    public String getOptionName() {
        return ClientOption.BASE.name();
    }

}
