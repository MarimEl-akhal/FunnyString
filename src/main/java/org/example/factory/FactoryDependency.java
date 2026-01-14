package org.example.factory;

import org.example.Router;
import org.example.StringFunifier;
import org.example.database.DataBaseManager;

import org.example.decorator.StringComponent;
import org.example.decorator.StringDecorator;

import org.example.factory.decoratorfactory.ChainDecoratorFactory;
import org.example.factory.mapperfactory.FunRangeMapperFactory;
import org.example.factory.mapperfactory.StringFunifierRetrieverMapperFactory;
import org.example.factory.strategyfactory.*;
import org.example.mapper.FunRangeMapper;
import org.example.mapper.FunnyStringMapper;
import org.example.mapper.StringFunifierRetrieverMapper;
import org.example.operator.StringOperator;
import org.example.parsingg.Parsing;
import org.example.stringStrategy.FunRangeStrategy;
import org.example.stringStrategy.FunnyStringStrategy;
import org.example.stringStrategy.RouterStrategyContext;
import org.example.stringStrategy.StringFunifierIdRetrieverStrategy;

import java.util.HashMap;
import java.util.Map;


public class FactoryDependency {


    private static Map<Class, BaseFactory> map = new HashMap<>();

    static {
        map.put(StringOperator.class, new StringOperatorFactory());
        map.put(StringFunifier.class, new StringFunifierFactory());
        map.put(Parsing.class, new ParsingFactory());
        map.put(DataBaseManager.class, new DataBaseManagerFactory());
        map.put(Router.class, new RouterFactory());
        map.put(FunnyStringMapper.class, new FunRangeMapperFactory());
        map.put(FunRangeMapper.class, new FunRangeMapperFactory());
        map.put(StringFunifierRetrieverMapper.class, new StringFunifierRetrieverMapperFactory());
        map.put(StringFunifierIdRetrieverStrategy.class, new StringFunifierRetrieverFactory());
        map.put(FunnyStringStrategy.class, new FunnyStringStrategyFactory());
        map.put(FunRangeStrategy.class, new FunRangeStrategyFactory());
        map.put(RouterStrategyContext.class, new RouterStrategyContextFactory());
        map.put(StringComponent.class, new ChainDecoratorFactory());

    }

    public static <T> T getDependency(Class<T> className) {
        return (T) map.get(className).createInstance();
    }
}

