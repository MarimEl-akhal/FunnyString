package org.example;

import jdk.dynalink.beans.StaticClass;
import org.checkerframework.checker.units.qual.C;

public class FactoryDependency {
    private static StringOperator operator;
    private static DataBaseConnection dbConnection;
    private static StringFunifier stringFunifier;
    private static Parsing parsing;
    private static JdbcStatementLogic jdbcStatementLogic;
    private static ClientRequest client;
    private static ServerResponse response;

    private static Server2 server;
    private static Client2 client2;

    public static <T> T getDependency(Class<T> className) {
        if (className == StringOperator.class) {
            if (operator == null) {
                operator = new StringOperator();
            }
            return (T) operator;
        }
        if (className == DataBaseConnection.class) {
            if (dbConnection == null) {
                dbConnection = new DataBaseConnection();
            }
            return (T) dbConnection;
        }
        if (className == StringFunifier.class) {
            if (stringFunifier == null) {
                stringFunifier = new StringFunifier();
            }
            return (T) stringFunifier;
        }
        if (className == Parsing.class) {
            if (parsing == null) {
                parsing = new Parsing();
            }
            return (T) parsing;
        }
        if (className == JdbcStatementLogic.class) {
            if (jdbcStatementLogic == null) {
                jdbcStatementLogic = new JdbcStatementLogic();
            }
            return (T) jdbcStatementLogic;
        }
        if (className == ClientRequest.class) {
            if (client == null) {
                client = new ClientRequest();
            }
            return (T) client;
        }
        if (className == ServerResponse.class) {
            if (response == null) {
                response = new ServerResponse();
            }
            return (T) response;
        }
        return null;
    }
}

