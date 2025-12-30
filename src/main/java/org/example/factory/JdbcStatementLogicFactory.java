//package org.example.factory;
//
//import org.example.JdbcStatementLogic;
//
//public class JdbcStatementLogicFactory implements BaseFactory<JdbcStatementLogic> {
//    private JdbcStatementLogic jdbcStatementLogic;
//
//    @Override
//    public JdbcStatementLogic createInstance() {
//        if (jdbcStatementLogic == null) {
//            return new JdbcStatementLogic();
//        }
//        return jdbcStatementLogic;
//
//    }
//}
