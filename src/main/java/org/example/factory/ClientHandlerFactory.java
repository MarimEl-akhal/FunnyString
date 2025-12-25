package org.example.factory;

import org.example.socket_v2.ClientHandler;

public class ClientHandlerFactory implements BaseFactory<ClientHandler>{
    @Override
    public ClientHandler createInstance() {
        return new ClientHandler();
    }
}
