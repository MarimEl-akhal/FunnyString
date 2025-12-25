package org.example.factory;

import org.example.*;
import org.example.socket_v2.ClientHandler;
import org.example.socket_v2.ServerHandler;


public class FactoryDependency {
    public static <T> T getDependency(Class<T> className) {

        if (className == StringOperator.class) {
            return (T) new StringOperatorFactory().createInstance();
        } else if (className == DataBaseConnection.class) {
            return (T)  new DataBaseConnectionFactory().createInstance();
        }
        else if (className == StringFunifier.class) {
            return (T)  new StringFunifierFactory().createInstance();
        }
       else if (className == Parsing.class) {
            return (T)  new ParsingFactory().createInstance();
        }
        else if (className == JdbcStatementLogic.class) {
            return (T)  new JdbcStatementLogicFactory().createInstance();
        }
        else if (className == ClientHandler.class) {
            return (T)  new ClientHandlerFactory().createInstance();
        }
        else if (className == ServerHandler.class) {
            return (T)  new ServerHandlerFactory().createInstance();
        }

        return null;
    }
}

