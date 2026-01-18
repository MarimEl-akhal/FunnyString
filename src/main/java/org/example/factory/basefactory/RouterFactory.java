package org.example.factory.basefactory;

import org.example.Router;

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
