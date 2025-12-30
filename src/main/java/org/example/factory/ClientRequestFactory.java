package org.example.factory;

import org.example.socket_v2.server.ClientRequest;

public class ClientRequestFactory implements BaseFactory<ClientRequest>{
    private  ClientRequest clientRequest;

    @Override
    public ClientRequest createInstance() {
        if (clientRequest == null) {
            return new ClientRequest();
        }
        return clientRequest;
    }
}
