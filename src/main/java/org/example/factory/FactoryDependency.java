package org.example.factory;

import org.example.Router;
import org.example.StringFunifier;
import org.example.database.DataBaseManager;
import org.example.routerStrategyDecorator.stringFunifierStrategy.FunRangeStrategy;
import org.example.routerStrategyDecorator.stringFunifierStrategy.FunnyStringStrategy;
import org.example.routerStrategyDecorator.stringFunifierStrategy.RouterStrategy;
import org.example.routerStrategyDecorator.stringFunifierStrategy.StringFunifierIdRetrieverStrategy;
import org.example.factory.BaseFactory.BaseFactory;
import org.example.factory.BaseFactory.stringTokenToListParsingFactory.ParsingFactory;
import org.example.factory.BaseFactory.RouterFactory;
import org.example.factory.BaseFactory.dataBaseFactory.DataBaseManagerFactory;
import org.example.factory.BaseFactory.stringFunifierStrategyFactory.FunRangeStrategyFactory;
import org.example.factory.BaseFactory.stringFunifierStrategyFactory.FunnyStringStrategyFactory;
import org.example.factory.BaseFactory.stringFunifierStrategyFactory.StringFunifierIdRetrieverFactory;
import org.example.factory.BaseFactory.mapperFactory.FunRangeMapperFactory;
import org.example.factory.BaseFactory.mapperFactory.FunnyStringMapperFactory;
import org.example.factory.BaseFactory.mapperFactory.StringFunifierRetrieverMapperFactory;
import org.example.factory.BaseFactory.stringFunifierOperatorFactory.StringOperatorFactory;
import org.example.factory.BaseFactory.stringFunifierStrategyFactory.StringFunifierFactory;
import org.example.factory.listBaseFactory.ListBaseFactory;
import org.example.factory.listBaseFactory.routerStrategyFactory.RouterStrategyFactory;
import org.example.mapper.FunRangeMapper;
import org.example.mapper.FunnyStringMapper;
import org.example.mapper.StringFunifierRetrieverMapper;
import org.example.stringFunifierOperator.StringOperator;
import org.example.stringTokenToListParsing.Parsing;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class FactoryDependency {


    private static Map<Class, BaseFactory> map = new HashMap<>();

    private static Map<Class, ListBaseFactory> listMap = new HashMap<>();

    static {
        map.put(StringOperator.class, new StringOperatorFactory()); //BaseFactory<StringOperator> => (StringOperator)BaseFactory<StringOperator>
        map.put(StringFunifier.class, new StringFunifierFactory());
        map.put(Parsing.class, new ParsingFactory());
        map.put(DataBaseManager.class, new DataBaseManagerFactory());
        map.put(Router.class, new RouterFactory());
        map.put(FunnyStringMapper.class, new FunnyStringMapperFactory());
        map.put(FunRangeMapper.class, new FunRangeMapperFactory());
        map.put(StringFunifierRetrieverMapper.class, new StringFunifierRetrieverMapperFactory());
        map.put(FunnyStringStrategy.class, new FunnyStringStrategyFactory());
        map.put(FunRangeStrategy.class, new FunRangeStrategyFactory());
        map.put(StringFunifierIdRetrieverStrategy.class, new StringFunifierIdRetrieverFactory());

        listMap.put(RouterStrategy.class, new RouterStrategyFactory());
    }

    public static <T> T getDependency(Class<T> className) {
        return (T) map.get(className).createInstance();
    }

    public static <T> List<T> getDependencies(Class<T> className) {
        return (List<T>) listMap.get(className).createInstance();
    }
}

