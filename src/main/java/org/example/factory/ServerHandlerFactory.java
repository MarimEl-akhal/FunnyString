package org.example.factory;

import org.example.socket_v2.ServerHandler;

public class ServerHandlerFactory implements BaseFactory<ServerHandler>{
    @Override
    public ServerHandler createInstance() {
        return new ServerHandler();
    }
}
