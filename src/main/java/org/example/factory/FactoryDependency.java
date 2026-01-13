package org.example.factory;

import org.example.Router;
import org.example.StringFunifier;
import org.example.database.DataBaseManager;
import org.example.entity.FunnyStringEntity;
import org.example.entity.OperationRangeEntity;
import org.example.mapper.FunRangeMapper;
import org.example.mapper.FunnyStringMapper;
import org.example.mapper.StringFunifierRetrieverMapper;
import org.example.operator.StringOperator;
import org.example.parsingg.Parsing;
import org.example.socket_v2.server.ClientRequest;
import org.example.stringStrategy.FunRangeStrategy;
import org.example.stringStrategy.FunnyStringStrategy;
import org.example.stringStrategy.StringFunifierIdRetrieverStrategy;


public class FactoryDependency {
    static {
        // study static blocks
        map {
            class,dependency
        } ;
    }

    public static <T> T getDependency(Class<T> className) {

        if (className == StringOperator.class) {
            return (T) new StringOperatorFactory().createInstance();
        } else if (className == StringFunifier.class) {
            return (T) new StringFunifierFactory().createInstance();
        } else if (className == Parsing.class) {
            return (T) new ParsingFactory().createInstance();
        } else if (className == DataBaseManager.class) {
            return (T) new DataBaseManagerFactory().createInstance();
        } else if (className == FunnyStringEntity.class) {
            return (T) new FunnyEntityFactory().createInstance();
        } else if (className == OperationRangeEntity.class) {
            return (T) new OperationRangeEntityFactory().createInstance();
        } else if (className == ClientRequest.class) {
            return (T) new ClientRequestFactory().createInstance();
        } else if (className == Router.class) {
            return (T) new RouterFactory().createInstance();
        } else if (className == FunnyStringMapper.class) {
            return (T) new FunnyStringMapperFactory().createInstance();
        } else if (className == FunRangeMapper.class) {
            return (T) new FunRangeMapperFactory().createInstance();
        } else if (className == StringFunifierRetrieverMapper.class) {
            return (T) new StringFunifierRetrieverMapperFactory().createInstance();
        } else if (className == StringFunifierIdRetrieverStrategy.class) {
            return (T) new StringFunifierRetrieverFactory().createInstance();
        } else if (className == FunnyStringStrategy.class) {
            return (T) new FunnyStringStrategyFactory().createInstance();
        } else if (className == FunRangeStrategy.class) {
            return (T) new FunRangeStrategyFactory().createInstance();
        }else if (className == RouterStrategyFactory.class) {

        }

        return null;
    }
}

