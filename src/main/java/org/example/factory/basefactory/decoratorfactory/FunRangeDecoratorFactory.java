package org.example.factory.basefactory.decoratorfactory;


import org.example.decorator.FunRangeDecorator;
import org.example.decorator.RouterStrategy;
import org.example.factory.basefactory.BaseFactory;

public class FunRangeDecoratorFactory implements BaseFactory<FunRangeDecorator> {
    private FunRangeDecorator funRangeDecorator;
    private RouterStrategy stringComponent;

    @Override
    public FunRangeDecorator createInstance() {
        if (funRangeDecorator == null) {
            return new FunRangeDecorator();
        }
        return funRangeDecorator;
    }
}
