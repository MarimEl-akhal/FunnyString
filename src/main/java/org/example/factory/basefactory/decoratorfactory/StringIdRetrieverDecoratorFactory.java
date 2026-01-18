package org.example.factory.basefactory.decoratorfactory;

import org.example.decorator.RouterStrategy;
import org.example.decorator.StringFunifierIdRetrieverDecorator;
import org.example.factory.basefactory.BaseFactory;


public class StringIdRetrieverDecoratorFactory implements BaseFactory<StringFunifierIdRetrieverDecorator> {
    private StringFunifierIdRetrieverDecorator stringFunifierIdRetrieverDecorator;
    private RouterStrategy strategy;


    @Override
    public StringFunifierIdRetrieverDecorator createInstance() {
        if (stringFunifierIdRetrieverDecorator == null) {
            return new StringFunifierIdRetrieverDecorator();
        }
        return stringFunifierIdRetrieverDecorator;
    }
}
