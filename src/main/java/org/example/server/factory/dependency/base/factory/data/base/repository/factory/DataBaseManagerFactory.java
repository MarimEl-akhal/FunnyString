package org.example.server.factory.dependency.base.factory.data.base.repository.factory;

import org.example.server.repository.DataBaseManager;
import org.example.server.factory.dependency.base.factory.BaseFactory;

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
