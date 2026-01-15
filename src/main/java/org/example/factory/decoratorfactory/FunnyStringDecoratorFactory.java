package org.example.factory.decoratorfactory;

import org.example.decorator.FunnyStringDecorator;
import org.example.decorator.RouterStrategy;
import org.example.factory.BaseFactory;


public class FunnyStringDecoratorFactory implements BaseFactory<FunnyStringDecorator> {
    private FunnyStringDecorator funnyStringDecorator;
    private RouterStrategy stringComponent;

    @Override
    public FunnyStringDecorator createInstance() {
        if (funnyStringDecorator == null) {
            funnyStringDecorator = new FunnyStringDecorator(stringComponent);
        }
        return funnyStringDecorator;
    }
}
