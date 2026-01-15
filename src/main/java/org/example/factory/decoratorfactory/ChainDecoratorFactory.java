package org.example.factory.decoratorfactory;

import org.example.decorator.*;
import org.example.factory.ListBaseFactory;

import java.util.List;

public class ChainDecoratorFactory implements ListBaseFactory<RouterStrategy> {

    private List<RouterStrategy> stringComponentInterface;

    @Override
    public List<RouterStrategy> createInstance() {
        if (stringComponentInterface == null) {
            stringComponentInterface = List.of(new OperationNamePrinterDecorator(new FunnyStringDecorator(new Basic())), new OperationNamePrinterDecorator(new FunRangeDecorator(new Basic())), new OperationNamePrinterDecorator(new StringFunifierIdRetrieverDecorator(new Basic())));
        }

        return stringComponentInterface;
    }
}
