package org.example.factory;

import org.example.Service;
import org.example.StringFunifier;
import org.example.database.DataBaseManager;
import org.example.entity.FunnyStringEntity;
import org.example.entity.OperationRangeEntity;
import org.example.mapper.FunnyStringEntityMapper;
import org.example.operator.StringOperator;
import org.example.parsingg.Parsing;
import org.example.socket_v2.server.ClientRequest;

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
        } else if (className == Service.class) {
            try {
                return (T) new ServiceFactory().createInstance();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else if (className == FunnyStringEntityMapper.class) {
            try {
                return (T) new FunnyStringEntityMapperFactory().createInstance();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        return null;
    }
}

