package org.example.factory;

import org.example.Service;

import java.io.IOException;

public class ServiceFactory implements BaseFactory<Service> {
    private Service service;

    @Override
    public Service createInstance() throws IOException {
        if (service == null) {
            service = new Service();
        }
        return service;
    }
}
