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

import java.io.IOException;


public class FactoryDependency {
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
            try {
                return (T) new FunnyEntityFactory().createInstance();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else if (className == OperationRangeEntity.class) {
            try {
                return (T) new OperationRangeEntityFactory().createInstance();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else if (className == ClientRequest.class) {
            try {
                return (T) new ClientRequestFactory().createInstance();
            } catch (IOException e) {
                System.err.println(e);
            }
        } else if (className == Router.class) {
            try {
                return (T) new RouterFactory().createInstance();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else if (className == FunnyStringMapper.class) {
            try {
                return (T) new FunnyStringMapperFactory().createInstance();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else if (className == FunRangeMapper.class) {
            try {
                return (T) new FunRangeMapperFactory().createInstance();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else if (className == StringFunifierRetrieverMapper.class) {
            try {
                return (T) new StringFunifierRetrieverMapperFactory().createInstance();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else if (className == StringFunifierIdRetrieverStrategy.class) {
            try {
                return (T) new StringFunifierRetrieverFactory().createInstance();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else if (className == FunnyStringStrategy.class) {
            try {
                return (T) new FunnyStringStrategyFactory().createInstance();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else if (className == FunRangeStrategy.class) {
            try {
                return (T) new FunRangeStrategyFactory().createInstance();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        return null;
    }
}

