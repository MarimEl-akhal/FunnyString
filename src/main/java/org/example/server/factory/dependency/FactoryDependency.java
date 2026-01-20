package org.example.server.factory.dependency;

import org.example.server.service.Router;
import org.example.server.service.StringFunifier;
import org.example.server.repository.DataBaseManager;
import org.example.server.factory.dependency.base.factory.BaseFactory;
import org.example.server.factory.dependency.base.factory.service.factory.RouterFactory;
import org.example.server.factory.dependency.base.factory.data.base.repository.factory.DataBaseManagerFactory;
import org.example.server.factory.dependency.base.factory.mapper.factory.FunRangeMapperFactory;
import org.example.server.factory.dependency.base.factory.mapper.factory.FunnyStringMapperFactory;
import org.example.server.factory.dependency.base.factory.mapper.factory.StringFunifierRetrieverMapperFactory;
import org.example.server.factory.dependency.base.factory.string.funifier.operator.factory.StringOperatorFactory;
import org.example.server.factory.dependency.base.factory.string.funifier.strategy.factory.FunRangeStrategyFactory;
import org.example.server.factory.dependency.base.factory.string.funifier.strategy.factory.FunnyStringStrategyFactory;
import org.example.server.factory.dependency.base.factory.service.factory.StringFunifierFactory;
import org.example.server.factory.dependency.base.factory.string.funifier.strategy.factory.StringFunifierIdRetrieverFactory;
import org.example.server.factory.dependency.base.factory.string.funifier.parser.factory.ParsingFactory;
import org.example.server.factory.dependency.list.base.factory.ListBaseFactory;
import org.example.server.factory.dependency.list.base.factory.router.strategy.factory.RouterStrategyFactory;
import org.example.server.mapper.FunRangeMapper;
import org.example.server.mapper.FunnyStringMapper;
import org.example.server.mapper.StringFunifierRetrieverMapper;
import org.example.server.service.operator.StringOperator;
import org.example.server.string.funifier.controller.FunRangeStrategy;
import org.example.server.string.funifier.controller.FunnyStringStrategy;
import org.example.server.string.funifier.controller.RouterStrategyInterface;
import org.example.server.string.funifier.controller.StringFunifierIdRetrieverStrategy;
import org.example.parser.Parser;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class FactoryDependency {


    private static final Map<Class, BaseFactory> map = new HashMap<>();

    private static final Map<Class, ListBaseFactory> listMap = new HashMap<>();

    static {
        map.put(StringOperator.class, new StringOperatorFactory()); //BaseFactory<StringOperator> => (StringOperator)BaseFactory<StringOperator>
        map.put(StringFunifier.class, new StringFunifierFactory());
        map.put(Parser.class, new ParsingFactory());
        map.put(DataBaseManager.class, new DataBaseManagerFactory());
        map.put(Router.class, new RouterFactory());
        map.put(FunnyStringMapper.class, new FunnyStringMapperFactory());
        map.put(FunRangeMapper.class, new FunRangeMapperFactory());
        map.put(StringFunifierRetrieverMapper.class, new StringFunifierRetrieverMapperFactory());
        map.put(FunnyStringStrategy.class, new FunnyStringStrategyFactory());
        map.put(FunRangeStrategy.class, new FunRangeStrategyFactory());
        map.put(StringFunifierIdRetrieverStrategy.class, new StringFunifierIdRetrieverFactory());

        listMap.put(RouterStrategyInterface.class, new RouterStrategyFactory());
    }

    public static <T> T getDependency(Class<T> className) {
        return (T) map.get(className).createInstance();
    }

    public static <T> List<T> getDependencies(Class<T> className) {
        return (List<T>) listMap.get(className).createInstance();
    }
}

