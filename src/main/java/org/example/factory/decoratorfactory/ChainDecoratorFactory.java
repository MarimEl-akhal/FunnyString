package org.example.factory.decoratorfactory;

import org.example.decorator.*;
import org.example.factory.BaseFactory;

import java.util.List;

public class ChainDecoratorFactory implements BaseFactory<List<StringComponent>> {

    private List<StringComponent> stringComponentInterface;

    @Override
    public List<StringComponent> createInstance() {
        if (stringComponentInterface == null) {
            stringComponentInterface = List.of(new FunRangeDecorator(new FunnyStringDecorator(new StringFunifierIdRetrieverDecorator(new Basic()))));
        }

        return stringComponentInterface;
    }
}
