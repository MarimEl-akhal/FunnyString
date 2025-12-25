package org.example.factory;

import org.example.DataBaseConnection;

public class DataBaseConnectionFactory implements BaseFactory<DataBaseConnection> {
    @Override
    public DataBaseConnection createInstance() {
        return new DataBaseConnection();
    }
}
