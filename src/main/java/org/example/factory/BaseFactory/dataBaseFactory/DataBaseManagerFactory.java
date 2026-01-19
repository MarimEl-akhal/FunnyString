package org.example.factory.BaseFactory.dataBaseFactory;

import org.example.database.DataBaseManager;
import org.example.factory.BaseFactory.BaseFactory;

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
