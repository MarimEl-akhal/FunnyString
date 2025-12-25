package org.example.factory;

import org.example.JdbcStatementLogic;

public class JdbcStatementLogicFactory implements BaseFactory<JdbcStatementLogic> {
    @Override
    public JdbcStatementLogic createInstance() {
        return new JdbcStatementLogic();
    }
}
