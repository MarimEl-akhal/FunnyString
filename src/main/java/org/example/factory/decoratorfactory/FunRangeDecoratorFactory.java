package org.example.factory.decoratorfactory;


import org.example.decorator.FunRangeDecorator;
import org.example.decorator.RouterStrategy;
import org.example.factory.BaseFactory;

public class FunRangeDecoratorFactory implements BaseFactory<FunRangeDecorator> {
    private FunRangeDecorator funRangeDecorator;
    private RouterStrategy stringComponent;

    @Override
    public FunRangeDecorator createInstance() {
        if (funRangeDecorator == null) {
            return new FunRangeDecorator(stringComponent);
        }
        return funRangeDecorator;
    }
}
