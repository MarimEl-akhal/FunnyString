package org.example.factory;

import org.example.database.DataBaseManager;

public class DataBaseManagerFactory implements BaseFactory<DataBaseManager> {
    private DataBaseManager dbManager;

    @Override
    public DataBaseManager createInstance() {
        if (dbManager == null) {
            return new DataBaseManager();
        }
        return dbManager;

    }
}
