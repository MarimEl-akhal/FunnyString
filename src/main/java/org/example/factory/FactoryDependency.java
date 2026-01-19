package org.example.factory;

import org.example.Router;
import org.example.StringFunifier;
import org.example.database.DataBaseManager;
import org.example.decorator.FunRangeDecorator;
import org.example.decorator.FunnyStringDecorator;
import org.example.decorator.RouterStrategy;
import org.example.decorator.StringFunifierIdRetrieverDecorator;
import org.example.factory.basefactory.BaseFactory;
import org.example.factory.basefactory.ParsingFactory;
import org.example.factory.basefactory.RouterFactory;
import org.example.factory.basefactory.databasefactory.DataBaseManagerFactory;
import org.example.factory.basefactory.decoratorfactory.FunRangeDecoratorFactory;
import org.example.factory.basefactory.decoratorfactory.FunnyStringDecoratorFactory;
import org.example.factory.basefactory.decoratorfactory.StringIdRetrieverDecoratorFactory;
import org.example.factory.basefactory.mapperfactory.FunRangeMapperFactory;
import org.example.factory.basefactory.mapperfactory.FunnyStringMapperFactory;
import org.example.factory.basefactory.mapperfactory.StringFunifierRetrieverMapperFactory;
import org.example.factory.basefactory.strategyfactory.*;
import org.example.factory.listbasefactory.ListBaseFactory;
import org.example.factory.listbasefactory.decoratorfactory.ChainDecoratorFactory;
import org.example.mapper.FunRangeMapper;
import org.example.mapper.FunnyStringMapper;
import org.example.mapper.StringFunifierRetrieverMapper;
import org.example.operator.StringOperator;
import org.example.parsingg.Parsing;
import org.example.stringStrategy.FunRangeStrategy;
import org.example.stringStrategy.FunnyStringStrategy;
import org.example.stringStrategy.StringFunifierIdRetrieverStrategy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class FactoryDependency {


    private static Map<Class, BaseFactory> map = new HashMap<>();

    private static Map<Class, ListBaseFactory> listMap = new HashMap<>();

    static {
        map.put(StringOperator.class, new StringOperatorFactory()); //BaseFactory<StringOperator> => (StringOperator)BaseFactory<StringOperator>
        map.put(StringFunifier.class, new StringFunifierFactory());  // BaseFactory<StringFunifier>
        map.put(Parsing.class, new ParsingFactory());
        map.put(DataBaseManager.class, new DataBaseManagerFactory());
        map.put(Router.class, new RouterFactory());
        map.put(FunnyStringMapper.class, new FunnyStringMapperFactory());
        map.put(FunRangeMapper.class, new FunRangeMapperFactory());
        map.put(StringFunifierRetrieverMapper.class, new StringFunifierRetrieverMapperFactory());
        map.put(StringFunifierIdRetrieverStrategy.class, new StringFunifierRetrieverFactory());
        map.put(FunnyStringStrategy.class, new FunnyStringStrategyFactory());
        map.put(FunRangeStrategy.class, new FunRangeStrategyFactory());
        map.put(FunnyStringDecorator.class, new FunnyStringDecoratorFactory());
        map.put(FunRangeDecorator.class, new FunRangeDecoratorFactory());
        map.put(StringFunifierIdRetrieverDecorator.class, new StringIdRetrieverDecoratorFactory());

        listMap.put(RouterStrategy.class, new ChainDecoratorFactory());
    }

    public static <T> T getDependency(Class<T> className) {
        return (T) map.get(className).createInstance();
    }

    public static <T> List<T> getDependencies(Class<T> className) {
        return (List<T>) listMap.get(className).createInstance();
    }
}

