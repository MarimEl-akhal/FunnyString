//package org.example.factory;
//
//import org.example.database.DataBaseConnection;
//
//public class DataBaseConnectionFactory implements BaseFactory<DataBaseConnection> {
//    private DataBaseConnection dataBaseConnection;
//
//    @Override
//    public DataBaseConnection createInstance() {
//        if (dataBaseConnection == null) {
//            return new DataBaseConnection();
//        }
//        return dataBaseConnection;
//    }
//}
