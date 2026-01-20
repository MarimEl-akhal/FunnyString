package org.example.server.factory.dependency.base.factory.service.factory;

import org.example.server.factory.dependency.base.factory.BaseFactory;
import org.example.server.service.Router;

public class RouterFactory implements BaseFactory<Router> {
    private Router router;

    @Override
    public Router createInstance() {
        if (router == null) {
            router = new Router();
        }
        return router;
    }
}
