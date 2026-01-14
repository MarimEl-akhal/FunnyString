package org.example.decorator;

import org.example.strategy.input.InputStrategy;
import org.example.strategy.output.OutputStrategy;

public abstract  class StringDecorator implements StringComponent {
    protected StringComponent wrapper ;

    public StringDecorator(StringComponent stringComponent){
        this .wrapper = stringComponent;
    }

    @Override
    public String getOptionName() {
        return wrapper.getOptionName();
    }

    @Override
    public void run(InputStrategy in, OutputStrategy out) {
        wrapper.run(in,out);
    }
}
